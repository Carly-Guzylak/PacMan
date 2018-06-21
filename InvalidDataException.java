
public class InvalidDataException extends Exception {
	private static final long serialVersionUID = 1L;
	private String invalidData;
    public InvalidDataException (String invalidData) {
        super(invalidData + "is not allowed.");
        this.invalidData = invalidData;
    }
}
