package fordonsregister;

import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//Holds methods to create the basic Frames and Panels as well as methods for building the GUI.

@SuppressWarnings("serial")
public class ViewBuildUI extends JFrame {
	
	private ControllerListeners listeners;
	private ViewComponents components;
	private ModelFordonsregister fordonsRegister;
	
	public ViewBuildUI(ControllerListeners listeners, ViewComponents components, ModelFordonsregister fordonsRegister) {
		this.listeners = listeners;
		this.components = components;
		this.fordonsRegister = fordonsRegister;
	}
	
//Frames and Panels
	public JFrame buildMainFrame() {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(442,818);
		mainFrame.setTitle("Fordonsregister");
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		
		System.out.println("buildMainFrame() executed");
		return mainFrame;
	}
	
	public JFrame secondaryFrame() {
		JFrame secondaryFrame = new JFrame();
		secondaryFrame.setSize(410,100);
		secondaryFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		secondaryFrame.setResizable(false);
		secondaryFrame.setLocationRelativeTo(null);
		
		System.out.println("secondaryFrame() executed");
		return secondaryFrame;
	}
	
	public JPanel buildMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		System.out.println("buildMainPanel() executed");
		return mainPanel;
	}
	
	public JPanel buildButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		System.out.println("buildButtonPanel() executed");
		return buttonPanel;
	}
	
	public JPanel buildFieldPanel() {
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
		
		System.out.println("buildFieldPanel() executed");
		return fieldPanel;
	}
	
	public JPanel buildLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
		
		System.out.println("buildLabelPanel() executed");
		return labelPanel;
	}
	
	public JPanel buildPrintPanel() {
		JPanel printPanel = new JPanel();
		
		System.out.println("buildPrintPanel() executed");
		return printPanel;
	}
	
	public JPanel saveButtonPanel() {
		JPanel saveButtonPanel = new JPanel();
		
		System.out.println("saveButtonPanel() executed");
		return saveButtonPanel;
	}
	
//Menu
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem loadItem;
	
	public JMenuBar buildMenuBar() {
		menuBar = new JMenuBar();
		
		menuBar.add(buildFileMenu());
		
		System.out.println("buildMenuBar() executed");
		return menuBar;
	}

			
	public JMenu buildFileMenu() {
		fileMenu = new JMenu();
			
		fileMenu.setText("Fil");
		fileMenu.add(buildLoadItem());
		
		System.out.println("buildFileMenu() executed");
		return fileMenu;
	}
		
	public JMenuItem buildLoadItem() {
		loadItem = new JMenuItem();
			
		loadItem.setText("Ladda fil");
		loadItem.addActionListener(listeners);
		loadItem.setActionCommand("loadFile");
		
		System.out.println("buildLoadItem() executed");
		return loadItem;
	}

//UI-build
	private JFrame mainFrame;
	private JFrame question;
	private JFrame firstFrame;
	private JFrame secondFrame;
	private JFrame thirdFrame;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JPanel saveButtonPanel;
	private JPanel fieldPanel;
	private JPanel printPanel;
	private JPanel counterPanel;
	
	public void buildUI() {
		mainFrame = buildMainFrame();
		mainPanel = buildMainPanel();
		
		buttonPanel = buildButtonPanel();
		buttonPanel.add(components.addButton(listeners));
		buttonPanel.add(Box.createVerticalStrut(11));
		buttonPanel.add(components.removeButton(listeners));
		buttonPanel.add(Box.createVerticalStrut(11));
		buttonPanel.add(components.searchPosButton(listeners));
		buttonPanel.add(Box.createVerticalStrut(11));
		buttonPanel.add(components.printButton(listeners));
		
		fieldPanel = buildFieldPanel();
		fieldPanel.add(components.typeField());
		fieldPanel.add(components.brandField());
		fieldPanel.add(components.regNrField());
		fieldPanel.add(components.ownerNameField());
		fieldPanel.add(components.ownerAgeField());
		
		counterPanel = buildLabelPanel();
		counterPanel.add(Box.createHorizontalStrut(25));
		counterPanel.add(components.maxSizeCount());
		components.printToMaxSizeCount(fordonsRegister.getMaxSize());
		counterPanel.add(components.currentSizeCount());
		components.printToCurrentSizeCount(fordonsRegister.getCurrentSize());
		
		printPanel = buildPrintPanel();
		printPanel.add(components.printField());
		
		saveButtonPanel = saveButtonPanel();
		saveButtonPanel.add(Box.createHorizontalStrut(125));
		saveButtonPanel.add(components.saveButton(listeners));
		
		mainPanel.add(fieldPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(counterPanel);
		mainPanel.add(printPanel);
		mainPanel.add(saveButtonPanel);
		
		mainFrame.add(mainPanel);
		mainFrame.setJMenuBar(buildMenuBar());
		mainFrame.setVisible(true);
		
		System.out.println("buildUI() executed");
	}
	
	public JFrame getMainFrame() {
		System.out.println("getMainFrame() executed");
		return mainFrame;
	}
	
	public void buildQuestion() {
		question = secondaryFrame();
		question.setTitle("Fordonsregister");
		mainPanel = buildMainPanel();
		
		mainPanel.add(Box.createHorizontalStrut(55));
		mainPanel.add(components.newRegisterButton(listeners));
		mainPanel.add(Box.createHorizontalStrut(30));
		mainPanel.add(components.uploadButton(listeners));
		
		question.add(mainPanel);
		question.setVisible(true);
		System.out.println("buildQuestion() executed");
	}
	
	public JFrame getQuestion() {
		System.out.println("getQuestion() executed");
		return question;
	}
	
	public void buildSetRegisterSize() {
		firstFrame = secondaryFrame();
		firstFrame.setTitle("Ange storlek på registret");
		mainPanel = buildMainPanel();
		
		mainPanel.add(components.sizeField());
		mainPanel.add(components.sizeButton(listeners));
		
		firstFrame.add(mainPanel);
		firstFrame.setVisible(true);
		System.out.println("buildSetRegisterSize() executed");
	}
	
	public JFrame getFirstFrame() {
		System.out.println("getFirstFrame() executed");
		return firstFrame;
	}
	
	public void buildSearchFunction() {
		secondFrame = secondaryFrame();
		secondFrame.setTitle("Sök fordon enligt position");
		mainPanel = buildMainPanel();
		
		mainPanel.add(components.posField());
		mainPanel.add(components.searchActualButton(listeners));
		
		secondFrame.add(mainPanel);
		secondFrame.setVisible(true);
		System.out.println("buildSearchFunction() executed");
	}
	
	public JFrame getSecondFrame() {
		System.out.println("getSecondFrame() executed");
		return secondFrame;
	}
	
	public void buildRemoveFordon() {
		thirdFrame = secondaryFrame();
		mainPanel = buildMainPanel();
		
		mainPanel.add(components.posField());
		mainPanel.add(components.removeActualButton(listeners));
		
		thirdFrame.add(mainPanel);
		thirdFrame.setVisible(true);
		System.out.println("buildRemoveFordon() executed");
	}
	
	public JFrame getThirdFrame() {
		System.out.println("getThirdFrame() executed");
		return thirdFrame;
	}
}