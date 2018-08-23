package fousoleybot.controller;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class LegsMotors {
	private RegulatedMotor left;
	private RegulatedMotor right;

	public LegsMotors() {
		left = new EV3LargeRegulatedMotor(MotorPort.B);
		right = new EV3LargeRegulatedMotor(MotorPort.C);
	}

	public void startSynchronizeLegs() {
		left.synchronizeWith(new RegulatedMotor[] { right });
		left.startSynchronization();
	}

	public void stopSynchronizedLegs() {
		left.endSynchronization();
		right.endSynchronization();
	}

	public void moveForward(int delay) {
		this.startSynchronizeLegs();

		left.forward();
		right.forward();

		this.stopSynchronizedLegs();

		Delay.msDelay(delay);

		left.stop(true);
		right.stop(true);
	}
	
	public void moveBackward(int delay) {
		this.startSynchronizeLegs();

		left.backward();
		right.backward();

		this.stopSynchronizedLegs();

		Delay.msDelay(delay);

		left.stop(true);
		right.stop(true);
	}

	public void moveForward() {
		this.startSynchronizeLegs();

		left.forward();
		right.forward();

		this.stopSynchronizedLegs();
	}

	public void stop() {
		left.stop(true);
		right.stop(true);
	}
	
	public void moveBackward() {
		this.startSynchronizeLegs();

		left.backward();
		right.backward();

		this.stopSynchronizedLegs();
	}

}
