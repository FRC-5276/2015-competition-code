package org.usfirst.frc.team5276.robot.commands;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OmniDriveCommand extends Command {

    public OmniDriveCommand() {
        // Use requires() here to declare subsystem dependencies
//    	requires(Robot.omnidriveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(!isFinished()){
//    		Robot.omnidriveSubsystem.OmniDrive(Robot.oi.joystick1.getX(), Robot.oi.joystick1.getY(), Robot.oi.joystick1.getZ(), Robot.oi.joystick1.getThrottle(), Robot.oi.gyro.getAngle());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
