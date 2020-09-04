package rocketDecorator;

public class WarpDrive extends UpgradeDecorator{
	
	public WarpDrive(Rocket rocket) {
		this.rocket = rocket;
	}
	
	public String getDesc() {
		return rocket.getDesc() + ", with Warp Drive";
	}
	
	public int cost() {
		return rocket.cost() + 1000000;
	}
	
	public int range() {
		return rocket.range() + 50000000;
	}

}
