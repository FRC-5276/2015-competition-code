package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ConveyorSubsystem extends PIDSubsystem {
	
	public Encoder conveyorEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public Talon conveyorMotor = new Talon(RobotMap.conveyorMotor);
	//public DigitalInput upSwitch = new DigitalInput(RobotMap.upSwitchPort);
	//public DigitalInput downSwitch = new DigitalInput(RobotMap.downSwitchPort);
	public static final double SPROCKET_DIAMETER = 5; //inches
	public static final double SPROCKET_CIRCUMFERENCE = SPROCKET_DIAMETER * Math.PI;
	public static final double GEAR_RATIO = 1/40; // output/input
	
	public static final double STAGE_DISTANCE = 12.0;
	
	
	public int lastStage = 0;

    // Initialize your subsystem here
    public ConveyorSubsystem() {
    	super(0.1, 0.0, 0.1);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	setOutputRange(-0.5, 0.5);
    	//enable();
    	//conveyorOutput.enable();    	conveyorEncoder.setDistancePerPulse(SPROCKET_CIRCUMFERENCE/360);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return conveyorEncoder.getDistance();
    }
    
    public void moveToStage(int stageNumber){
    	if(stageNumber > 3 || stageNumber < 0){
    		return;
    	}
    	setSetpoint(STAGE_DISTANCE*stageNumber);
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
//    	if(upSwitch.get() && output > 0){
//    		output = 0;
//    	}else if(downSwitch.get() && output < 0){
//    		output = 0;
//    	}
    	conveyorMotor.set(output);
    }
}
