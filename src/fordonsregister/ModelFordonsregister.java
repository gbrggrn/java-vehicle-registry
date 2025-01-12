package fordonsregister;

import java.util.LinkedList;
import java.util.List;

public class ModelFordonsregister {
	
	private int currentSize;							//int currentSize holds the current size of the registry
	private int maxSize;								//int maxSize holds the max size of the registry
	private LinkedList<ModelFordon> fordonList;			//initializes a variable fordonList of type linked list.
	
	public ModelFordonsregister() {
		this.currentSize = 0;							//sets currentSize to 0.
		this.fordonList = new LinkedList<>();			//creates a new instance of fordonList to hold fordon
	}
	
//size() returns currentSize.
		public int getCurrentSize() {
			return currentSize;
		}
		
		public void setCurrentSize(int size) {
			this.currentSize = size;
		}
		
		public int addToCurrentSize() {
			return ++ currentSize;
		}
		
//maxSize() returns maxSize.
		public int getMaxSize() {
			return maxSize;
		}
		
//setMaxSize(): setter method for maxSize.
		public void setMaxSize(int maxSize) {
			this.maxSize = maxSize;
		}
		
//getFordonList() returns the current fordonList.
		public List<ModelFordon> getFordonList() {
			return fordonList;
		}
	
//setFordonList() is used if a user uploads an old list
		public void setFordonList(LinkedList<ModelFordon> fordonList){
			this.fordonList = fordonList;
		}
	
//pre: all arguments are of correct type and format
//post: fordon added or registry full
	public boolean addFordon(ModelPerson owner, String type, String brand, String regNr) {
		if(currentSize < maxSize) {
			ModelFordon fordon = new ModelFordon(owner, type, brand, regNr);
			fordonList.add(fordon);
			currentSize++;
			return true;
		} else {
			//System.out.println("Fordonsregister fullt!\n");
			return false;
		}
	}
	
//pre: input is a valid int
//post: removes vehicle or prompts for new "pos"
	public boolean removeFordon(int pos) {
		if(pos >= 0 && pos < fordonList.size()) {
			fordonList.remove(pos);
			currentSize--;
			return true;
		} else {
			return false;
		}
	}
	
//pre: input is valid int
//post: information from specific index point is returned, if it does not exist; return: null
	public ModelFordon getFordon(int pos) {
		if(pos >= 0 && pos < fordonList.size()) {
			return fordonList.get(pos);
		} else {
			return null;
		}
	}
	
//pre: input is valid int
//post: no fordon is found at "pos": returns to menu or returns "utskrift" as formatted string
	public String skrivUt(int pos) {
		StringBuilder utskrift = new StringBuilder();
		ModelFordon fordon = getFordon(pos);
		
		if(fordon != null) {
			utskrift.append("Position: ").append(pos).append("\n");
			utskrift.append("Ägare: ").append(fordon.getOwnerName()).append("\n");
			utskrift.append("Ålder: ").append(fordon.getOwnerAge()).append("\n");
			utskrift.append("Typ: ").append(fordon.getType()).append("\n");
			utskrift.append("Märke: ").append(fordon.getBrand()).append("\n");
			utskrift.append("Registreringsnummer: ").append(fordon.getRegNr()).append("\n");
		} else {
			utskrift.append("1");
			return utskrift.toString();
		}
			
		return utskrift.toString();
	}
	
//pre: none
//post: builds a string and returns it to caller method (which would be a print-method)
	public String skrivUtAllt() {
		StringBuilder utskrift = new StringBuilder();
		List<ModelFordon> fordonList = getFordonList();
		
		for(int i=0; i<fordonList.size(); i++) {
			ModelFordon fordon = fordonList.get(i);
			utskrift.append("Position:").append(i).append("\n");
			utskrift.append("Ägare: ").append(fordon.getOwnerName()).append("\n");
			utskrift.append("Ålder: ").append(fordon.getOwnerAge()).append("\n");
			utskrift.append("Typ: ").append(fordon.getType()).append("\n");
			utskrift.append("Märke: ").append(fordon.getBrand()).append("\n");
			utskrift.append("Registreringsnummer: ").append(fordon.getRegNr()).append("\n\n");
		}
		
		return utskrift.toString();
	}
	
	public String serializeFordonList() {
		//serialize every object in fordonLists parts!
		List<ModelFordon> fordonList = getFordonList();
		ModelFordon fordon;
		StringBuilder serializedFordonList = new StringBuilder();
		
		if(fordonList != null) {
			for(int i=0; i<fordonList.size(); i++) {
				fordon = fordonList.get(i);
				serializedFordonList.append(fordon.getOwnerName()).append("|");
				serializedFordonList.append(fordon.getOwnerAge()).append("|");
				serializedFordonList.append(fordon.getType()).append("|");
				serializedFordonList.append(fordon.getBrand()).append("|");
				serializedFordonList.append(fordon.getRegNr()).append("|#");
			}
			String maxSize = "" + getMaxSize();
			serializedFordonList.append(maxSize);
			return serializedFordonList.toString();
		} else {
			serializedFordonList.append("fel");
			return serializedFordonList.toString();
		}
	}
	
	public LinkedList<ModelFordon> deSerializeFordonList(String serializedFordonList) {
		LinkedList<ModelFordon> deSerializedFordonList = new LinkedList<>();
		
		setCurrentSize(0);
		
		String[] data = serializedFordonList.split("#");
		for(int i = 0; i < data.length - 1; i++) {
			String[] dataPoints = data[i].split("\\|");
			System.out.println(dataPoints.length);
			if(dataPoints.length == 5) {
				ModelPerson owner = new ModelPerson(dataPoints[0], dataPoints[1]);
				ModelFordon fordon = new ModelFordon(owner, dataPoints[2], dataPoints[3], dataPoints[4]);
				deSerializedFordonList.add(fordon);
				addToCurrentSize();
				System.out.println("deserialized");
			} else {
				deSerializedFordonList = null;
				return deSerializedFordonList;
			}
		}
		
		try {
			int savedMaxSize = Integer.parseInt(data[data.length - 1]);
			setMaxSize(savedMaxSize);
		} catch (NumberFormatException nfe) {
			deSerializedFordonList = null;
			return deSerializedFordonList;
		}
		
		return deSerializedFordonList;
	}
}