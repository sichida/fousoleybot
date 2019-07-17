package fousoleybot.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.ColorIdentifier;

public class ColorSensor {
	private SensorMode brightnessSensorMode;
	private EV3ColorSensor colorSensor;
	private float[] sample;

	public ColorSensor() {
		colorSensor = new EV3ColorSensor(SensorPort.S3);
		colorSensor.setFloodlight(false);
		brightnessSensorMode = colorSensor.getRGBMode();
	}

	public Color getColor() {
//		colorSensor.setCurrentMode("RGB");
//		sample = new float[colorSensor.sampleSize()];
//		colorSensor.fetchSample(sample, 0);
		float[] colors = new float[brightnessSensorMode.sampleSize()];
		brightnessSensorMode.fetchSample(colors, 0);
		return new Color((int) (colors[0] * 255), (int) (colors[1] * 255), (int) (colors[2] * 255));

//		return ColorEnum.fromColorId(colorSensor.getColorID());
	}

}
