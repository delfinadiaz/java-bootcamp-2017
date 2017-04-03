package Clase4Services;

public class MarketManager implements MailingListReceiver{
	
	private String name;
	private String email;
    private String message;
    
    public MarketManager(String name, String email){
    	this.name = name;
    	this.email=email;
    }
    
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name= name;
	}

	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.message= message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void setmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}


	

	
	
	
}
