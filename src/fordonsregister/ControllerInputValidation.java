package fordonsregister;

public class ControllerInputValidation {
	
	private String regexString = "[a-zA-ZåäöÅÄÖ]+";
	private String regexRegNr = "[A-ZÅÄÖ]{3}-\\d{3}";
	
//pre: input is of type string
//post: return boolean [true] if input can not be parsed as int and matches regexString.
	public boolean checkInputString(String input) {
		while (true) {
			try {
				Integer.parseInt(input);
				return false;
			} catch (NumberFormatException e) {
				if(input.matches(regexString)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
//pre: input is of type string
//post: return boolean [true] if input can be parsed as int
	public boolean checkInputIntString(String input) {
		while (true) {
			try {
				Integer.parseInt(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}
	
//pre: input is of type string
//post: return boolean [true] if input matches regexRegNr.
	public boolean checkInputRegNr(String input) {
		while (true) {
			if(input.matches(regexRegNr)) {
				return true;
			} else {
				return false;
			}
		}
	}
}