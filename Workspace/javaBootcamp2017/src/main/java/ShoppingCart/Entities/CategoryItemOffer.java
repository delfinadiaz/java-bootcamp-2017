package ShoppingCart.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ShoppingCart.Model.Category;

@Entity
@Table(name = "category")
public class CategoryItemOffer implements Category{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategory")
	private int idCategory;
	
	private String name;
	
	public CategoryItemOffer(){
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String aName) {
		// TODO Auto-generated method stub
		this.name = aName;
		
	}

}
