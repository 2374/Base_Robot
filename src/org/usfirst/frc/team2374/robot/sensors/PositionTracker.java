package org.usfirst.frc.team2374.robot.sensors;

import org.usfirst.frc.team2374.robot.Robot.RobotSystem;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

public class PositionTracker extends RobotSystem {
	/**
	 * The robot's gyroscope.
	 */
	public static AnalogGyro gyroscope;

	/**
	 * Creates a new position tracker with gyroscope set to the given port.
	 *
	 * @param gyroPort
	 *            The port for the gyroscope.
	 */
	public PositionTracker(int gyroPort) {
		gyroscope = new AnalogGyro(new AnalogInput(gyroPort));
		reset();
	}

	/**
	 * This function gets the current direction of the robot
	 *
	 * @return The current direction of the robot
	 */
	public static double direction() {
		return gyroscope.getAngle();
	}

	/**
	 * This function resets the position tracker's data.
	 */
	public void reset() {
		gyroscope.reset();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
