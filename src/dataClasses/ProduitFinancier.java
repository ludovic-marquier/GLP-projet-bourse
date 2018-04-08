package dataClasses;


public class ProduitFinancier{
	
	private String type;
	private double prix;
	private String id;
	private String parentId;
	
	public ProduitFinancier() {
		
	}
	
	public ProduitFinancier(String type, String id, double prix, String parentId) {
		this.prix = prix;
		this.type = type;
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String toString() {
		return "\nPRIX : "+this.prix +"\nTYPE = "+this.type+"\nPARENT = "+this.parentId+"\n\n";
	}
	
	
}