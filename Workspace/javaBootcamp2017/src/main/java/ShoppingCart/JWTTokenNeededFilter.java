package ShoppingCart;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.ws.rs.ext.Provider;

import org.dozer.inject.Inject;

import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.MacProvider;

@JWTTokenNeeded
@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {
	
	@Inject
    private Logger logger;
 
    
    public void filter(ContainerRequestContext requestContext) throws IOException {
 
        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
 
        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();
        try {
            // Validate the token
        	Key key = MacProvider.generateKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            logger.log(Level.INFO, "#### valid token : " + token);	
 
        } catch (Exception e) {
        	logger.log(Level.SEVERE, "#### invalid token : " + token);	
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

	@Override
	public ContainerRequest filter(ContainerRequest arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}