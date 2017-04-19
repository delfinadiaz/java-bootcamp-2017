package ShoppingCart.RestService;



import java.util.ArrayList;
import java.util.List;


import org.dozer.Mapper;
import org.dozer.inject.Inject;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ShoppingCart.RestService.UserRestService;
import ShoppingCart.Service.UserService;
import ShoppingCart.AppConfig;
import ShoppingCart.Dto.UserDTO.ListUserDTO;
import ShoppingCart.Dto.UserDTO.UserDTO;
import ShoppingCart.Entities.User;
import ShoppingCart.Mapper.UserMapper;


@RunWith(PowerMockRunner.class)
@ContextConfiguration(
	    classes = { AppConfig.class })
@PrepareForTest({UserService.class,User.class,UserDTO.class,UserMapper.class,ListUserDTO.class,UserRestService.class})
public class UserRestServiceTest {
	@Mock
	UserService service;
	@Mock
	User user;
	@Mock
	User anotherUser;
	@Mock
	UserDTO userDTO;
	@Mock
	ListUserDTO listUserDTO;
	
	
	@InjectMocks
	@Autowired
    private UserRestService userRestService;
	
	
	@InjectMocks
	@Inject
	private DozerBeanMapperFactoryBean dozerBean;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(user.getName()).thenReturn("delfina");
		Mockito.when(user.getUsername()).thenReturn("delfi");
		Mockito.when(user.getPassword()).thenReturn("1234");
		Mockito.when(user.getEmail()).thenReturn("delfi@gmail.com");
		Mockito.when(user.getCreditNumber()).thenReturn(43534);
		mockMvc = MockMvcBuilders
                .standaloneSetup(userRestService)
                .build();
	}
	
	@After
	public void checkMockito() {
	  Mockito.validateMockitoUsage();
	}
	
	@Test
	public void whenGetAllUsersSuccessfullyThenReturnsStatus200() throws Exception {
		List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(anotherUser);
		PowerMockito.mockStatic(UserMapper.class);
		Mockito.when(UserMapper.convertToListDTO(list)).thenReturn(listUserDTO);
		Mockito.when(service.getUsers()).thenReturn(list);
        mockMvc.perform(get("/user")).andExpect(status().isOk());
        verify(service, times(1)).getUsers();
		verifyNoMoreInteractions(service);

	}
/*	
	@Test
	public void whenGetAllUsersSuccessfullyThenReturnsDToListUserFields() throws Exception {
		Mockito.when(anotherUser.getName()).thenReturn("rocio");
		Mockito.when(anotherUser.getUsername()).thenReturn("rochi");
		Mockito.when(anotherUser.getPassword()).thenReturn("1234");
		Mockito.when(anotherUser.getEmail()).thenReturn("rochi@gmail.com");
		Mockito.when(anotherUser.getCreditNumber()).thenReturn(43534);
		 List<User> list = new ArrayList<User>();
	        list.add(user);
	        list.add(anotherUser);
		Mockito.when(service.getUsers()).thenReturn(list);
        mockMvc.perform(get("/user"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		   .andExpect(jsonPath("total", is(2)))
           .andExpect(jsonPath("users[0].name", is("delfina")))
           .andExpect(jsonPath("users[0].username", is("delfi")))
           .andExpect(jsonPath("users[0].password", is("1234")))
           .andExpect(jsonPath("users[0].email", is("delfi@gmail.com")))
           .andExpect(jsonPath("users[0].creditNumber", is(43534)))
	        .andExpect(jsonPath("users[1].name", is("rocio")))
	        .andExpect(jsonPath("users[1].username", is("rochi")))
	        .andExpect(jsonPath("users[1].password", is("1234")))
	        .andExpect(jsonPath("users[1].email", is("rochi@gmail.com")))
	        .andExpect(jsonPath("users[1].creditNumber", is(43534)));

		verify(service, times(1)).getUsers();
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenNoUsersFoundThenReturnsStatus404() throws Exception {
        List<User> list = new ArrayList<User>();
		Mockito.when(service.getUsers()).thenReturn(list);
        mockMvc.perform(get("/user")).andExpect(status().isNotFound());
        verify(service, times(1)).getUsers();
		verifyNoMoreInteractions(service);

	}
	
	
	@Test
	public void whenGetUserExistsThenReturnsStatus200() throws Exception {

		Mockito.when(service.getUser(1)).thenReturn(user);

		mockMvc.perform(get("/user/{idUser}",1)).andExpect(status().isOk());

		verify(service, times(1)).getUser(1);
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenGetUserExistsThenReturnsUserDTOFields() throws Exception {

		Mockito.when(service.getUser(1)).thenReturn(user);
        mockMvc.perform(get("/user/{idUser}",1))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
           .andExpect(jsonPath("name", is("delfina")))
           .andExpect(jsonPath("username", is("delfi")))
           .andExpect(jsonPath("password", is("1234")))
           .andExpect(jsonPath("email", is("delfi@gmail.com")))
           .andExpect(jsonPath("creditNumber", is(43534)));

		verify(service, times(1)).getUser(1);
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenGetUserDoesntExistThenReturnsStatus404() throws Exception {

		Mockito.when(service.getUser(1)).thenReturn(null);

		mockMvc.perform(get("/user/{idUser}",1)).andExpect(status().isNotFound());

		verify(service, times(1)).getUser(1);
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenGetUserByNameExistsThenReturnsStatus200() throws Exception {

		Mockito.when(service.getUserByName("delfina")).thenReturn(user);

		mockMvc.perform(get("/user/name/{name}","delfina")).andExpect(status().isOk());

		verify(service, times(1)).getUserByName("delfina");
		verifyNoMoreInteractions(service);

	}
	@Test
	public void whenGetUserByNameExistsThenReturnsUserDTOFields() throws Exception {
		Mockito.when(service.getUserByName("delfina")).thenReturn(user);
        mockMvc.perform(get("/user/name/{name}","delfina"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
           .andExpect(jsonPath("name", is("delfina")))
           .andExpect(jsonPath("username", is("delfi")))
           .andExpect(jsonPath("password", is("1234")))
           .andExpect(jsonPath("email", is("delfi@gmail.com")))
           .andExpect(jsonPath("creditNumber", is(43534)));

        verify(service, times(1)).getUserByName("delfina");
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenGetUserByNameDoesntExistThenReturnsStatus404() throws Exception {
		Mockito.when(service.getUserByName("bruno")).thenReturn(null);

		mockMvc.perform(get("/user/name/{name}","bruno")).andExpect(status().isNotFound());

		verify(service, times(1)).getUserByName("bruno");
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenGetUserByUsernameExistsThenReturnsStatus200() throws Exception {

		
		Mockito.when(service.userExists("delfi")).thenReturn(user);

		mockMvc.perform(get("/user/username/{username}","delfi")).andExpect(status().isOk());

		verify(service, times(1)).userExists("delfi");
		verifyNoMoreInteractions(service);

	}
	
	
	@Test
	public void whenGetUserByUsernameExistsThenReturnsUserDTOFields() throws Exception {

		Mockito.when(service.userExists("delfi")).thenReturn(user);
        mockMvc.perform(get("/user/username/{username}","delfi"))
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
           .andExpect(jsonPath("name", is("delfina")))
           .andExpect(jsonPath("username", is("delfi")))
           .andExpect(jsonPath("password", is("1234")))
           .andExpect(jsonPath("email", is("delfi@gmail.com")))
           .andExpect(jsonPath("creditNumber", is(43534)));

		verify(service, times(1)).userExists("delfi");
		verifyNoMoreInteractions(service);

	}
	
	
	@Test
	public void whenGetUserByUsernameDoesntExistThenReturnsStatus404() throws Exception {
		Mockito.when(service.userExists("del")).thenReturn(null);

		mockMvc.perform(get("/user/username/{username}","del")).andExpect(status().isNotFound());

		verify(service, times(1)).userExists("del");
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenUserIsSuccessfullyCreatedThenReturnsStatus201() throws Exception {
        UserDTO userdto = new UserDTO("delfina","delfi","123","delfi@gmail.com",32113);
		User anUser = new User("delfina","delfi","123","delfi@gmail.com",32113);
		Mockito.when(service.userExists("delfi")).thenReturn(null);
	    Mockito.when(service.createUser(refEq(anUser))).thenReturn(true);
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userdto))
        		).andExpect(status().isCreated());
        verify(service, times(1)).userExists("delfi");
		verify(service, times(1)).createUser(refEq(anUser));
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenUserCantBeCreatedThenReturnsStatus409() throws Exception {
        UserDTO userdto = new UserDTO("delfina","delfi","123","delfi@gmail.com",32113);
		User anUser = new User("delfina","delfi","123","delfi@gmail.com",32113);
		Mockito.when(service.userExists("delfi")).thenReturn(null);
	    Mockito.when(service.createUser(refEq(anUser))).thenReturn(false);
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userdto))
        		).andExpect(status().isConflict());
        verify(service, times(1)).userExists("delfi");
		verify(service, times(1)).createUser(refEq(anUser));
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenUsernameOfUserToCreateAlreadyExistsThenReturnsStatus409() throws Exception {
        UserDTO userdto = new UserDTO("delfina","delfi","123","delfi@gmail.com",32113);
		Mockito.when(service.userExists("delfi")).thenReturn(user);
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userdto))
        		).andExpect(status().isConflict());
        verify(service, times(1)).userExists("delfi");;
		verifyNoMoreInteractions(service);

	}
	
	@Test
	public void whenRemoveUserDoesntExistThenReturnsStatus404()throws Exception{
		Mockito.when(service.getUser(1)).thenReturn(null);
		mockMvc.perform(delete("/user/{idUser}",1)).andExpect(status().isNotFound());
		verify(service, times(1)).getUser(1);
		verifyNoMoreInteractions(service);
		
	}
	
	@Test
	public void whenUserIsSuccessfullyRemovedThenReturnsStatus200()throws Exception{
		Mockito.when(service.getUser(1)).thenReturn(user);
		Mockito.when(service.removeUser(user)).thenReturn(true);
		mockMvc.perform(delete("/user/{idUser}",1)).andExpect(status().isOk());
		verify(service, times(1)).getUser(1);
		verify(service,times(1)).removeUser(user);
		verifyNoMoreInteractions(service);
		
	}
	
	@Test
	public void whenUserCantBeRemovedThenReturnsStatus409()throws Exception{
		Mockito.when(service.getUser(1)).thenReturn(user);
		Mockito.when(service.removeUser(user)).thenReturn(false);
		mockMvc.perform(delete("/user/{idUser}",1)).andExpect(status().isConflict());
		verify(service, times(1)).getUser(1);
		verify(service,times(1)).removeUser(user);
		verifyNoMoreInteractions(service);
		
	}
	
	@Test
	public void whenUpdateUserDoesntExistThenReturnsStatus404() throws Exception {
		UserDTO userdto = new UserDTO("delfina", "rochi", "123", "delfi@gmail.com", 32113);
		Mockito.when(service.getUser(1)).thenReturn(null);
		mockMvc.perform(put("/user/{idUser}",1).contentType(MediaType.APPLICATION_JSON).content(asJsonString(userdto)))
				.andExpect(status().isNotFound());
		verify(service, times(1)).getUser(1);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void whenUpdateUserNewUsernameAlreadyExistsThenReturnsStatus409() throws Exception {
		UserDTO userdto = new UserDTO("delfina", "rochi", "123456", "delfi@gmail.com", 32113);
		Mockito.when(service.getUser(1)).thenReturn(user);
		Mockito.when(service.userExists("rochi")).thenReturn(anotherUser);
		mockMvc.perform(put("/user/{idUser}",1).contentType(MediaType.APPLICATION_JSON).content(asJsonString(userdto)))
				.andExpect(status().isConflict());
		verify(service, times(1)).getUser(1);
		verify(service, times(1)).userExists("rochi");
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void whenUserCantBeUpdatedThenReturnsStatus409() throws Exception {
		UserDTO userdto = new UserDTO("delfina", "del", "123456", "delfi@gmail.com", 32113);
		User anUser = new User("delfina","del","123456","delfi@gmail.com",32113);
		Mockito.when(service.getUser(1)).thenReturn(anUser);
		Mockito.when(service.userExists("del")).thenReturn(null);
		Mockito.when(service.updateUser(refEq(anUser))).thenReturn(false);
		mockMvc.perform(put("/user/{idUser}",1).contentType(MediaType.APPLICATION_JSON).content(asJsonString(userdto)))
				.andExpect(status().isConflict());
		verify(service, times(1)).getUser(1);
		verify(service, times(1)).userExists("del");
		verify(service, times(1)).updateUser(refEq(anUser));
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void whenUserIsSuccessfullyUpdatedThenReturnsStatus200() throws Exception {
		UserDTO userdto = new UserDTO("delfina", "del", "123456", "delfi@gmail.com", 32113);
		User anUser = new User("delfina","del","123456","delfi@gmail.com",32113);
		Mockito.when(service.getUser(1)).thenReturn(anUser);
		Mockito.when(service.userExists("del")).thenReturn(null);
		Mockito.when(service.updateUser(refEq(anUser))).thenReturn(true);
		mockMvc.perform(put("/user/{idUser}",1).contentType(MediaType.APPLICATION_JSON).content(asJsonString(userdto)))
				.andExpect(status().isOk());
		verify(service, times(1)).getUser(1);
		verify(service, times(1)).userExists("del");
		verify(service, times(1)).updateUser(refEq(anUser));
		verifyNoMoreInteractions(service);
	}
	*/
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
