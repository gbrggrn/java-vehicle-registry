package fordonsregister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

//Holds the logic for all buttons.

public class ControllerButtonLogic {
	
	private ModelFordonsregister fordonsRegister;
	private ControllerInputValidation inputValidation;
	private ViewComponents components;
	private ViewBuildUI framePanel;
	private ModelFilehandling fileHandling;
	
	public ControllerButtonLogic(ModelFordonsregister fordonsRegister, ControllerInputValidation inputValidation, ViewComponents components, ViewBuildUI framePanel, ModelFilehandling fileHandling) {
		this.fordonsRegister = fordonsRegister;
		this.inputValidation = inputValidation;
		this.components = components;
		this.framePanel = framePanel;
		this.fileHandling = fileHandling;
	}
	
	public void loadButtonLogic() {
		JFileChooser fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (*.txt)", "txt");
		
		fileChooser.setFileFilter(filter);
		
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		
		fileChooser.setDialogTitle("Öppna Fordonsregister");
		
		int choice = fileChooser.showOpenDialog(null);
		
		if(choice == JFileChooser.APPROVE_OPTION) {
			System.out.println("Fil vald");
			File selectedFile = fileChooser.getSelectedFile();
			
			if(fileHandling.loadFile(selectedFile) == true) {
				framePanel.getQuestion().setVisible(false);
				framePanel.getMainFrame().setVisible(false);
				framePanel.buildUI();
			} else {
				JOptionPane.showMessageDialog(null, "Något gick fel!", "Problem", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (choice == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancel option");
			framePanel.getQuestion().setVisible(false);
			framePanel.buildQuestion();
		}
	}
		
	public void saveButtonLogic() {
		
		if(fordonsRegister.getCurrentSize() < 1) {
			components.printToPrintField("--- Kan inte spara ett tomt register! ---");
			return;
		}
		
		JFileChooser fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (*.txt)", "txt");
		
		fileChooser.setFileFilter(filter);
		
		fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		
		fileChooser.setDialogTitle("Spara Fordonsregister");
		
		int choice = fileChooser.showSaveDialog(null);
		
		if(choice == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			if(fileHandling.saveFile(selectedFile) == true) {
				System.out.println("Fil sparad, programmet stängs");
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "Något gick fel!", "Problem", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (choice == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancel option");
		}
	}
	
	public void sizeButtonLogic() {
		String sizeText = components.getSizeText();
		
		if(sizeText == null || inputValidation.checkInputIntString(sizeText) == false) {
			framePanel.getFirstFrame().setVisible(false);
			framePanel.buildSetRegisterSize();
		} else {
			int sizeTextInt = Integer.parseInt(sizeText);
			if(sizeTextInt < 1) {
				framePanel.getFirstFrame().setVisible(false);
				framePanel.buildSetRegisterSize();
			} else {
				fordonsRegister.setMaxSize(sizeTextInt);
				framePanel.getFirstFrame().setVisible(false);
				framePanel.buildUI();
			}
		}
	}
	
	public void addButtonLogic() {
		String typeText = components.getTypeText();
		String brandText = components.getBrandText();
		String regNrText = components.getRegNrText();
		String ownerNameText = components.getOwnerNameText();
		String ownerAgeText = components.getOwnerAgeText();
		boolean validInput = true;
		
		if(typeText == null || inputValidation.checkInputString(typeText) == false) {
			components.printToPrintField("--- Felaktig eller ingen typ angedd ---");
			validInput = false;
			components.clearTypeField();
		}
		
		if(brandText == null || inputValidation.checkInputString(brandText) == false) {
			components.printToPrintField("--- Felaktig eller inget märke angett ---");
			validInput = false;
			components.clearBrandField();
		}
		
		if(regNrText == null || inputValidation.checkInputRegNr(regNrText) == false) {
			components.printToPrintField("--- Inget eller felaktigt registreringsnummer ---");
			validInput = false;
			components.clearRegNrField();
		}
		
		if(ownerNameText == null || inputValidation.checkInputString(ownerNameText) == false) {
			components.printToPrintField("--- Inget eller felaktigt namn angett ---");
			validInput = false;
			components.clearOwnerNameField();
		}
		
		if(ownerAgeText == null || inputValidation.checkInputIntString(ownerAgeText) == false) {
			components.printToPrintField("--- Ingen ålder angedd eller felaktigt format ---");
			validInput = false;
			components.clearOwnerAgeField();
		}
		
		if(validInput == true) {
			ModelPerson owner = new ModelPerson(ownerNameText, ownerAgeText);
			if(fordonsRegister.addFordon(owner, typeText, brandText, regNrText) == true) {
				components.printToPrintField("--- Fordon tillagt i registret! ---\n");
				components.printToCurrentSizeCount(fordonsRegister.getCurrentSize());
				components.clearAllFields();
			} else {
				components.printToPrintField("--- Fordonsregister fullt! ---\n");
				components.clearAllFields();
			}
		} else {
			components.printToPrintField("--- Kunde inte spara fordon ---\n");
		}
	}
	
	public void removeButtonLogic() {
		String removePosString = components.getPosText();
		
		if(removePosString == null || inputValidation.checkInputIntString(removePosString) == false) {
			components.printToPrintField("--- Fel format. Försök igen ---");
			framePanel.getThirdFrame().setVisible(false);
		} else {
			int removePosInt = Integer.parseInt(removePosString);
			if(fordonsRegister.removeFordon(removePosInt) == false) {
				components.printToPrintField("--- Inget fordon på positionen. Försök igen ---");
				components.printToPrintField("--- Fordon finns på position 0-" + fordonsRegister.getCurrentSize() + " ---\n");
				framePanel.getThirdFrame().setVisible(false);
			} else {
				components.printToPrintField("--- Fordon på postion " + removePosInt + " raderat. ---");
				components.printToCurrentSizeCount(fordonsRegister.getCurrentSize());
				framePanel.getThirdFrame().setVisible(false);
			}
		}
	}
	
	public void searchButtonLogic() {
		String searchPosString = components.getPosText();
		
		if(searchPosString == null || inputValidation.checkInputIntString(searchPosString) == false) {
			components.printToPrintField("--- Fel format! Försök igen ---");
			framePanel.getSecondFrame().setVisible(false);
		} else {
			int searchPosInt = Integer.parseInt(searchPosString);
			String isValid = fordonsRegister.skrivUt(searchPosInt);
			
			if(fordonsRegister.getCurrentSize() == 0) {
				components.printToPrintField("--- Det finns inga fordon i registret ---");
				framePanel.getSecondFrame().setVisible(false);
			} else if(searchPosInt < 0 || searchPosInt > fordonsRegister.getMaxSize()) {
				components.printToPrintField("--- Den positionen finns inte i registret. ---\n");
				framePanel.getSecondFrame().setVisible(false);
			} else if(inputValidation.checkInputIntString(isValid) == true) {
				components.printToPrintField("--- Den positionen är tom! ---\n");
				components.printToPrintField("--- Data finns på position 0-" + fordonsRegister.getCurrentSize() + " ---\n");
				framePanel.getSecondFrame().setVisible(false);
			} else {
				components.printToPrintField(isValid);
				framePanel.getSecondFrame().setVisible(false);
			}
		}
	}
	
	public void printButtonLogic() {
		components.clearPrintField();
		if(fordonsRegister.getCurrentSize() != 0) {
			String printText = fordonsRegister.skrivUtAllt();
			components.printToPrintField("\n" + printText);
		} else {
			components.printToPrintField("--- Inga registrerade fordon ---");
		}
	}
}