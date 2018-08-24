package fousoleybot.controller;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public abstract class ArmMotor {
	private RegulatedMotor arm;

	public ArmMotor() {
		setArm(new EV3LargeRegulatedMotor(MotorPort.A));
	}

	public RegulatedMotor getArm() {
		return arm;
	}

	public void setArm(RegulatedMotor arm) {
		this.arm = arm;
	}

	
}
