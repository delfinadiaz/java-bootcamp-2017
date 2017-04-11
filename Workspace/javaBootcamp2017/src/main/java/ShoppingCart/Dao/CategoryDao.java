package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Entities.Offer;
import ShoppingCart.Model.Category;
import ShoppingCart.Model.Item;

public interface CategoryDao {

	public void createCategory(String aName);
	public void changeCategoryName(int idCategory,String aName);
    public Category getCategory(int idCategory);
    public List<Category> getCategories();
    public List<Item> getItemsOfACategory(int idCategory);
    public List<Offer> getOffersOfACategory(int idCategory);
    public void removeCategory(int idCategory);
}
