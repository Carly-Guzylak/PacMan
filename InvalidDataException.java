
public class InvalidDataException extends Exception {
	private String invalidData;
    public InvalidDataException (String invalidData) {
        super(invalidData + "is not allowed.");
        this.invalidData = invalidData;
    }

}
