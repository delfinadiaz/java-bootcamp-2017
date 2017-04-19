package ShoppingCart.Service;

import java.util.List;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ShoppingCart.DaoImp.ShoppingCartDaoImp;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.ServiceImp.ShoppingCartImp;

public class ShoppingCartImpTest {

	@Mock
	ShoppingCartDaoImp cartDao;
	@Mock
	ShoppingCartEntity cart;
	
	@InjectMocks
	ShoppingCartImp cartService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
}
