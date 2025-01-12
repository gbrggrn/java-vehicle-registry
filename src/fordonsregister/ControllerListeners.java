package fordonsregister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

//Holds listener-structure for all actions.

public class ControllerListeners extends WindowAdapter implements ActionListener{
	
	private ControllerButtonLogic buttonLogic;
	private ViewBuildUI framePanel;
	
	public ControllerListeners () {
		
	}
	
	public void setButtonLogic(ControllerButtonLogic buttonLogic) {
		this.buttonLogic = buttonLogic;
	}
	
	public void setFramePanel(ViewBuildUI framePanel) {
		this.framePanel = framePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("newRegister")) {
			framePanel.buildSetRegisterSize();
			framePanel.getQuestion().setVisible(false);
		}
		
		if(e.getActionCommand().equals("upload")) {
			buttonLogic.loadButtonLogic();
		}
		
		if(e.getActionCommand().equals("size")) {
			buttonLogic.sizeButtonLogic();
		}
		
		if(e.getActionCommand().equals("add")) {
			buttonLogic.addButtonLogic();
		}
		
		if(e.getActionCommand().equals("remove")) {
			framePanel.buildRemoveFordon();
		}
		
		if(e.getActionCommand().equals("print")) {
			buttonLogic.printButtonLogic();
		}
		
		if(e.getActionCommand().equals("search")) {
			framePanel.buildSearchFunction();
		}
		
		if(e.getActionCommand().equals("searchActual")) {
			buttonLogic.searchButtonLogic();
		}
		
		if(e.getActionCommand().equals("removeActual")) {
			buttonLogic.removeButtonLogic();
		}
		
		if(e.getActionCommand().equals("loadFile")) {
			buttonLogic.loadButtonLogic();
		}
		
		if(e.getActionCommand().equals("saveAll")) {
			buttonLogic.saveButtonLogic();
		}
	}
}