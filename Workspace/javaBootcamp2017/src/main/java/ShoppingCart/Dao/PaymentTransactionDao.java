package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Entities.PaymentTransaction;
import ShoppingCart.Entities.User;

public interface PaymentTransactionDao {
	
	public void CreatePaymentTransaction(double anAmount, String aPaymentMethod, User anUser);
	public List<PaymentTransaction> getTransactions();
}
