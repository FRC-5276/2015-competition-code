package org.usfirst.frc.team5276.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ConveyorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Talon conveyorMotor = new Talon(5);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setConveyorMotor(double value){
    	conveyorMotor.set(value);
    }
    
    public void setConveyorStage(int stage) {
    	
    }
}

