package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.Robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ConveyorSubsystemOld extends Subsystem {
	
	public static final double SPROCKET_DIAMETER = 5; //inches
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Talon conveyorMotor = new Talon(5);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new ConveyorBeltCommand());
    }
    
    public void setConveyorMotor(double value){
    	conveyorMotor.set(value);
    }
    
    public void setConveyorStageUp() {
    	conveyorMotor.set(1);
    }
    
    public void setConveyorStageDown() {
    	conveyorMotor.set(-1);
    }
    
    public void stopMotor() {
    	conveyorMotor.set(0);
    }
}

