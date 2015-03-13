package org.usfirst.frc.team5276.robot.subsystems;



import org.usfirst.frc.team5276.robot.RobotMap;
import org.usfirst.frc.team5276.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//public Encoder leftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
	//public Encoder rightEncoder = new Encoder(4, 5, false, EncodingType.k4X);
	public Talon leftMotor = new Talon(RobotMap.leftMotor);
	public Talon rightMotor = new Talon(RobotMap.rightMotor);
	//public PIDController leftDriveControl = new PIDController(0.0, 0.0, 0.0, leftEncoder, leftMotor);
	//public PIDController rightDriveControl = new PIDController(0.0, 0.0, 0.0, rightEncoder, rightMotor);
	
	public RobotDrive drive = new RobotDrive(leftMotor, rightMotor);
	
	public DrivetrainSubsystem(){
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new TankDriveCommand());
    }
    
    public void arcadeDrive(double linear, double rotation){
    	drive.arcadeDrive(linear, rotation);
    }
   
    public void tankDrive(double leftPower, double rightPower){
    	drive.tankDrive(leftPower, rightPower);
    }
    
    public void tankDrive(Joystick left, Joystick right){
    	drive.tankDrive(left, right);
    }


}

