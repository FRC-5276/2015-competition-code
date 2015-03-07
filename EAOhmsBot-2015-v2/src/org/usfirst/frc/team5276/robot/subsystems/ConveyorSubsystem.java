package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;



/**
 *
 */
public class ConveyorSubsystem extends PIDSubsystem {
	
	public Encoder conveyorEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public Talon conveyorMotor = new Talon(RobotMap.conveyorMotor);

	
	public static final double DISTANCE_KP = 0.01;
	public static final double DISTANCE_KI = 0.0;
	public static final double DISTANCE_KD = 0.1;
	public static final double SPEED_KP = 0.01;
	public static final double SPEED_KI = 0.0;
	public static final double SPEED_KD = 0.0;
	
	public static final double STAGE_0 = 0;
	public static final double STAGE_1 = 313.75;
	public static final double STAGE_2 = 605.5;
	public static final double STAGE_3 = 895.75;
	//public DigitalInput upSwitch = new DigitalInput(RobotMap.upSwitchPort);
	//public DigitalInput downSwitch = new DigitalInput(RobotMap.downSwitchPort);
	public static final double SPROCKET_DIAMETER = 5; //inches
	public static final double SPROCKET_CIRCUMFERENCE = SPROCKET_DIAMETER * Math.PI;
	public static final double GEAR_RATIO = 1/40; // output/input
	public static final double UPR = 360; //Encoder Units Per Revolution
	public static final double DPP = SPROCKET_CIRCUMFERENCE/UPR; //Distance Per Pulse
	
	public static final double STAGE_DISTANCE = 12.0;
	
	
	public int lastStage = 0;

    // Initialize your subsystem here
    public ConveyorSubsystem() {
    	super(0.005, 0.0001, 0.0005);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	setOutputRange(-0.5, 0.5);
    	//enable();
    	setPercentTolerance(20.0);
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

