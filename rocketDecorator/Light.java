package rocketDecorator;

public class Light extends Rocket {
	
	public Light() {
		description = "Light";
	}
	
	public int cost() {
		return 500;
	}
	
	public int range() {
		return 10000;
	}
	

}
