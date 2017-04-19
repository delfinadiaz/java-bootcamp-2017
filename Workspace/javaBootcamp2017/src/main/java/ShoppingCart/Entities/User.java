package ShoppingCart.Entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ShoppingCart.Model.MarketModel.Market;


@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
	    
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "iduser")
		private int idUser;
	
		@Column(length = 45)
	    private String name;
	    @Column(length = 45)
		private String username;
		@Column(length = 45)
		private String password;
		@Column(length = 45)
		private String email;
		
		@Transient
		private Market market;
		
		@Column(name = "credit_number")
		private int creditNumber;
	
		@OneToMany(fetch = FetchType.EAGER, mappedBy="user")
		private Set<Payment> transactions= new HashSet<Payment>(0);
		
		@OneToMany(fetch = FetchType.EAGER, mappedBy="user")
		private Set<ShoppingCartEntity> carts= new HashSet<ShoppingCartEntity>(0);
		
		public User(){
					
		}
		public User(String name,String username, String password, String email, int creditNumber){
			this.name=name;
			this.username = username;
			this.password = password;
			this.email = email;
			this.creditNumber = creditNumber;
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
		

		@JsonIgnore
		public Market getMarket() {
			return market;
		}

		public void setMarket(Market market) {
			this.market = market;
		}

		@JsonIgnore
		public Set<ShoppingCartEntity> getCarts() {
			return carts;
		}
		public void setCarts(Set<ShoppingCartEntity> carts) {
			this.carts = carts;
		}
		
		
}
