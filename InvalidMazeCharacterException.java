public class InvalidMazeCharacterException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final String MESSAGE1 = "Invalid maze character";
    private static final String MESSAGE2 = "in file";   
    private char invalidCharacter;
    private String fileName;
    
    public InvalidMazeCharacterException (char invalidCharacter, String fileName) {
        super(String.join(MESSAGE1, Character.toString(invalidCharacter), MESSAGE2, fileName));
        this.invalidCharacter = invalidCharacter;
        this.fileName = fileName;
    }
    
    public char getInvalidCharacter() {
        return invalidCharacter;
    }
    
    public String getFileName() {
        return fileName;
    }
}
