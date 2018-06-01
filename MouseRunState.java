public class MouseRunState implements State {
    private Mouse mouse;
    
    public MouseRunState(Mouse mouse) {
        this.mouse = mouse;
    }
    
    public void enter() {
    
    }
    
    public void performAction() {
        mouse.run();
    }
    
    public void exit() {
    
    }
}
