package Clase4Services.Model.PaymentModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Clase4Services.Model.MarketModel.Market;
import Clase4Services.Model.MarketModel.User;

@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction {
    
	@Id
	@GeneratedValue
	@Column(name = "idpayment_transaction")
	private int number;
	private double amount;
	private String paymentMethod;
	
	@ManyToOne
	@JoinColumn(name="market",nullable=false)
	private Market market;
	
	@ManyToOne
	@JoinColumn(name="user",nullable=false)
	private User user;
	
	public PaymentTransaction(int aNumber, double anAmount, String aPaymentMethod){
		this.number= aNumber;
		this.amount= anAmount;
		this.paymentMethod=aPaymentMethod;
		
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
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
