package org.usfirst.frc.team5276.robot.commands;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArcadeDriveCommand extends Command {
	
	
	boolean wasUpPressed = false;
	boolean wasDownPressed = false;
    public ArcadeDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
        requires(Robot.conveyorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.conveyorSubsystem.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(!isFinished()){
    		double throttle = (Robot.oi.joystick1.getThrottle()+1)/2;
    		Robot.drivetrainSubsystem.arcadeDrive(Robot.oi.joystick1.getY()*throttle, Robot.oi.joystick1.getX()*throttle);
//    		Robot.conveyorSubsystem.conveyorMotor.set(Robot.oi.joystick2.getY());
//    		Robot.intakeSubsystem.setIntake(Robot.oi.joystick3.getY());
//    		if(Robot.oi.joystick1.getTrigger() && !wasUpPressed){
//    			Robot.conveyorSubsystem.setSetpointRelative(12.0);
//    			//System.out.println("UP");
//    		}else if(Robot.oi.joystick1.getRawButton(2) && !wasDownPressed){
//    			Robot.conveyorSubsystem.setSetpointRelative(-12.0);
//    			System.out.println("DOWN");
//    		}
//    		
//    		wasUpPressed = Robot.oi.joystick1.getTrigger();
//    		wasDownPressed = Robot.oi.joystick1.getRawButton(2);
    		SmartDashboard.putNumber("Speed Constant", throttle);

    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.conveyorSubsystem.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
