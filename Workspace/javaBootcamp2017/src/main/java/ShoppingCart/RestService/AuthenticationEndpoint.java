package ShoppingCart.RestService;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.dozer.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import javax.crypto.KeyGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

import ShoppingCart.JWTTokenNeeded;
import ShoppingCart.Dto.UserDTO.ListUserDTO;
import ShoppingCart.Dto.UserDTO.UserCredentialDTO;
import ShoppingCart.Dto.UserDTO.UserDTO;
import ShoppingCart.Model.Entities.User;
import ShoppingCart.Service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@RestController
@RequestMapping("/authentication")
public class AuthenticationEndpoint {
	
	 @Inject
	    private KeyGenerator keyGenerator;
	 @Context
	    UriInfo uriInfo;
	 
	  private UserService userService;
	  
		@Autowired
		public AuthenticationEndpoint(UserService userService){
			this.userService=userService;
		}

		 @SuppressWarnings({ "rawtypes", "unchecked" })
			@RequestMapping(method = RequestMethod.POST)
		    @Produces(MediaType.APPLICATION_JSON)
			public ResponseEntity authenticateUser(@RequestBody UserCredentialDTO credentialDTO) throws JsonProcessingException {
				User user = userService.userExists(credentialDTO.getUsername());
				if (user == null) {
					return new ResponseEntity("The username does not exist", HttpStatus.NOT_FOUND);
				}
				if (user.getPassword().equals(credentialDTO.getPassword())) {
		
					// Issue a token for the user
					String token = issueToken(credentialDTO.getUsername());
		
					// Return the token on the response
					return new ResponseEntity(token, HttpStatus.OK);
		
				} else {
					return new ResponseEntity("Username or Password incorrect", HttpStatus.UNAUTHORIZED);
		
				}
			}

		    private String issueToken(String username) {
		    	Key key = MacProvider.generateKey();
		        String jwtToken = Jwts.builder()
		                .setSubject(username)
		                .signWith(SignatureAlgorithm.HS512, key)
		                .compact();
		        return jwtToken;
		    }
		    
		    
}
