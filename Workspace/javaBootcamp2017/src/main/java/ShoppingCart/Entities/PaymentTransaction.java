package ShoppingCart.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction {
    
	@Id
	@GeneratedValue
	@Column(name = "idpayment_transaction")
	private int idPaymentTransaction;
	
	@Transient
	private int number;
	
	private double amount;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@ManyToOne
	@JoinColumn(name="idUser",nullable=false)
	private User user;
	
	public PaymentTransaction(){
		
	}
	public PaymentTransaction(int aNumber, double anAmount, String aPaymentMethod,User anUser){
		this.number= aNumber;
		this.amount= anAmount;
		this.paymentMethod=aPaymentMethod;
		this.user= anUser;
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String description) {
		this.paymentMethod = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
