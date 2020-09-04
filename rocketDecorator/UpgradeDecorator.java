package rocketDecorator;

public abstract class UpgradeDecorator extends Rocket{

	public Rocket rocket;
	public abstract String getDesc();
	
	public Model getModel() {
		return rocket.getModel();
	}
	
	

}
