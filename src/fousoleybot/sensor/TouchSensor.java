package fousoleybot.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;

public class TouchSensor {

	private SensorMode touchMode;
	
	public TouchSensor() {
		EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
		touchMode = touchSensor.getTouchMode();
		
	}
	
	public boolean isTouched() {
		float[] isTouched = new float[touchMode.sampleSize()];
		touchMode.fetchSample(isTouched, 0);
		return isTouched[0] == 1.f;
	}

}
