package ShoppingCart.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.inject.Inject;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.test.context.ContextConfiguration;

import ShoppingCart.AppConfig;
import ShoppingCart.Dto.CartDTO.ListShoppingCartsDTO;
import ShoppingCart.Dto.CartDTO.ShoppingCartDTO;
import ShoppingCart.Dto.CartDTO.StadisticShoppingCartDTO;
import ShoppingCart.Dto.ItemDTO.InfoItemDTO;
import ShoppingCart.Dto.ItemDTO.ItemCartDTO;
import ShoppingCart.Dto.PaymentDTO.ListStadisticPaymentDTO;
import ShoppingCart.Dto.PaymentDTO.PaymentDTO;
import ShoppingCart.Dto.PaymentDTO.StadisticPaymentDTO;
import ShoppingCart.Model.Entities.CartItem;
import ShoppingCart.Model.Entities.CashPayment;
import ShoppingCart.Model.Entities.CreditCardPayment;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Payment;
import ShoppingCart.Model.Entities.PaypalPayment;
import ShoppingCart.Model.Entities.ShoppingCartEntity;

@ContextConfiguration(locations={"classpath*:dozer-bean-mappings.xml"})
public class CartMapper {
	
	 	private static Mapper  mapper;
		
		public CartMapper(){
		}
		
		@Inject
	    private static DozerBeanMapperFactoryBean dozerBean;
		
		
		public static Payment createPaymentFromDTO(PaymentDTO paymentDTO, int payment_type){
			Payment payment=null;
		
			switch (payment_type) {
            case 1:  payment = new CashPayment();
                     break;
            case 2:  payment = new CreditCardPayment();
                     break;
            case 3:  payment = new PaypalPayment();
                     break;
			}
			return payment;
		}
		
		public static  ListStadisticPaymentDTO convertToListPaymentsDTO(List<Payment> payments){
			DozerBeanMapper mapper = new DozerBeanMapper();
			 List<String> mappingList = new ArrayList<String>();
			 mappingList.add("dozer-bean-mappings.xml");
			 mapper.setMappingFiles(mappingList);
			List<StadisticPaymentDTO> paymentsDTO = new ArrayList<StadisticPaymentDTO>();
			for (Payment payment : payments){
				StadisticPaymentDTO stadisticPaymentDTO = new StadisticPaymentDTO();
					mapper.map(payment, stadisticPaymentDTO, "payment");
					List<ItemCartDTO> listItemCartDTO = new ArrayList<ItemCartDTO>();
					for (CartItem cartItem : payment.getCart().getCartItems()){
						ItemCartDTO cartItemDTO = convertCartItemToDTO(cartItem);
						listItemCartDTO.add(cartItemDTO);
					}
					ShoppingCartDTO cart = new ShoppingCartDTO(payment.getUser().getIdUser(),listItemCartDTO);
					stadisticPaymentDTO.setCart(cart);
					paymentsDTO.add(stadisticPaymentDTO);
				}
			ListStadisticPaymentDTO listStadisticPaymentDTO = new ListStadisticPaymentDTO(paymentsDTO);
			return listStadisticPaymentDTO;
			
		}

		private static  ItemCartDTO convertCartItemToDTO(CartItem cartItem) {
			// TODO Auto-generated method stub
			DozerBeanMapper mapper = new DozerBeanMapper();
			 List<String> mappingList = new ArrayList<String>();
			 mappingList.add("dozer-bean-mappings.xml");
			 mapper.setMappingFiles(mappingList);
			ItemCartDTO itemCartDto = new ItemCartDTO();
			mapper.map(cartItem, itemCartDto, "cartItem");
			itemCartDto.setIdItem(cartItem.getItem().getIdItem());
			return itemCartDto;
		}
		
		public static StadisticShoppingCartDTO convertToStadisticCartDTO(List<IndividualItem> items, String username, String status) {
			// TODO Auto-generated method stub
			DozerBeanMapper mapper = new DozerBeanMapper();
			 List<String> mappingList = new ArrayList<String>();
			 mappingList.add("dozer-bean-mappings.xml");
			 mapper.setMappingFiles(mappingList);
			 List<InfoItemDTO> itemsDto= new ArrayList<InfoItemDTO>();
				for (IndividualItem item : items) {
					int quantity = item.getCartItem().size();
					InfoItemDTO itemInfoDto = new InfoItemDTO();
					mapper.map(item, itemInfoDto, "infoItem");
					itemInfoDto.setQuantity(quantity);
					itemsDto.add(itemInfoDto);
				}
		     StadisticShoppingCartDTO listDTO = new StadisticShoppingCartDTO(itemsDto);
		     listDTO.setStatus(status);
		     listDTO.setUser(username);
			return listDTO;
		}

}
