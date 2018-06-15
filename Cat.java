public class Cat extends MazeRunner {
    private static final String CAT_UP = "/catUp.png"
    private static final String CAT_DOWN = "/catDown.png"
    private static final String CAT_LEFT = "/catLeft.png"
    private static final String CAT_RIGHT = "/catRight.png"
    private Mouse mouse;
    
    public Cat (Mouse mouse, Cat cat) {
        this.mouse = mouse;
        //note, maze is in MazeRunner
        this.maze = maze;
    }
}
