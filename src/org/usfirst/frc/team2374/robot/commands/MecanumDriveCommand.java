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
		Robot.drivetrain.setSpeed(Input.getAxis(0), Input.getAxis(1), Input.getAxis(5), 0);
		}

	}
