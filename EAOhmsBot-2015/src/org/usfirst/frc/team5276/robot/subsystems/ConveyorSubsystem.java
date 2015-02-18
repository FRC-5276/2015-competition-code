package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ConveyorSubsystem extends PIDSubsystem {
	
	public Encoder conveyorEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public Talon conveyorMotor = new Talon(RobotMap.conveyorMotor);
	public static final double SPROCKET_DIAMETER = 5; //inches
	public static final double SPROCKET_CIRCUMFERENCE = SPROCKET_DIAMETER * Math.PI;
	public static final double GEAR_RATIO = 1/40; // output/input

    // Initialize your subsystem here
    public ConveyorSubsystem() {
    	super(1.0, 0.0, 0.0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	setOutputRange(-1, 1);
    	enable();
    	conveyorEncoder.setDistancePerPulse(SPROCKET_CIRCUMFERENCE/360);
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
    	conveyorMotor.set(output);
    }
}
