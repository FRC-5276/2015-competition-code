package org.usfirst.frc.team5276.robot.commands;

import static org.usfirst.frc.team5276.robot.Robot.*;
import org.usfirst.frc.team5276.robot.subsystems.ConveyorSubsystem;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDriveCommand extends Command {
	
	

    public TankDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.conveyorSubsystem.enableSpeedControl();
    }
    
    protected void setConveyor(double setPoint){
		conveyor.setSetpoint(setPoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//while(!isFinished()){
    		SmartDashboard.putNumber("Conveyor Encoder", conveyor.conveyorEncoder.getDistance());
    		
    		drivetrain.arcadeDrive(oi.joystick1.getY(), oi.joystick1.getX());
    		intake.setIntake(-oi.joystick3.getY());
//    		conveyorSubsystem.setSpeedTarget(oi.joystick4.getY());
    		if (oi.joystick4.getPOV()==0 && conveyor.isEnabled()) {
    			setConveyor(conveyor.getNextStageTarget(true));
    			conveyor.enable();
    		}
    		else if (oi.joystick4.getPOV(0)==180 && conveyor.isEnabled()) {
    			setConveyor(conveyor.getNextStageTarget(false));
    			conveyor.enable();
    		}
    		else if(oi.joystick4.getTrigger()){
    			setConveyor(conveyor.conveyorEncoder.getDistance());
    			conveyor.enable();
    		}else if(oi.joystick4.getRawButton(3)){
    			setConveyor(ConveyorSubsystem.STAGE_0);
    			conveyor.enable();
    		}else if(oi.joystick4.getRawButton(5)){
    			setConveyor(ConveyorSubsystem.STAGE_1);
    			conveyor.enable();
    		}else if(oi.joystick4.getRawButton(4)){
    			setConveyor(ConveyorSubsystem.STAGE_2);
    			conveyor.enable();
    		}else if(oi.joystick4.getRawButton(6)){
    			setConveyor(ConveyorSubsystem.STAGE_3);
    			conveyor.enable();
    		}else{
    			conveyor.disable();
    			conveyor.setPower(oi.joystick4.getY(), !oi.joystick4.getRawButton(2));
    		}
    		
    		if(oi.joystick4.getRawButton(11)){
    			conveyor.conveyorEncoder.reset();
    		}
    		SmartDashboard.putNumber("Conveyor Encoder Value", conveyor.conveyorEncoder.getDistance());
    		SmartDashboard.putNumber("NextUpStage", conveyor.getNextStageTarget(true));
    		SmartDashboard.putNumber("NextDownStage", conveyor.getNextStageTarget(false));
    		SmartDashboard.putBoolean("Safety", !oi.joystick4.getRawButton(2));

    		
    	//}
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
