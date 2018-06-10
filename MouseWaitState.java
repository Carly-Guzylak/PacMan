
public class MouseWaitState implements State {

	private Mouse mouse;
	
	public MouseWaitState (Mouse mouse) {
	    this.mouse = mouse;	
	}
	
	public void enter() {
		mouse.stop();
		mouse.moveIntoCell();
		if(mouse.foundCheese()) {
			mouse.eatCheese();
		}
	}

	public void performAction() {
		
	}

	public void exit() {
		
	}
    
}
