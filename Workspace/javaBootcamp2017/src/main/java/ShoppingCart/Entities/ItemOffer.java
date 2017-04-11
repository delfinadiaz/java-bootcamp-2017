package ShoppingCart.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_offer")
public class ItemOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iditem_offer")
	private int idItemOffer;
	
	@ManyToOne()
    @JoinColumn(name = "idItem",nullable=false) 
	private IndividualItem item;
	
	@ManyToOne()
    @JoinColumn(name = "idOffer",nullable=false) 
	private Offer offer;
	
	public ItemOffer(){
		
	}

	public IndividualItem getItem() {
		return item;
	}

	public void setItem(IndividualItem item) {
		this.item = item;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public int getIdItemOffer() {
		return idItemOffer;
	}

	public void setIdItemOffer(int idItemOffer) {
		this.idItemOffer = idItemOffer;
	}

}
