package ShoppingCart.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ShoppingCart.Model.MarketModel.Market;
import ShoppingCart.ServiceImp.ShoppingCartImp;


@Entity
@Table(name = "user")
public class User{
	    
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "iduser")
		private int idUser;
	
	    private String name;
		private String username;
		private String password;
		private String email;
		
		@Transient
		private Market market;
		
		@Column(name = "credit_number")
		private int creditNumber;
	
		@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
		private List<PaymentTransaction> transactions= new ArrayList<PaymentTransaction>();
		
		@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
		private ShoppingCartEntity shoppingCart;
		
		public User(){
					
		}
		
		public User(String username, String password, String email, Market market) {
			this.username = username;
			this.password = password;
			this.email = email;
			this.market= market;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCreditNumber() {
			return creditNumber;
		}
		public void setCreditNumber(int creditNumber) {
			this.creditNumber = creditNumber;
		}
		
		public int getIdUser() {
			return idUser;
		}
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		public ShoppingCartEntity getShoppingCart() {
			return shoppingCart;
		}
		public void setShoppingCart(ShoppingCartEntity shoppingCart) {
			this.shoppingCart = shoppingCart;
		}

		public Market getMarket() {
			return market;
		}

		public void setMarket(Market market) {
			this.market = market;
		}
		
		
}
