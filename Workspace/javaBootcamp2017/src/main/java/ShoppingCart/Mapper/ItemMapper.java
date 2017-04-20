package ShoppingCart.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.inject.Inject;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.test.context.ContextConfiguration;

import ShoppingCart.AppConfig;
import ShoppingCart.Dto.CartDTO.StadisticShoppingCartDTO;
import ShoppingCart.Dto.ItemDTO.InfoItemDTO;
import ShoppingCart.Dto.ItemDTO.ItemDTO;
import ShoppingCart.Dto.ItemDTO.ListItemDTO;
import ShoppingCart.Model.Entities.IndividualItem;

@ContextConfiguration(
	    classes = { AppConfig.class })
public class ItemMapper {
	
	private static Mapper  mapper;
	
	public ItemMapper(){
	}
	
	@Inject
    private static DozerBeanMapperFactoryBean dozerBean;
	
	public static ListItemDTO convertToListItemDTO(List<IndividualItem> items){
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
			
			List<ItemDTO> listDto = new ArrayList<ItemDTO>();
			for (IndividualItem item : items){
					ItemDTO itemDTO = new ItemDTO();
					mapper.map(item, itemDTO, "item");
					listDto.add(itemDTO);
				}
			ListItemDTO listItemDTO = new ListItemDTO(listDto);
			return listItemDTO;
	}
	
	public static ItemDTO convertToDTO(IndividualItem item){
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
		ItemDTO itemdto = new ItemDTO();
		mapper.map(item, itemdto, "item");
		return itemdto;
		
	}
	
	public static IndividualItem convertFromDTO(ItemDTO itemDTO){
		DozerBeanMapper mapper = new DozerBeanMapper();
		 List<String> mappingList = new ArrayList<String>();
		 mappingList.add("dozer-bean-mappings.xml");
		 mapper.setMappingFiles(mappingList);
		IndividualItem item = new IndividualItem();
		mapper.map(itemDTO, item, "item");
		return item;
	}


}
	
	

