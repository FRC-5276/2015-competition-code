package org.usfirst.frc.team5276.robot.commands;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveTimeCommand extends Command {
	
	double power;
	double seconds;
	Timer timer = new Timer();

    public MoveTimeCommand(double power, double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.power = power;
    	this.seconds = seconds;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(power, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= seconds;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive.stopMotor();
    	timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
