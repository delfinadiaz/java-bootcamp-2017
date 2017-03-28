package Clase3TDD.BlogSoftware;

public class Entry {
	private String title;
	private String content;
	
	public Entry(String aTitle, String aContent){
		title= aTitle;
		content=aContent;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
