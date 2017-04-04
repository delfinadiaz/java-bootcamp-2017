package Clase4Services.ServiceImp.PaymentImp;

import java.util.Iterator;
import java.util.List;

import Clase4Services.Service.Payment;
import Clase4Services.ServiceImp.User;
import Clase4Services.ServiceImp.ItemOfferImp.IndividualItem;
import Clase4Services.ServiceImp.MarketImp.Market;

public class CashPayment implements Payment{

	private static int paymentID;
    private double amount;
    
    public CashPayment(){
    	paymentID = new Counter().generateUniqueID();
    }
    
    
    @Override
	public int getPaymentID() {
		// TODO Auto-generated method stub
		return paymentID;
	}
    
	@Override
	public boolean buy(User user, List<IndividualItem> cart, double partialPrice) {
		// TODO Auto-generated method stub
		try { 
			applyDiscount(partialPrice, cart);
			PaymentTransaction aPaymentTransaction= new PaymentTransaction(paymentID, amount,"Cash");
			savePaymentTransaction(aPaymentTransaction,user.getMarket());
			System.out.printf( "Transaction Number %d - Amount paid in cash: $%f %n",paymentID,amount);
			return true;
		}
		catch (PaymentException e) {
            e.printStackTrace();
            return false;
        }
	}

	private void applyDiscount(double partialPrice, List<IndividualItem> cart) {
		// TODO Auto-generated method stub
		double total;
		double mostExpensiveItemPrice;
		if (cart.size() > 1 ){
			mostExpensiveItemPrice = getPriceMostExpensiveItem(cart);
		}
		else {
			mostExpensiveItemPrice = cart.get(0).getPrice();
		}
		total = (partialPrice - (mostExpensiveItemPrice * 0.90));
		setAmount(total);	
	}

	private double getPriceMostExpensiveItem(List<IndividualItem> cart) {
		// TODO Auto-generated method stub
		double maxPrice = cart.get(0).getPrice();
		Iterator<IndividualItem> it = cart.listIterator();
		while (it.hasNext()) {
			IndividualItem item = it.next();
		   if (item.getPrice() > maxPrice){
			   maxPrice = item.getPrice();
		   }
		}
		return maxPrice;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market) {
		market.addPaymentTransaction(paymentTransaction);
		
	}

}
