package ShoppingCart.Service;

import static org.junit.Assert.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import ShoppingCart.DaoImp.UserDaoImp;
import ShoppingCart.Model.Entities.User;
import ShoppingCart.ServiceImp.UserServiceImp;

public class UserServiceImpTest {
	
	@Mock
	UserDaoImp userDao;
	@Mock
	User user;
	@Mock
	List<User> listUsers;
	
	@InjectMocks
	UserServiceImp userService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void whenCreateUserSuccessfullyThenUserDaoIsCalledAndReturnsTrue() {
		Mockito.when(userDao.createUser(user)).thenReturn(true);
		assertTrue(userService.createUser(user));
		verify(userDao, times(1)).createUser(user);
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenUserCantBeCreatedThenUserDaoIsCalledAndReturnsFalse() {
		Mockito.when(userDao.createUser(user)).thenReturn(false);
		assertFalse(userService.createUser(user));
		verify(userDao, times(1)).createUser(user);
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenGetUserSuccessfullyThenUserDaoIsCalledAndReturnsTheUser() {
		Mockito.when(userDao.getUser(1)).thenReturn(user);
		assertEquals(user, userService.getUser(1));
		verify(userDao, times(1)).getUser(1);
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenCantGetUserThenUserDaoIsCalledAndReturnsNull() {
		Mockito.when(userDao.getUser(1)).thenReturn(null);
		assertNull(userService.getUser(1));
		verify(userDao, times(1)).getUser(1);
		verifyNoMoreInteractions(userDao);
	}

	
	@Test
	public void whenUsernameExistsThenUserDaoIsCalledAndReturnsTheUser() {
		Mockito.when(userDao.userExists("delfi")).thenReturn(user);
		assertEquals(user, userService.userExists("delfi"));
		verify(userDao, times(1)).userExists("delfi");
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenUsernameDoesntExistThenUserDaoIsCalledAndReturnsNull() {
		Mockito.when(userDao.userExists("delfi")).thenReturn(null);
		assertNull(userService.userExists("delfi"));
		verify(userDao, times(1)).userExists("delfi");
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenRemoveUserSuccessfullyThenUserDaoIsCalledAndReturnsTrue() {
		Mockito.when(userDao.removeUser(user)).thenReturn(true);
		assertTrue(userService.removeUser(user));
		verify(userDao, times(1)).removeUser(user);
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenCantRemoveUserThenUserDaoIsCalledAndReturnsFalse() {
		Mockito.when(userDao.removeUser(user)).thenReturn(false);
		assertFalse(userService.removeUser(user));
		verify(userDao, times(1)).removeUser(user);
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenGetUsersSuccessfullyThenUserDaoIsCalledAndReturnsListOfUsers() {
		Mockito.when(userDao.getUsers()).thenReturn(listUsers);
		assertEquals(listUsers, userService.getUsers());
		verify(userDao, times(1)).getUsers();
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenCantGetUsersThenUserDaoIsCalledAndReturnsNull() {
		Mockito.when(userDao.getUsers()).thenReturn(null);
		assertNull(userService.getUsers());
		verify(userDao, times(1)).getUsers();
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenUpdateUsersSuccessfullyThenUserDaoIsCalledAndReturnsTrue() {
		Mockito.when(userDao.updateUser(user)).thenReturn(true);
		assertTrue(userService.updateUser(user));
		verify(userDao, times(1)).updateUser(user);
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenUserCantBeUpdatedThenUserDaoIsCalledAndReturnsFalse() {
		Mockito.when(userDao.updateUser(user)).thenReturn(false);
		assertFalse(userService.updateUser(user));
		verify(userDao, times(1)).updateUser(user);
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenGetUserByNameSuccessfullyThenUserDaoIsCalledAndReturnsTheUser() {
		Mockito.when(userDao.getUserByName("delfina")).thenReturn(user);
		assertEquals(user, userService.getUserByName("delfina"));
		verify(userDao, times(1)).getUserByName("delfina");
		verifyNoMoreInteractions(userDao);
	}
	
	@Test
	public void whenCantGetUserByNameThenUserDaoIsCalledAndReturnsNull() {
		Mockito.when(userDao.getUserByName("delfina")).thenReturn(null);
		assertNull(userService.getUserByName("delfina"));
		verify(userDao, times(1)).getUserByName("delfina");
		verifyNoMoreInteractions(userDao);
	}
}
