package Clase4Services.Model.MarketModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import Clase4Services.Model.MailingListReceiver;

@Entity
@Table(name = "mailinglist_receiver")
public class MarketManager implements MailingListReceiver{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmailinglist_receiver")
	private int idMailingListReceiver;
	
	private String name;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="market",nullable=false)
	private Market market;
	
	@Transient
    private String message;
    
    public MarketManager(String name, String email){
    	this.name = name;
    	this.email=email;
    }
    
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name= name;
	}

	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.message= message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void setmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public int getIdMailingListReceiver() {
		return idMailingListReceiver;
	}

	public void setIdMailingListReceiver(int idMailingListReceiver) {
		this.idMailingListReceiver = idMailingListReceiver;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}


	

	
	
	
}
