package fousoleybot.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class SonarSensor {

	private SampleProvider distanceResolver;
	
	public SonarSensor() {
		EV3UltrasonicSensor sonar = new EV3UltrasonicSensor(SensorPort.S4); 
		distanceResolver = sonar.getDistanceMode();
	}

	public float getDistance() {
		float[] distance = new float[distanceResolver.sampleSize()];
		distanceResolver.fetchSample(distance, 0);
		return distance[0] * 1000.0f;
	}
	
}
