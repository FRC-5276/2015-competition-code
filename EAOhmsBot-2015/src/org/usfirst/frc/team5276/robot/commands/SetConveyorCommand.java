package org.usfirst.frc.team5276.robot.commands;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetConveyorCommand extends Command {
	public double distance;
	boolean finished = false;
    public SetConveyorCommand(double distance) {
        requires(Robot.conveyorSubsystem);
        this.distance = distance;
        Robot.oi.upButton.whenPressed(new SetConveyorCommand(12.0));
    	Robot.oi.downButton.whenPressed(new SetConveyorCommand(0.0));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	finished = true;
    	System.out.println("button pressed");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyorSubsystem.setSetpoint(distance);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
