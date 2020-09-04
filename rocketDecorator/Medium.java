package rocketDecorator;

public class Medium extends Rocket {
	
	public Medium() {
		description = "Medium";
	}
	
	public int cost() {
		return 1000;
	}
	
	public int range() {
		return 20000;
	}

}
