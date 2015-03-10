package org.usfirst.frc.team5276.robot.commands;

import static org.usfirst.frc.team5276.robot.Robot.conveyor;
import static org.usfirst.frc.team5276.robot.Robot.drivetrain;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetConveyorPositionCommand extends Command {

	public double distance;
	
    public SetConveyorPositionCommand(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyor);
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void setConveyor(double setPoint){
		conveyor.setSetpoint(setPoint);
    }
    protected void initialize() {
    	conveyor.setSetpoint(distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return conveyor.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
