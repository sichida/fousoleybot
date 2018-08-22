package fousoleybot.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class ColorSensor {
	private SensorMode brightnessSensorMode;

	public ColorSensor() {
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
		colorSensor.setFloodlight(false);
	    brightnessSensorMode = colorSensor.getRGBMode();
	}

	public RGBColor getColor() {
		float[] colors = new float[brightnessSensorMode.sampleSize()];
	    brightnessSensorMode.fetchSample(colors, 0);
	    return new RGBColor(colors[0], colors[1], colors[2]);
	}
	
}
