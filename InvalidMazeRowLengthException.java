public class InvalidMazeRowLengthException extends Exception{
    private static final long serialVersionUID = 1L;
    private static final String MESSAGE1 = "Inconsistent row length at row";
    private static final String MESSAGE2 = "in file";
    private int invalidRow;
    private String fileName;
    
    public InvalidMazeRowLengthException(int invalidRow, String fileName) {
       super(String.join(MESSAGE1, String.valueOf(invalidRow), MESSAGE2, fileName));
       this.invalidRow = invalidRow;
       this.fileName = fileName;
    }
    
    public int getInvalidRow() {
        return invalidRow;
    }
    
    public String getFileName() {
        return fileName;
    }
}
