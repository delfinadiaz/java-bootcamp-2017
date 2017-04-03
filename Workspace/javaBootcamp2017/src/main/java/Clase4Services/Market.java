package Clase4Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Market {
	
	private String marketName;
	private List<MailingListReceiver> mailingList;
	private List<Item> itemsAndOffers;
	private List<PaymentTransaction> paymentTransactions;
	private List<User> users;
	private String message;
	
	public Market(String marketName){
		this.marketName = marketName;
		setMailingList(new ArrayList<MailingListReceiver>());
		setItemsAndOffers(new ArrayList<Item>());
		setPaymentTransactions(new ArrayList<PaymentTransaction>());
		setUsers(new ArrayList<User>());
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

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<PaymentTransaction> getPaymentTransactions() {
		return paymentTransactions;
	}

	public void setPaymentTransactions(List<PaymentTransaction> paymentTransactions) {
		this.paymentTransactions = paymentTransactions;
	}

	public List<Item> getItemsAndOffers() {
		return itemsAndOffers;
	}

	public void setItemsAndOffers(List<Item> itemsAndOffers) {
		this.itemsAndOffers = itemsAndOffers;
	}

	public List<MailingListReceiver> getMailingList() {
		return mailingList;
	}

	public void setMailingList(List<MailingListReceiver> mailingList) {
		this.mailingList = mailingList;
	}
	

}
