package fordonsregister;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModelFilehandling {
	
	private ModelFordonsregister fordonsRegister;
	private BufferedReader read;
	
	
	public ModelFilehandling(ModelFordonsregister fordonsRegister) {
		this.fordonsRegister = fordonsRegister;
	}
	
//pre: expects argument of type "File"
//post: returns "true" if file can be loaded
	public boolean loadFile(File file) {
		try {
			System.out.println("loadFile entered");
			read = new BufferedReader(new FileReader(file));
			StringBuilder selectedFileText = new StringBuilder();
			String selectedFileLine;
			System.out.println("variables declared");
			
				while((selectedFileLine = read.readLine()) != null) {
					selectedFileText.append(selectedFileLine);
					System.out.println("file read");
				}
				
				System.out.println(selectedFileText.toString());
				
			if(fordonsRegister.deSerializeFordonList(selectedFileText.toString()) == null) {
				return false;
			} else {
				fordonsRegister.setFordonList(fordonsRegister.deSerializeFordonList(selectedFileText.toString()));
				return true;
			}
				
			} catch (IOException ioe) {
				return false;
			} catch (Exception e) {
				return false;
			}
	}

//pre: expects argument of type "File"
//post: returns "true" if file can be saved
	public boolean saveFile(File file) {
		String fordonListToSave = fordonsRegister.serializeFordonList();
		try (BufferedWriter write = new BufferedWriter(new FileWriter(file))) {
			write.write(fordonListToSave);
			return true;
		} catch (IOException ioe) {
			return false;
		}
	}
}
