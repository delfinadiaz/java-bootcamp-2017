package ShoppingCart.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.inject.Inject;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import ShoppingCart.AppConfig;
import ShoppingCart.Dto.ItemDTO.IdItemDTO;
import ShoppingCart.Dto.ItemDTO.ListItemDTO;
import ShoppingCart.Dto.OfferDTO.ListOfferDTO;
import ShoppingCart.Dto.OfferDTO.OfferDTO;
import ShoppingCart.Dto.UserDTO.ListUserDTO;
import ShoppingCart.Dto.UserDTO.UserDTO;
import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.Offer;
import ShoppingCart.Entities.Payment;
import ShoppingCart.Entities.User;




@ContextConfiguration(
	    classes = { AppConfig.class })
public class UserMapper {

	
    private static Mapper  mapper;
	
	public UserMapper(){
	}
	
	@Inject
    private static DozerBeanMapperFactoryBean dozerBean;
	
	/*public static Offer convertFromDTO(OfferDTO offerDTO, Payment payment, List<IndividualItem> items) throws Exception{
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
		Offer offer = new Offer();
		mapper.map(offerDTO, offer, "offer");
		offer.setPayment(payment);
		offer.setItems(items);
		return offer;
	}*/
	
	public static UserDTO convertToDTO(User user){
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
		UserDTO userdto = new UserDTO();
		mapper.map(user,userdto, "user");
		return userdto;
		
	}

	public static ListUserDTO convertToListDTO(List<User> users) throws Exception {
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
	    List<UserDTO> listDto = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			mapper.map(user, userDTO,"user");
			listDto.add(userDTO);
		}
		ListUserDTO listUserDTO = new ListUserDTO(listDto);
		return listUserDTO;
	}
	
}
