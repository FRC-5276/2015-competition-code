package org.usfirst.frc.team5276.robot.commands;

import static org.usfirst.frc.team5276.robot.Robot.drivetrain;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveDistanceCommand extends Command {
	
	double leftDistance;
	double rightDistance;

    public MoveDistanceCommand(double leftDistance, double rightDistance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.leftDistance= leftDistance;
    	this.rightDistance = rightDistance;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.drivetrain.leftDriveControl.setSetpoint(leftDistance);
    	//Robot.drivetrain.rightDriveControl.setSetpoint(-rightDistance);
    	//drivetrain.leftDriveControl.enable();
    	//drivetrain.rightDriveControl.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;//Robot.drivetrain.leftDriveControl.onTarget() && Robot.drivetrain.rightDriveControl.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//drivetrain.leftDriveControl.disable();
    	//drivetrain.rightDriveControl.disable();
    	//drivetrain.drive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
