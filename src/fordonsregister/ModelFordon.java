package fordonsregister;

//Holds getters and setters for Fordon-specific data.

public class ModelFordon {
	
	private ModelPerson owner;
	private String type;
	private String brand;
	private String regNr;
	
	public ModelFordon(ModelPerson owner, String type, String brand, String regNr) {
		this.owner = owner;
		this.type = type;
		this.brand = brand;
		this.regNr = regNr;
	}
	
	public void setOwner(ModelPerson owner) {
		this.owner = owner;
	}
	
	public ModelPerson getOwner() {
		return owner;
	}
	
	public String getOwnerName() {
		return owner.getName();
	}
	
	public String getOwnerAge() {
		return owner.getAge();
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}
	
	public String getRegNr() {
		return regNr;
	}

}
