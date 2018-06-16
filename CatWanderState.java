
public class CatWanderState implements State {
    private Cat cat;
    
    public CatWanderState(Cat cat) {
    	this.cat = cat;
    }
    
	public void enter() {
        cat.setSpeed(Cat.SPEED_WANDER);
	}

	public void performAction() {
        cat.followPath();
	}

	public void exit() {
        cat.moveIntoCell();
	}

}
