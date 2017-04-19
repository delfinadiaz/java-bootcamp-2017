package ShoppingCart.RestService;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ShoppingCart.Dto.UserDTO.ListUserDTO;
import ShoppingCart.Dto.UserDTO.UserDTO;
import ShoppingCart.Entities.User;
import ShoppingCart.Mapper.UserMapper;
import ShoppingCart.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestService {
	
    private UserService userService;
    private UserDTO userDTO;
	
	@Autowired
	public UserRestService(UserService userService){
		this.userService=userService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getAllUsers() throws JsonProcessingException {
        
		List<User> users = userService.getUsers();
		if (users.isEmpty()) {
			return new ResponseEntity("No users found", HttpStatus.NOT_FOUND);
		}
		else{
			ListUserDTO listUserDTO= null;
			try {
				listUserDTO = UserMapper.convertToListDTO(users);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			return new ResponseEntity(listUserDTO, HttpStatus.OK);
		}
	}
	
	/*
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getUser(@PathVariable int idUser) throws JsonProcessingException {
        
		User user = userService.getUser(idUser);
		if (user == null) {
			return new ResponseEntity("No user found with id" + idUser, HttpStatus.NOT_FOUND);
		}
		else{
			try {
				this.setUserMapper(new UserMapper(dozerBean.getObject()));
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			UserDTO userDTO = getUserMapper().convertToDTO(user);			
			return new ResponseEntity(userDTO, HttpStatus.OK);
		}
	}*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getUserByName(@PathVariable String name) throws JsonProcessingException {
        
		User user = userService.getUserByName(name);
		if (user == null) {
			return new ResponseEntity("No user found with name " + name, HttpStatus.NOT_FOUND);
		}
		else{
			userDTO = new UserDTO(user.getName(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCreditNumber());
			return new ResponseEntity(userDTO, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/username/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getUserByUsername(@PathVariable String username) throws JsonProcessingException {
        
		User user = userService.userExists(username);
		if (user == null) {
			return new ResponseEntity("No user found with username " +username, HttpStatus.NOT_FOUND);
		}
		else{
			userDTO = new UserDTO(user.getName(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCreditNumber());
			return new ResponseEntity(userDTO, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity saveUser(@RequestBody UserDTO userDTO) throws JsonProcessingException {
		User olduser= userService.userExists(userDTO.getUsername());
        if (!(olduser == null)){
        	return new ResponseEntity("The username already exists, try again with a different one", HttpStatus.CONFLICT);
        }
        User user= new User(userDTO.getName(),userDTO.getUsername(),userDTO.getPassword(),userDTO.getEmail(),userDTO.getCreditNumber());
		boolean created = userService.createUser(user);
		if (created) {
			return new ResponseEntity("The user was successfully created",HttpStatus.CREATED);
		}
		else{
			return new ResponseEntity("The user could not be created", HttpStatus.CONFLICT);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idUser}")
	public ResponseEntity removeUser(@PathVariable int idUser) throws JsonProcessingException {

		User user = userService.getUser(idUser);
		if (user == null) {
			return new ResponseEntity("No user found with id " + idUser, HttpStatus.NOT_FOUND);
		}

		boolean deleted = userService.removeUser(user);
		if (deleted) {
			return new ResponseEntity("The user was successfully deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity("The user could not be deleted", HttpStatus.CONFLICT);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.PUT, value = "/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity updateUser(@PathVariable int idUser, @RequestBody UserDTO userDTOUpdated) throws JsonProcessingException {

		User user = userService.getUser(idUser);
		if (user == null) {
			return new ResponseEntity("No user found with id " + idUser, HttpStatus.NOT_FOUND);
		}
		// If the user changed his username then the new one has to be unique
		if (user.getUsername() != userDTOUpdated.getUsername()) {
			User olduser = userService.userExists(userDTOUpdated.getUsername());
			if (!(olduser == null)) {
				return new ResponseEntity("The new username already exists, try again with a different one", HttpStatus.CONFLICT);
			}
		}
		user.setName(userDTOUpdated.getName());
		user.setUsername(userDTOUpdated.getUsername());
		user.setPassword(userDTOUpdated.getPassword());
		user.setEmail(userDTOUpdated.getEmail());
		user.setCreditNumber(userDTOUpdated.getCreditNumber());
		Boolean updated = userService.updateUser(user);
		if (updated) {
			return new ResponseEntity("The user was successfully updated", HttpStatus.OK);
		} else {
			return new ResponseEntity("The user could not be updated", HttpStatus.CONFLICT);
		}

	}


}
