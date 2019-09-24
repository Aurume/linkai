package link;

public enum Menu {

	Nuorodos("/nuorodos")
	, Kategorijos("/kategorijos")
	, Atributai("/atributai");
	
	private final String itemurl;
	
	Menu( String url ) {
		this.itemurl = url;
	}
	
	public String itemurl() {
		return this.itemurl;
	}
	
}
