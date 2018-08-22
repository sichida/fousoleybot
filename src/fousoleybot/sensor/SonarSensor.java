package fousoleybot.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;

public class SonarSensor {

	private SensorMode distanceResolver;
	
	public SonarSensor() {
		EV3IRSensor sonar = new EV3IRSensor(SensorPort.S4); 
		distanceResolver = sonar.getDistanceMode();
	}

	public float getDistance() {
		float[] distance = new float[distanceResolver.sampleSize()];
		distanceResolver.fetchSample(distance, 0);
		return distance[0];
	}
	
}
