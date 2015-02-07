package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.commands.ArcadeDriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public RobotDrive yDrive = new RobotDrive(1, 2);
	public Talon frontXDrive = new Talon(3);
	public Talon backXDrive = new Talon(4);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArcadeDriveCommand());
    }
    
    public void arcadeDrive(double linear, double rotation){
    	yDrive.arcadeDrive(linear, rotation);
    }
    
    public void setXDrive(double speed){
    	//TODO define X drive method
    }
    
    
    
}

