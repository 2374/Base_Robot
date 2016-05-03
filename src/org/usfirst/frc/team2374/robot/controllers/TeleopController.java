package org.usfirst.frc.team2374.robot.controllers;

import org.usfirst.frc.team2374.robot.Controller;
import org.usfirst.frc.team2374.robot.commands.MecanumDriveCommand;

public class TeleopController extends Controller {

	@Override
	public void start() {
		// This controls the robot's wheels
		new MecanumDriveCommand().startAsDefaultCommand();
	}
}
