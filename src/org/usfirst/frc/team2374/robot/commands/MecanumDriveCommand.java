package org.usfirst.frc.team2374.robot.commands;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team2374.robot.Command;
import org.usfirst.frc.team2374.robot.Component;
import org.usfirst.frc.team2374.robot.Robot;
import org.usfirst.frc.team2374.robot.events.Input;

public class MecanumDriveCommand extends Command {

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public List<Component> requires() {
		return Arrays.asList(Robot.drivetrain);
	}

	public double quadraticScale(double value) {
		if (Math.abs(value) < 0.5)
			return 0;// deadzone
		return value * Math.abs(value);
	}

	@Override
	public void update() {
		Robot.drivetrain.setSpeed(normalize(quadraticScale(xInput) + quadraticScale(yInput) + quadraticScale(rotation)),
				normalize(-quadraticScale(xInput) + quadraticScale(yInput) - quadraticScale(rotation)),
				normalize(-quadraticScale(xInput) + quadraticScale(yInput) + quadraticScale(rotation)),
				normalize(quadraticScale(xInput) + quadraticScale(yInput) - quadraticScale(rotation)), 0);

	}

	double xInput = Input.getAxis(0);
	double yInput = Input.getAxis(1);
	double rotation = Input.getAxis(5);

	// double gyroAngle = PositionTracker.direction();

	/*
	 * double rotated[] = rotateVector(xInput, yInput, gyroAngle); xInput =
	 * rotated[0]; yInput = rotated[1];
	 */
	// put this back in if we ever want to use a gyroscope

	protected static double normalize(double value) {
		if (value > 1.0)
			return 1;
		if (value < -1.0)
			return -1;
		else
			return value;
	}
}
// put this back in if we ever want to use a gyroscope
/*
 * public static double[] rotateVector(double xInput, double yInput, double
 * gyroAngle) { double cosA = Math.cos(gyroAngle * (3.14159 / 180.0)); double
 * sinA = Math.sin(gyroAngle * (3.14159 / 180.0)); double out[] = new double[2];
 * out[0] = xInput * cosA - yInput * sinA; out[1] = xInput * sinA + yInput *
 * cosA; return out; }
 */
