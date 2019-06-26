package fousoleybot.controller;

import lejos.utility.Delay;

public class LethalArm extends ArmMotor{

	public LethalArm() {
		super();
		this.getArm().setSpeed(Float.floatToIntBits(this.getArm().getMaxSpeed()));
	}
	
	public void shoot() {
		this.getArm().forward();
		Delay.msDelay(500);		
		this.getArm().stop(true);
	}

	public void shootUp() {
		this.getArm().backward();
		Delay.msDelay(500);		
		this.getArm().stop(true);
	}
	
	public void waitComplete() {
		this.getArm().waitComplete();
	}
}
