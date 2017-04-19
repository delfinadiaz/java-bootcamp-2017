package ShoppingCart.RestService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ShoppingCart.Dto.ItemDTO.IdItemDTO;
import ShoppingCart.Dto.ItemDTO.ListIdItemDTO;
import ShoppingCart.Dto.OfferDTO.ListOfferDTO;
import ShoppingCart.Dto.OfferDTO.OfferDTO;
import ShoppingCart.Mapper.OfferMapper;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Offer;
import ShoppingCart.Service.ItemService;
import ShoppingCart.Service.OfferService;

@RestController
@RequestMapping("/offer")
public class OfferRestService {

	private OfferService offerService;
	private ItemService itemService;
	
	
	@Autowired
	public OfferRestService(OfferService offerService, ItemService itemService) throws Exception{
		this.offerService = offerService;
		this.itemService = itemService;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getAllOffers() throws JsonProcessingException{
		
		List<Offer> offers = offerService.getOffers();
		if (offers.isEmpty()) {
			return new ResponseEntity("No offers found", HttpStatus.NOT_FOUND);
		}
		else{
			ListOfferDTO listOfferDTO = null;
			try {
				listOfferDTO = OfferMapper.convertToListDTO(offers);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			return new ResponseEntity(listOfferDTO, HttpStatus.OK);
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/paymentType/{paymentType}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getOffersByPayment(@PathVariable int paymentType) throws JsonProcessingException{
		if (paymentType > 3 || paymentType < 1){
			return new ResponseEntity("No valid payment type", HttpStatus.NOT_FOUND);
		}
		List<Offer> offers = offerService.getOffersByPayment(paymentType);
		if (offers.isEmpty()) {
			return new ResponseEntity("No offers found for that payment", HttpStatus.NOT_FOUND);
		}
		else{
			ListOfferDTO listOfferDTO = null;
			try {
				listOfferDTO = OfferMapper.convertToListDTO(offers);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			return new ResponseEntity(listOfferDTO, HttpStatus.OK);
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/{idOffer}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getOffer(@PathVariable int idOffer) throws JsonProcessingException {
        
		Offer offer = offerService.getOffer(idOffer);
		if (offer == null) {
			return new ResponseEntity("No offer found with id" + idOffer, HttpStatus.NOT_FOUND);
		}
		else{
			
			List<IdItemDTO> itemsdto= new ArrayList<IdItemDTO>();
			for (IndividualItem item : offer.getItems()){
				IdItemDTO itemDTO = new IdItemDTO(item.getIdItem());
				itemsdto.add(itemDTO);
			}
			int paymentType = offer.getPaymentType();
			OfferDTO offerdto = null;
			try {
				offerdto = OfferMapper.convertToDTO(offer,paymentType,itemsdto);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			return new ResponseEntity(offerdto, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity saveOffer(@RequestBody OfferDTO offerDTO) throws JsonProcessingException {
		if (offerDTO.getPaymentType() > 3 || offerDTO.getPaymentType() < 1){
			return new ResponseEntity("No valid payment type", HttpStatus.NOT_FOUND);
		}
		
		Set<IndividualItem> items= new HashSet<IndividualItem>(0);
		
			for (IdItemDTO itemdto : offerDTO.getItems()){
				IndividualItem item = itemService.getItem(itemdto.getIdItem());
			    items.add(item);
		   }
		
		Offer offer=null;
		try {
			offer = OfferMapper.convertFromDTO(offerDTO,offerDTO.getPaymentType(),items);
		}
		catch(Exception  e){
			return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
		}
		boolean created = offerService.createOffer(offer);
		if (created) {
			return new ResponseEntity("The offer was successfully created", HttpStatus.CREATED);
		} else {
			return new ResponseEntity("The offer could not be created", HttpStatus.CONFLICT);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idOffer}")
	public ResponseEntity removeOffer(@PathVariable int idOffer) throws JsonProcessingException {

		Offer offer = offerService.getOffer(idOffer);
		if (offer == null) {
			return new ResponseEntity("No offer found with id " + idOffer, HttpStatus.NOT_FOUND);
		}

		boolean deleted = offerService.removeOffer(offer);
		if (deleted) {
			return new ResponseEntity("The offer was successfully deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity("The offer could not be deleted", HttpStatus.CONFLICT);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.PUT, value = "/{idOffer}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity updateOffer(@PathVariable int idOffer, @RequestBody OfferDTO offerDTOUpdated) throws JsonProcessingException {
        
		Offer offer = offerService.getOffer(idOffer);
		if (offer == null) {
			return new ResponseEntity("No offer found with id " + idOffer, HttpStatus.NOT_FOUND);
		}
		if (offerDTOUpdated.getPaymentType() > 3 || offerDTOUpdated.getPaymentType() < 1){
			return new ResponseEntity("No valid payment type", HttpStatus.NOT_FOUND);
		}
		for (IdItemDTO itemdto : offerDTOUpdated.getItems()){
			IndividualItem item = itemService.getItem(itemdto.getIdItem());
			offer.addItem(item);
			item.addOffer(offer);
			itemService.updateItem(item);
		}
		offer.setDiscount(offerDTOUpdated.getDiscount());
		offer.setName(offerDTOUpdated.getName());
		offer.setPaymentType(offerDTOUpdated.getPaymentType());
		Boolean updated = offerService.updateOffer(offer);
		if (updated) {
			return new ResponseEntity("The offer was successfully updated", HttpStatus.OK);
		} else {
			return new ResponseEntity("The offer could not be updated", HttpStatus.CONFLICT);
		}
     }
	
    @Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.PUT, value = "/{idOffer}/removeItems")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity removeItemsFromOffer(@PathVariable int idOffer, @RequestBody ListIdItemDTO itemsDTO) throws JsonProcessingException {
        
		Offer offer = offerService.getOffer(idOffer);
		if (offer == null) {
			return new ResponseEntity("No offer found with id " + idOffer, HttpStatus.NOT_FOUND);
		}
		
		for (IdItemDTO itemdto : itemsDTO.getItems()){
			IndividualItem item = itemService.getItem(itemdto.getIdItem());
			offer.removeItem(item);
			item.removeOffer(offer);
			itemService.updateItem(item);
		}
		Boolean updated = offerService.updateOffer(offer);
		if (updated) {
			return new ResponseEntity("The items were successfully removed from the offer", HttpStatus.OK);
		} else {
			return new ResponseEntity("The items could not be removed", HttpStatus.CONFLICT);
		}
     }
}
