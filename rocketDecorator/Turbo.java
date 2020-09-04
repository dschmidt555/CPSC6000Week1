package rocketDecorator;

public class Turbo extends UpgradeDecorator{
	
	public Turbo(Rocket rocket) {
		this.rocket = rocket;
	}
	
	public String getDesc() {
		return rocket.getDesc() + ", with Turbo";
	}
	
	public int cost() {
		return rocket.cost() + 60;
	}
	
	public int range() {
		return rocket.range() + 1200;
	}

}
