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

	
	public static final double KP = 0.005;
	public static final double KI = 0.0001;
	public static final double KD = 0.0005;
	
	public static final double STAGE_0 = 0;
	public static final double STAGE_1 = 313.75;
	public static final double STAGE_2 = 605.5;
	public static final double STAGE_3 = 895.75;
	
	public static final double MIN_LIMIT = STAGE_0;
	public static final double MAX_LIMIT = 900.0;
	//public DigitalInput upSwitch = new DigitalInput(RobotMap.upSwitchPort);
	//public DigitalInput downSwitch = new DigitalInput(RobotMap.downSwitchPort);
	public static final double SPROCKET_DIAMETER = 6; //inches
	public static final double SPROCKET_CIRCUMFERENCE = SPROCKET_DIAMETER * Math.PI;
	public static final double GEAR_RATIO = 1/40; // output/input
	public static final double UPR = 360; //Encoder Units Per Revolution
	public static final double DPP = SPROCKET_CIRCUMFERENCE/UPR; //Distance Per Pulse
	
	
	public int lastStage = 0;

    // Initialize your subsystem here
    public ConveyorSubsystem() {
    	super(KP, KI, KD);
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
    
    public void setPower(double power){
    	if((conveyorEncoder.getDistance() <= MIN_LIMIT && power < 0) || (conveyorEncoder.getDistance() >= MAX_LIMIT && power > 0)){ //TODO test power directions
    		power = 0;
    	}
    	conveyorMotor.set(power);
    }
    
    @Override
    public void enable(){
    	if(getPIDController().isEnable()){
    		super.enable();
    	}
    }
    
    @Override
    public void disable(){
    	if(!getPIDController().isEnable()){
    		super.disable();
    	}
    }
}

