package fousoleybot;
import fousoleybot.controller.LegsMotors;
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
	    SonarSensor sonarSensor = new SonarSensor();
	    LegsMotors legs = new LegsMotors();
	    TouchSensor touchSensor = new TouchSensor();

		LCD.clear();
		LCD.drawString("-= FousoleyBot =-", 1, 0);
		
		RGBColor colors = colorSensor.getColor();
	    legs.moveForward();
	    
		while(!touchSensor.isTouched()) {
		    LCD.refresh();
		    // LCD.clear();
		    LCD.drawString("R: " + colors.getR(), 1, 2);
		    LCD.drawString("G: " + colors.getG(), 1, 3);
		    LCD.drawString("B: " + colors.getB(), 1, 4);
		    
		    LCD.drawString("d before: " + sonarSensor.getDistance(), 1, 6);
		
		    LCD.drawString("d after: " + sonarSensor.getDistance(), 1, 7);
		    colors = colorSensor.getColor();
		}
		legs.stop();
		Button.waitForAnyPress();
	}
}
