package org.usfirst.frc.team5276.robot.commands;

import org.usfirst.frc.team5276.robot.Robot;
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
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.conveyorSubsystem.enableSpeedControl();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(!isFinished()){
    		Robot.drivetrainSubsystem.tankDrive(Robot.oi.joystick1.getY(), Robot.oi.joystick2.getY());
    		Robot.intakeSubsystem.setIntake(Robot.oi.joystick3.getY());
    		//Robot.conveyorSubsystem.setSpeedTarget(Robot.oi.joystick4.getY());
    		if(Robot.oi.joystick4.getTrigger()){
    			if(!Robot.conveyorSubsystem.getPIDController().isEnable() && !Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.setSetpoint(Robot.conveyorSubsystem.conveyorEncoder.getDistance());
    				Robot.conveyorSubsystem.enable();
    			}else if(Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.conveyorMotor.set(0);
    			}
    		}else if(Robot.oi.joystick4.getRawButton(11)){
    			if(!Robot.conveyorSubsystem.getPIDController().isEnable() && !Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.setSetpoint(ConveyorSubsystem.STAGE_0);
    				Robot.conveyorSubsystem.enable();
    			}else if(Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.conveyorMotor.set(0);
    				
    			}
    		}else if(Robot.oi.joystick4.getRawButton(9)){
    			if(!Robot.conveyorSubsystem.getPIDController().isEnable() && !Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.setSetpoint(ConveyorSubsystem.STAGE_1);
    				Robot.conveyorSubsystem.enable();
    			}else if(Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.conveyorMotor.set(0);
    			}
    		}else if(Robot.oi.joystick4.getRawButton(7)){
    			if(!Robot.conveyorSubsystem.getPIDController().isEnable() && !Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.setSetpoint(ConveyorSubsystem.STAGE_2);
    				Robot.conveyorSubsystem.enable();
    			}else if(Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.conveyorMotor.set(0);
    			}
    		}else if(Robot.oi.joystick4.getRawButton(8)){
    			if(!Robot.conveyorSubsystem.getPIDController().isEnable() && !Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.setSetpoint(ConveyorSubsystem.STAGE_3);
    				Robot.conveyorSubsystem.enable();
    			}else if(Robot.conveyorSubsystem.onTarget()){
    				Robot.conveyorSubsystem.conveyorMotor.set(0);
    			}
    		}else{
    			if(Robot.conveyorSubsystem.getPIDController().isEnable()){
    				Robot.conveyorSubsystem.disable();
    			}
    			Robot.conveyorSubsystem.conveyorMotor.set(Robot.oi.joystick4.getY());
    		}
    		SmartDashboard.putNumber("Conveyor Encoder Value", Robot.conveyorSubsystem.conveyorEncoder.getDistance());
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
