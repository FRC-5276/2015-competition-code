package org.usfirst.frc.team5276.robot.commands;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetConveyorCommand extends Command {
	public double distance;
	public double stageNumber;
	boolean finished = false;
    public SetConveyorCommand(double distance) {
        requires(Robot.conveyorSubsystem);
        this.distance = distance;
        this.stageNumber = stageNumber;
        //Robot.oi.upButton.whenPressed(new SetConveyorCommand(12.0));
    	//Robot.oi.downButton.whenPressed(new SetConveyorCommand(0.0));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.manualConveyorControl==false) {
    		stageNumber = 1;
    		Robot.conveyorSubsystem.setSetpointRelative(distance);
    		finished = true;
//    		System.out.println("Button pressed. ");
    		if (distance == 12.0) {
    			System.out.println("Up Button Pressed");
    			stageNumber = stageNumber + 1;
    		}
    		else {
    			System.out.println("Down Button Pressed");
    			stageNumber = stageNumber - 1;
    		}
    		SmartDashboard.putNumber("Stage Number", stageNumber);
    	}
    	else if (Robot.oi.manualConveyorControl==true) {
    		Robot.conveyorSubsystem.setSetpointRelative(Robot.oi.joystick3.getY());
    	}
    	SmartDashboard.putBoolean("Manual Conveyor Control", Robot.oi.manualConveyorControl);
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
