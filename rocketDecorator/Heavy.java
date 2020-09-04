package rocketDecorator;

public class Heavy extends Rocket {
	
	public Heavy() {
		description = "Heavy";
	}
	
	public int cost() {
		return 2500;
	}
	
	public int range() {
		return 75000;
	}

}
