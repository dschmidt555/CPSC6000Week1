package rocketDecorator;

public class Booster extends UpgradeDecorator{
	
	public Booster(Rocket rocket) {
		this.rocket = rocket;
	}
	
	public String getDesc() {
		return rocket.getDesc() + ", with Booster";
	}
	
	public int cost() {
		return rocket.cost() + 45;
	}
	
	public int range() {
		return rocket.range() + 1000;
	}

}
