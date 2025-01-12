package fordonsregister;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Holds methods to create different components. Buttons, TextFields and TextArea.

public class ViewComponents {
	
//Buttons
	private JButton newRegisterButton;
	private JButton uploadButton;
	private JButton sizeButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton printButton;
	private JButton searchPosButton;
	private JButton saveButton;
	private JButton searchActualButton;
	private JButton removeActualButton;
	
	public JButton newRegisterButton(ControllerListeners listeners) {
		newRegisterButton = new JButton();
		
		newRegisterButton.setText("Nytt register");
		newRegisterButton.addActionListener(listeners);
		newRegisterButton.setActionCommand("newRegister");
		//newRegisterButton.setEnabled(true);
		
		System.out.println("newRegisterButton() executed");
		return newRegisterButton;
	}
	
	public JButton uploadButton(ControllerListeners listeners) {
		uploadButton = new JButton();
		
		uploadButton.setText("Ladda upp");
		uploadButton.addActionListener(listeners);
		uploadButton.setActionCommand("upload");
		
		System.out.println("uploadButton() executed");
		return uploadButton;
	}
	
	public JButton sizeButton(ControllerListeners listeners) {
		sizeButton = new JButton();
		
		sizeButton.setText("Spara");
		sizeButton.addActionListener(listeners);
		sizeButton.setActionCommand("size");
		
		System.out.println("sizeButton() executed");
		return sizeButton;
	}
	
	public JButton addButton(ControllerListeners listeners) {
		addButton = new JButton();
		
		addButton.setText("Lägg till");
		addButton.addActionListener(listeners);
		addButton.setActionCommand("add");
		
		System.out.println("addButton() executed");
		return addButton;
	}
	
	public JButton removeButton(ControllerListeners listeners) {
		removeButton = new JButton();
		
		removeButton.setText("Ta bort");
		removeButton.addActionListener(listeners);
		removeButton.setActionCommand("remove");
		
		System.out.println("removeButton() executed");
		return removeButton;
	}
	
	public JButton printButton(ControllerListeners listeners) {
		printButton = new JButton();
		
		printButton.setText("Skriv ut allt");
		printButton.addActionListener(listeners);
		printButton.setActionCommand("print");
		
		System.out.println("printButton() executed");
		return printButton;
	}
	
	public JButton searchPosButton (ControllerListeners listeners) {
		searchPosButton = new JButton();
		
		searchPosButton.setText("Sök position");
		searchPosButton.addActionListener(listeners);
		searchPosButton.setActionCommand("search");
		
		System.out.println("searchPosButton() executed");
		return searchPosButton;
	}
	
	public JButton saveButton(ControllerListeners listeners) {
		saveButton = new JButton();
		
		saveButton.setText("Spara och avsluta");
		saveButton.addActionListener(listeners);
		saveButton.setActionCommand("saveAll");
		
		System.out.println("saveButton() executed");
		return saveButton;
	}
	
	public JButton searchActualButton(ControllerListeners listeners) {
		searchActualButton = new JButton();
		
		searchActualButton.setText("Sök position");
		searchActualButton.addActionListener(listeners);
		searchActualButton.setActionCommand("searchActual");
		
		System.out.println("searchActualButton() executed");
		return searchActualButton;
	}
	
	public JButton removeActualButton(ControllerListeners listeners) {
		removeActualButton = new JButton();
		
		removeActualButton.setText("Radera fordon");
		removeActualButton.addActionListener(listeners);
		removeActualButton.setActionCommand("removeActual");
		
		System.out.println("removeActualButton() executed");
		return removeActualButton;
	}
	
//Fields
	private JTextField posText;
	private JTextField typeText;
	private JTextField brandText;
	private JTextField regNrText;
	private JTextField ownerNameText;
	private JTextField ownerAgeText;
	private JTextField sizeText;
	
	public JPanel sizeField() {
		JPanel sizeField = new JPanel();
		sizeText = new JTextField(15);
		JLabel sizeFieldLabel = new JLabel("Ange storlek på registret:");
		
		sizeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		sizeField.add(sizeFieldLabel);
		sizeField.add(sizeText);
		
		System.out.println("sizeField() executed");
		return sizeField;
	}
	
	public String getSizeText() {
		System.out.println("getSizeText() executed");
		return sizeText.getText();
	}
	
	public JPanel posField() {
		JPanel posField = new JPanel();
		posText = new JTextField(15);
		JLabel posFieldLabel = new JLabel("Ange position:");
		
		posField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		posField.add(posFieldLabel);
		posField.add(posText);
		
		System.out.println("posField() executed");
		return posField;
	}
	
	public String getPosText() {
		System.out.println("getPosText() executed");
		return posText.getText();
	}
	
	public void clearPosField() {
		System.out.println("clearPosField() executed");
		posText.setText("");
	}
	
	
	public JPanel typeField() {
		JPanel typeField = new JPanel();
		typeText = new JTextField(15);
		JLabel typeFieldLabel = new JLabel("Ange typ:");
		
		typeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		typeField.add(typeFieldLabel);
		typeField.add(typeText);
		
		System.out.println("typeField() executed");
		return typeField;
	}
	
	public String getTypeText() {
		System.out.println("getTypeText() executed");
		return typeText.getText();
	}
	
	public void clearTypeField() {
		System.out.println("clearTypeField() executed");
		typeText.setText("");
	}
	
	
	public JPanel brandField() {
		JPanel brandField = new JPanel();
		brandText = new JTextField(15);
		JLabel brandFieldLabel = new JLabel("Ange märke:");
		
		brandField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		brandField.add(brandFieldLabel);
		brandField.add(brandText);
		
		System.out.println("brandField() executed");
		return brandField;
	}
	
	public String getBrandText() {
		System.out.println("getBrandText() executed");
		return brandText.getText();
	}
	
	public void clearBrandField() {
		System.out.println("clearBrandField() executed");
		brandText.setText("");
	}
	
	
	public JPanel regNrField() {
		JPanel regNrField = new JPanel();
		regNrText = new JTextField(15);
		JLabel regNrFieldLabel = new JLabel("Ange regNr XYZ-123:");
		
		regNrField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		regNrField.add(regNrFieldLabel);
		regNrField.add(regNrText);
		
		System.out.println("regNrField() executed");
		return regNrField;
	}
	
	public String getRegNrText() {
		System.out.println("getRegNrText() executed");
		return regNrText.getText();
	}
	
	public void clearRegNrField() {
		System.out.println("clearRegNrField() executed");
		regNrText.setText("");
	}
	
	
	public JPanel ownerNameField() {
		JPanel ownerNameField = new JPanel();
		ownerNameText = new JTextField(15);
		JLabel ownerNameFieldLabel = new JLabel("Ägares namn:");
		
		ownerNameField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		ownerNameField.add(ownerNameFieldLabel);
		ownerNameField.add(ownerNameText);
		
		System.out.println("ownerNameField() executed");
		return ownerNameField;
	}
	
	public String getOwnerNameText() {
		System.out.println("getOwnerNameText() executed");
		return ownerNameText.getText();
	}
	
	public void clearOwnerNameField() {
		System.out.println("clearOwnerNameField() executed");
		ownerNameText.setText("");
	}
	
	
	public JPanel ownerAgeField() {
		JPanel ownerAgeField = new JPanel();
		ownerAgeText = new JTextField(15);
		JLabel ownerAgeFieldLabel = new JLabel("Ägares ålder:");
		
		ownerAgeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		ownerAgeField.add(ownerAgeFieldLabel);
		ownerAgeField.add(ownerAgeText);
		
		System.out.println("ownerAgeField() executed");
		return ownerAgeField;
	}
	
	public String getOwnerAgeText() {
		System.out.println("getOwnerAgeText() executed");
		return ownerAgeText.getText();
	}
	
	public void clearOwnerAgeField() {
		System.out.println("clearOwnerAgeField() executed");
		ownerAgeText.setText("");
	}
	
	public void clearAllFields() {
		typeText.setText("");
		brandText.setText("");
		regNrText.setText("");
		ownerNameText.setText("");
		ownerAgeText.setText("");
		System.out.println("clearAllField() executed");
	}
	
	public JPanel currentSizeCount() {
		JPanel currentSizeField = new JPanel();
		currentSizeText = new JTextField(5);
		JLabel currentSizeLabel = new JLabel("Registrerade fordon:");
		
		currentSizeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		currentSizeField.add(currentSizeLabel);
		currentSizeField.add(currentSizeText);
		
		System.out.println("currentSizeCount() executed");
		return currentSizeField;
	}
	
	public void printToCurrentSizeCount(int currentSizeCount) {
		currentSizeText.setText(Integer.toString(currentSizeCount));
		System.out.println("printToCurrentSizeCount() executed");
	}
	
	public void clearCurrentSizeCount() {
		currentSizeText.setText("");
		System.out.println("clearCurrentSizeCount() executed");
	}
	
	public JPanel maxSizeCount() {
		JPanel maxSizeField = new JPanel();
		maxSizeText = new JTextField(5);
		JLabel maxSizeLabel = new JLabel("Platser i registret:");
		
		maxSizeField.setLayout(new FlowLayout(FlowLayout.TRAILING));
		maxSizeField.add(maxSizeLabel);
		maxSizeField.add(maxSizeText);
		
		System.out.println("maxSizeCount() executed");
		return maxSizeField;
	}
	
	public void printToMaxSizeCount(int maxSizeCount) {
		maxSizeText.setText(Integer.toString(maxSizeCount));
		System.out.println("printToMaxSizeCount() executed");
	}
	
	public void clearMaxSizeCount() {
		maxSizeText.setText("");
		System.out.println("clearMaxSizeCount() executed");
	}
	
//TextArea
	public JTextArea printText;
	public JTextField currentSizeText;
	public JTextField maxSizeText;
	
	public JPanel printField() {
		JPanel printField = new JPanel();
		printText = new JTextArea(30, 44);
		JScrollPane printFieldScroll = new JScrollPane(printText);
		
		printField.add(printFieldScroll);
		
		System.out.println("printField() executed");
		return printField;
	}
	
	public void printToPrintField(String text) {
		printText.append(text + "\n");
		System.out.println("printToPrintField() executed");
	}
	
	public void clearPrintField() {
		printText.setText("");
		System.out.println("clearPrintField() executed");
	}
}