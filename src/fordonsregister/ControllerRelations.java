package fordonsregister;

//Declares the relationships between all classes except "Person" & "Fordon".
//Also holds the launch()-method.

public class ControllerRelations {
	
	private ModelFordonsregister fordonsRegister;
	private ModelFilehandling fileHandling;
	private ViewBuildUI framePanel;
	private ViewComponents components;
	private ControllerInputValidation inputValidation;
	private ControllerListeners listeners;
	private ControllerButtonLogic buttonLogic;
	
	public ControllerRelations () {
		this.fordonsRegister = new ModelFordonsregister();
		this.inputValidation = new ControllerInputValidation();
		this.listeners = new ControllerListeners();
		this.components = new ViewComponents();
		this.framePanel = new ViewBuildUI(listeners, components, fordonsRegister);
		this.fileHandling = new ModelFilehandling(fordonsRegister);
		this.buttonLogic = new ControllerButtonLogic(fordonsRegister, inputValidation, components, framePanel, fileHandling);
		listeners.setButtonLogic(buttonLogic);
		listeners.setFramePanel(framePanel);
	}
	
	public ControllerButtonLogic getButtonLogic() {
		return this.buttonLogic;
	}
	
	public ViewBuildUI getFramePanel() {
		return this.framePanel;
	}
	
	public void launch() {
		framePanel.buildQuestion();
	}
}