package fousoleybot;

import fousoleybot.controller.LegsMotors;
import fousoleybot.controller.LethalArm;
import fousoleybot.sensor.ColorSensor;
import fousoleybot.sensor.RGBColor;
import fousoleybot.sensor.SonarSensor;
import fousoleybot.sensor.TouchSensor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class Main {
	public static void main(String[] args) {
		LCD.drawString("-= FousoleyBot =-", 1, 0);
		LCD.drawString("Initializing", 1, 2);

		ColorSensor colorSensor = new ColorSensor();

		LegsMotors legs = new LegsMotors();
		SonarSensor sonarSensor = new SonarSensor();
		TouchSensor touchSensor = new TouchSensor();
		LethalArm lethalArm = new LethalArm();

		LCD.clear();
		LCD.drawString("-= FousoleyBot =-", 1, 0);
		while (true) {
			if (touchSensor.isTouched()) {
				LCD.clear();
				LCD.drawString("-= FousoleyBot =-", 1, 0);
				LCD.drawString("color " + colorSensor.getColor().name(), 3, 1);
//				LCD.drawString("color " + colorSensor.getColor().getG(), 3, 2);
//				LCD.drawString("color " + colorSensor.getColor().getB(), 3, 3);
				legs.turn90Left();
				legs.waitComplete();
				lethalArm.shootUp();
				lethalArm.waitComplete();
				legs.turn90Right();
				legs.waitComplete();
			}
			float d = sonarSensor.getDistance();
			if (d > 1 && d <= 8.0) {
				return;
			}
		}

		/*
		 * RGBColor colors = colorSensor.getColor(); legs.moveForward();
		 * 
		 * while(!touchSensor.isTouched()) { LCD.refresh(); // LCD.clear();
		 * LCD.drawString("R: " + colors.getR(), 1, 2); LCD.drawString("G: " +
		 * colors.getG(), 1, 3); LCD.drawString("B: " + colors.getB(), 1, 4);
		 * 
		 * LCD.drawString("d before: " + sonarSensor.getDistance(), 1, 6); colors =
		 * colorSensor.getColor(); if(sonarSensor.getDistance() < 40.f) {
		 * lethalArm.shot(); } } legs.stop();
		 */
		// Button.waitForAnyPress();
	}
}
