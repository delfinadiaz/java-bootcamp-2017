package ShoppingCart.Model.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import ShoppingCart.Model.MarketModel.Market;

@SuppressWarnings("serial")
@Entity
@Table(name="payment")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="payment_type", discriminatorType=DiscriminatorType.INTEGER)
public abstract class Payment implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpayment")
	private int idPayment;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart")
	private ShoppingCartEntity cart;
	
    private double amount;
	//Generate a unique sequential id
	//public int getPaymentID();
    
	@ManyToOne
	@JoinColumn(name="user",nullable=false)
	private User user;
	

    public Payment(){
    	
    }
    
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	//Saves the payment transaction to the market where the user bought the items
	//public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market);
	
	/* Buy the items in the cart saving if necessary information of the user who is buying the items*/
	public abstract boolean buy(User user, List<IndividualItem> cart, double totalPrice);
	
	public int getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public ShoppingCartEntity getCart() {
		return cart;
	}

	public void setCart(ShoppingCartEntity cart) {
		this.cart = cart;
	}
	
	

}
