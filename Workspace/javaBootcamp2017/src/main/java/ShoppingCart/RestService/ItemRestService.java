package ShoppingCart.RestService;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ShoppingCart.Dto.ItemDTO.ItemDTO;
import ShoppingCart.Dto.ItemDTO.ListItemDTO;
import ShoppingCart.Mapper.ItemMapper;
import ShoppingCart.Model.Category;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemRestService {
	
	private ItemService itemService;
	
	
	@Autowired
	public ItemRestService(ItemService itemService){
		this.itemService = itemService;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getAllItems() throws JsonProcessingException {
        
		List<IndividualItem> items = itemService.getItems();
		if (items.isEmpty()) {
			return new ResponseEntity("No items found", HttpStatus.NOT_FOUND);
		}
		else{
			ListItemDTO listItemDTO =null;
			try {
				listItemDTO = ItemMapper.convertToListItemDTO(items);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
		
			return new ResponseEntity(listItemDTO, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/{idItem}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getItem(@PathVariable int idItem) throws JsonProcessingException {
        
		IndividualItem item = itemService.getItem(idItem);
		if (item == null) {
			return new ResponseEntity("No item found with id" + idItem, HttpStatus.NOT_FOUND);
		}
		else{
			ItemDTO itemDTO = null;
			try {
				itemDTO = ItemMapper.convertToDTO(item);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			
			return new ResponseEntity(itemDTO, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity saveItem(@RequestBody ItemDTO itemDTO) throws JsonProcessingException {
		IndividualItem item = null;
		try {
			item = ItemMapper.convertFromDTO(itemDTO);
		}
		catch(Exception  e){
			return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
		}
		boolean created = itemService.createItem(item);
		if (created) {
			return new ResponseEntity("The item was successfully created", HttpStatus.CREATED);
		} else {
			return new ResponseEntity("The item could not be created", HttpStatus.CONFLICT);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idItem}")
	public ResponseEntity removeItem(@PathVariable int idItem) throws JsonProcessingException {

		IndividualItem item = itemService.getItem(idItem);
		if (item == null) {
			return new ResponseEntity("No item found with id " + idItem, HttpStatus.NOT_FOUND);
		}

		boolean deleted = itemService.removeItem(item);
		if (deleted) {
			return new ResponseEntity("The item was successfully deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity("The item could not be deleted", HttpStatus.CONFLICT);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.PUT, value = "/{idItem}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity updateItem(@PathVariable int idItem, @RequestBody ItemDTO itemDTOUpdated) throws JsonProcessingException {
        
		IndividualItem item = itemService.getItem(idItem);
		if (item == null) {
			return new ResponseEntity("No item found with id " + idItem, HttpStatus.NOT_FOUND);
		}
		item.setName(itemDTOUpdated.getName());
		item.setPrice(itemDTOUpdated.getPrice());
		item.setCategory(itemDTOUpdated.getCategory());
		item.setStock(itemDTOUpdated.getStock());
		Boolean updated = itemService.updateItem(item);
		if (updated) {
			return new ResponseEntity("The item was successfully updated", HttpStatus.OK);
		} else {
			return new ResponseEntity("The item could not be updated", HttpStatus.CONFLICT);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/category/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getItemsByCategory(@PathVariable int category) throws JsonProcessingException {
		if (category > Category.values().length) {
			return new ResponseEntity("Category no valid", HttpStatus.CONFLICT);
        }
		Category enumCategory = Category.values()[category];
		List<IndividualItem> items = itemService.getItemsByCategory(enumCategory);
		if (items.isEmpty()) {
			return new ResponseEntity("No items found for the category", HttpStatus.NOT_FOUND);
		}
		else{
			ListItemDTO listItemDTO = null;
			try {
				listItemDTO = ItemMapper.convertToListItemDTO(items);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			
			return new ResponseEntity(listItemDTO, HttpStatus.OK);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getItemsByName(@PathVariable String name) throws JsonProcessingException {
		
		List<IndividualItem> items = itemService.getItemsByName(name);
		if (items.isEmpty()) {
			return new ResponseEntity("No items found for the name " + name, HttpStatus.NOT_FOUND);
		}
		else{
			ListItemDTO listItemDTO = null;
			try {
				listItemDTO = ItemMapper.convertToListItemDTO(items);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
			
			return new ResponseEntity(listItemDTO, HttpStatus.OK);
		}
	}

}
