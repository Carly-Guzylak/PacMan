
public class MouseWaitState implements State {

	private Mouse mouse;
	
	public MouseWaitState (Mouse mouse) {
	    this.mouse = mouse;	
	}
	
	public void enter() {
		mouse.stop();
	}

	public void performAction() {
		
	}

	public void exit() {
		
	}
    
}
