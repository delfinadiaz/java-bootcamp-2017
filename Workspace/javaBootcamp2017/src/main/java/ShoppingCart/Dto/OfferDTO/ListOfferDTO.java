package ShoppingCart.Dto.OfferDTO;


import java.util.List;



public class ListOfferDTO {
	
	private int amountOffers;
	private List<OfferDTO> offers;
	
	public ListOfferDTO(List<OfferDTO> offers){
		this.amountOffers=offers.size();
		this.offers=offers;
	}
	
    public int getAmountOffers() {
		return amountOffers;
	}
	public void setAmountOffers(int amountOffers) {
		this.amountOffers = amountOffers;
	}
	
	public List<OfferDTO> getOffers() {
		return offers;
	}
	public void setOffers(List<OfferDTO> offers) {
		this.offers = offers;
	}

}
