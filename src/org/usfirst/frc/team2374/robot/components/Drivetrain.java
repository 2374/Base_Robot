package org.usfirst.frc.team2374.robot.components;

import org.usfirst.frc.team2374.robot.Component;

import edu.wpi.first.wpilibj.Talon;

public class Drivetrain extends Component {

	/**
	 * The robot's four drivetrain motors.
	 */
	private final Talon left1, left2, right1, right2;

	/**
	 * Creates a drivetrain with motors set to the given ports.
	 *
	 * @param left1
	 *            The port for the front-left motor.
	 * @param left2
	 *            The port for the back-left motor.
	 * @param right1
	 *            The port for the front-right motor.
	 * @param right2
	 *            The port for the back-right motor.
	 */
	public Drivetrain(int left1, int left2, int right1, int right2) {
		this.left1 = new Talon(left1);
		this.left2 = new Talon(left2);
		this.right1 = new Talon(right1);
		this.right2 = new Talon(right2);
	}

	/**
	 * This function sets the drivetrain to run at a certain speed.
	 *
	 * @param leftSpeed
	 *            The speed of the left motors.
	 * @param rightSpeed
	 *            The speed of the right motors.
	 */
	public void setSpeed(double leftSpeed1, double rightSpeed1,
			double leftSpeed2, double rightSpeed2, double gyroAngle) {
		left1.set(leftSpeed1);
		right1.set(-rightSpeed1);
		left2.set(leftSpeed2);
		right2.set(-rightSpeed2);
	}

	@Override
	public void update() {
	}
}
