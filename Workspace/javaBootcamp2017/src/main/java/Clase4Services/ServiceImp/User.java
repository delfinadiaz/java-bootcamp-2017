package Clase4Services.ServiceImp;

import Clase4Services.ServiceImp.MarketImp.Market;

public class User{
	
        private String name;
		private String username;
		private String password;
		private String email;
		private int creditNumber;
		private Market market;
		
		
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
		public Market getMarket() {
			return market;
		}
		public void setMarket(Market market) {
			this.market = market;
		}
		
}
