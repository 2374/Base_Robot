package org.usfirst.frc.team2374.robot.components;

import org.usfirst.frc.team2374.robot.Component;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class Drivetrain extends Component {

	/**
	 * The robot's four drivetrain motors.
	 */
	private final Talon left1, left2, right1, right2;
	private MotorType motorType;
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
	public Drivetrain(int left1, int left2, int right1, int right2){
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
	public void setSpeed(double x, double y, double rotation, double gyroAngle) {
		double xInput = x;
		double yInput = y;
		
	    double rotated[] = rotateVector(xInput, yInput, gyroAngle);//rotate function is for field-oriented controls, in theory it should compensate for the robot turning so that it always turns according to angle 0
	    xInput = rotated[0];
	    yInput = rotated[1];
	    
	    int frontLeftVal = left1.getChannel();
		int backLeftVal = left2.getChannel();
		int frontRightVal = right1.getChannel();
		int backRightVal = right2.getChannel();

	    double wheelSpeeds[] = new double[4];
	    wheelSpeeds[frontLeftVal] = xInput + yInput + rotation;
	    wheelSpeeds[frontRightVal] = -xInput + yInput - rotation;
	    wheelSpeeds[backLeftVal] = -xInput + yInput + rotation;
	    wheelSpeeds[backRightVal] = xInput + yInput - rotation;
	    
	    normalize(wheelSpeeds);//normalize function caps wheel speed at -1, 1
	    left1.set(wheelSpeeds[frontLeftVal]);
	    right1.set(wheelSpeeds[frontRightVal]);
	    left2.set(wheelSpeeds[backLeftVal]);
	    right2.set(wheelSpeeds[backRightVal]);
	}
	  protected static void normalize(double wheelSpeeds[]) {
		    double maxMagnitude = Math.abs(wheelSpeeds[0]);
		    int i;
		    for (i = 1; i < 4; i++) {
		      double temp = Math.abs(wheelSpeeds[i]);
		      if (maxMagnitude < temp)
		        maxMagnitude = temp;
		    }
		    if (maxMagnitude > 1.0) {
		      for (i = 0; i < 4; i++) {
		        wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
		      }
		    }
		  }
	    public static double[] rotateVector(double xInput, double yInput, double gyroAngle) {
	        double cosA = Math.cos(gyroAngle * (3.14159 / 180.0));
	        double sinA = Math.sin(gyroAngle * (3.14159 / 180.0));
	        double out[] = new double[2];
	        out[0] = xInput * cosA - yInput * sinA;
	        out[1] = xInput * sinA + yInput * cosA;
	        return out;
	      }

	@Override
	public void update() {
	}
}


