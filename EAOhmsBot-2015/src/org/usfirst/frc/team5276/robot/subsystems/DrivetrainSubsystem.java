package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.Robot;
import org.usfirst.frc.team5276.robot.RobotMap;
import org.usfirst.frc.team5276.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X); 
	public Encoder rightEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
	//TODO change one of the encoders invert motor value to true
	public static final double DriveMotorRatio = 0.05;	// input:output
	public static final double WheelRadius = 2;	// in inches
	public static final double DistanceBetweenDriveMotors = 2;	// in inches
	
	public RobotDrive yDrive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDriveCommand());
    }
    
    public void arcadeDrive(double linear, double rotation){
    	yDrive.arcadeDrive(linear, rotation);
    }
   
    public void tankDrive(double leftPower, double rightPower){
    	yDrive.tankDrive(leftPower, rightPower);
    }
    
    public void moveDistance(double distance, double speed) {
    	double currentLeftEncoderValue = leftEncoder.getDistance();
    	double currentRightEncoderValue = rightEncoder.getDistance();
    	leftEncoder.setDistancePerPulse(2*Math.PI*WheelRadius); //	TODO get DistancePerPulse for motors
    	rightEncoder.setDistancePerPulse(2*Math.PI*WheelRadius);
    	double desiredLeftEncoderValue = currentLeftEncoderValue + distance;
    	double desiredRightEncoderValue = currentRightEncoderValue + distance;
    	while (leftEncoder.getDistance() != desiredLeftEncoderValue && rightEncoder.getDistance() != desiredRightEncoderValue) {
    		yDrive.drive(speed, 0);
    	}
    }
    
    public void rotateRobot(double rotationInDegrees) {
    	int curveValue = 0;
    	if (rotationInDegrees < 0) {
    		curveValue = -1;
    	}
    	else if (rotationInDegrees > 0) {
    		curveValue = 1;
    	}
    	double currentLeftEncoderValue = leftEncoder.getDistance();
    	double currentRightEncoderValue = rightEncoder.getDistance();
    	leftEncoder.setDistancePerPulse(2*Math.PI*WheelRadius); //	TODO get DistancePerPulse for motors
    	rightEncoder.setDistancePerPulse(2*Math.PI*WheelRadius);
    	double distance = Math.PI*DistanceBetweenDriveMotors*rotationInDegrees/180;
    	double desiredLeftEncoderValue = currentLeftEncoderValue - distance;
    	double desiredRightEncoderValue = currentRightEncoderValue + distance;
    	while (leftEncoder.getDistance() != desiredLeftEncoderValue && rightEncoder.getDistance() != desiredRightEncoderValue) {
    		yDrive.drive(0, curveValue);
    	}
    }

}

