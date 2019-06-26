package fousoleybot.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.ColorIdentifier;

public class ColorSensor {
	private SensorMode brightnessSensorMode;
	private EV3ColorSensor colorSensor;

	public ColorSensor() {
		colorSensor = new EV3ColorSensor(SensorPort.S3);
		colorSensor.setFloodlight(true);
		brightnessSensorMode = colorSensor.getColorIDMode();
	}

	public ColorEnum getColor() {
		float[] colors = new float[brightnessSensorMode.sampleSize()];
		brightnessSensorMode.fetchSample(colors, 0);
		return ColorEnum.fromColorId(colorSensor.getColorID());
	}

}
