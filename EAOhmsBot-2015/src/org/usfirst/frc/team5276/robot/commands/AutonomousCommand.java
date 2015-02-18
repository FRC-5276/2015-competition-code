
package org.usfirst.frc.team5276.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5276.robot.Robot;

/**
 *
 */
public class AutonomousCommand extends Command {

    public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.conveyorSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.conveyorSubsystem.conveyorMotor.set(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyorSubsystem.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
