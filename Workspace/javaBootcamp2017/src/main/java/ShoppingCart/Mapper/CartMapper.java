package ShoppingCart.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.test.context.ContextConfiguration;

import ShoppingCart.AppConfig;
import ShoppingCart.Dto.CartDTO.ShoppingCartDTO;
import ShoppingCart.Dto.ItemDTO.ItemCartDTO;
import ShoppingCart.Dto.PaymentDTO.ListStadisticPaymentDTO;
import ShoppingCart.Dto.PaymentDTO.PaymentDTO;
import ShoppingCart.Dto.PaymentDTO.StadisticPaymentDTO;
import ShoppingCart.Entities.CartItem;
import ShoppingCart.Entities.CashPayment;
import ShoppingCart.Entities.CreditCardPayment;
import ShoppingCart.Entities.Payment;
import ShoppingCart.Entities.PaypalPayment;

@ContextConfiguration(
	    classes = { AppConfig.class })
public class CartMapper {
	
	    private Mapper  mapper;
		private ItemMapper itemMapper;
		
		public CartMapper(Mapper  mapper){
			this.mapper = mapper;
		}
		
		public Payment createPaymentFromDTO(PaymentDTO paymentDTO, int payment_type){
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
		
		public ListStadisticPaymentDTO convertToListPaymentsDTO(List<Payment> payments){
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

		private ItemCartDTO convertCartItemToDTO(CartItem cartItem) {
			// TODO Auto-generated method stub
			ItemCartDTO itemCartDto = new ItemCartDTO();
			mapper.map(cartItem, itemCartDto, "cartItem");
			itemCartDto.setIdItem(cartItem.getItem().getIdItem());
			return itemCartDto;
		}

}
