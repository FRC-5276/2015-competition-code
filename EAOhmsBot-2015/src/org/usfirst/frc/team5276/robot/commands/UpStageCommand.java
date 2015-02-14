package org.usfirst.frc.team5276.robot.commands;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpStageCommand extends Command {

    public UpStageCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double original = Robot.oi.enc2.get();
		double objective = original + 0.5;
		while (original!=objective) {
			Robot.conveyorSubsystem.setConveyorStageUp();
		}
		Robot.conveyorSubsystem.stopMotor();
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