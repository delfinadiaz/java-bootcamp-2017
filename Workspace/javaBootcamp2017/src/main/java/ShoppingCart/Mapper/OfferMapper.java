package ShoppingCart.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.inject.Inject;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.test.context.ContextConfiguration;

import ShoppingCart.AppConfig;
import ShoppingCart.Dto.ItemDTO.IdItemDTO;
import ShoppingCart.Dto.OfferDTO.ListOfferDTO;
import ShoppingCart.Dto.OfferDTO.OfferDTO;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Offer;
import ShoppingCart.Model.Entities.Payment;

@ContextConfiguration(
	    classes = { AppConfig.class })
public class OfferMapper {
	
	
   private static Mapper  mapper;
	
	public OfferMapper(){
	}
	
	@Inject
    private static DozerBeanMapperFactoryBean dozerBean;
	
	
	public static Offer convertFromDTO(OfferDTO offerDTO, int paymentType, Set<IndividualItem> items) throws Exception{
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
		Offer offer = new Offer();
		mapper.map(offerDTO, offer, "offer");
		offer.setPaymentType(paymentType);
		offer.setItems(items);
		return offer;
	}
	
	public static OfferDTO convertToDTO(Offer offer, int paymentType,List<IdItemDTO> items){
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
		OfferDTO offerdto = new OfferDTO();
		mapper.map(offer, offerdto, "offer");
		offerdto.setPaymentType(paymentType);;
		offerdto.setItems(items);
		return offerdto;
		
	}
	public static ListOfferDTO convertToListDTO(List<Offer> offers){
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
		List<OfferDTO> listDto = new ArrayList<OfferDTO>();
		for (Offer offer : offers){
			List<IdItemDTO> itemsdto= new ArrayList<IdItemDTO>();
			for (IndividualItem item : offer.getItems()){
				IdItemDTO itemDTO = new IdItemDTO(item.getIdItem());
				itemsdto.add(itemDTO);
			}
			int paymentType = offer.getPaymentType();
			OfferDTO offerdto = convertToDTO(offer,paymentType,itemsdto);
		    listDto.add(offerdto);
		}
		ListOfferDTO listOfferDTO = new ListOfferDTO(listDto);
		return listOfferDTO;
		
	}
}
