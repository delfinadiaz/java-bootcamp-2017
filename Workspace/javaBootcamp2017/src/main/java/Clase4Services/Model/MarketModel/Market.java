package Clase4Services.Model.MarketModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import Clase4Services.Model.Item;
import Clase4Services.Model.MailingListReceiver;
import Clase4Services.Model.ItemOffer.Offer;
import Clase4Services.Model.PaymentModel.PaymentTransaction;

@Entity
@Table(name = "market")
public class Market {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmarket")
	private int idMarket;
	
	@Column(name= "market_name")
	private String marketName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="market")
	private List<MailingListReceiver> mailingList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="market")
	private List<Item> itemsAndOffers;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="market")
	private List<PaymentTransaction> paymentTransactions;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="market")
	private List<User> users;
	
	@Transient
	private String message;
	
	public Market(String marketName){
		this.marketName = marketName;
		this.mailingList = new ArrayList<MailingListReceiver>();
		this.itemsAndOffers= new ArrayList<Item>();
		this.paymentTransactions= new ArrayList<PaymentTransaction>();
		this.users =new ArrayList<User>();
	}
	
	public void addPaymentTransaction(PaymentTransaction paymentTransaction) {
		paymentTransactions.add(paymentTransaction);
		setMessage("A new Transaction has been made");
		doNotify(message);
	}
	
	private void doNotify(String message) {
		Iterator<MailingListReceiver> person = mailingList.iterator();
		while (person.hasNext()) {
			MailingListReceiver aPerson = person.next();
			aPerson.setMessage(message);
		}
	}

	public void addPersonToMailingList(MailingListReceiver aPerson){
		mailingList.add(aPerson);
	}
	
	public void removePersonToMailingList(MailingListReceiver aPerson){
		mailingList.remove(aPerson);
	}

	public void addAnItemOrOffer(Item anItemOrOffer){
		itemsAndOffers.add(anItemOrOffer);
		if (anItemOrOffer instanceof Offer){
			setMessage("A new Offer has been added");
			doNotify(message);
		}
		else {
			setMessage("A new Item has been added");
			doNotify(message);
		}
	}

	public void removeAnItemOrOffer(Item anItemOrOffer){
		itemsAndOffers.remove(anItemOrOffer);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void changePriceItemOrOffer(Item anItemOrOffer, double newPrice){
		anItemOrOffer.setPrice(newPrice);
		if (anItemOrOffer instanceof Offer){
			setMessage("The Price of the offer: " + anItemOrOffer.getName()+ " has changed");
			doNotify(message);
		}
		else {
			setMessage("The Price of the item: " + anItemOrOffer.getName()+ " has changed");
			doNotify(message);
		}
	}
	
	public void addUser(User anUser){
		users.add(anUser);
	}
	
	public void removeUser(User anUser){
		users.remove(anUser);
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public List<User> getUsers() {
		return users;
	}


	public List<PaymentTransaction> getPaymentTransactions() {
		return paymentTransactions;
	}

	public List<Item> getItemsAndOffers() {
		return itemsAndOffers;
	}


	public List<MailingListReceiver> getMailingList() {
		return mailingList;
	}

	public User getUser(String anUsername){
		String username= getUsers().get(0).getUsername();
		Iterator<User> user = getUsers().iterator();
		User anUser = getUsers().get(0);
		while (user.hasNext()&& (username != anUsername)) {
			anUser = user.next();
			username = anUser.getUsername();
		}
		return anUser;
	}

	public int getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(int idMarket) {
		this.idMarket = idMarket;
	}
	

}
