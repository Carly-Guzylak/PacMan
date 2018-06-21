
public class CatHuntState implements State {

	private Cat cat;
	
	public CatHuntState (Cat cat){
		this.cat = cat;
	}
	
	public void enter() {
        cat.setSpeed(Cat.SPEED_HUNT);
	}

	public void performAction() {
        cat.hunt();
	}

	public void exit() {
        cat.moveIntoCell();
	}

}
