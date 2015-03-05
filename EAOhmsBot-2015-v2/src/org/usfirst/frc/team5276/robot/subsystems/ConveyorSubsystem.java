package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ConveyorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Talon   conveyorMotor   = new Talon(RobotMap.conveyorMotor);
	public Encoder conveyorEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	public PIDController distancePIDController;
	public PIDController speedPIDController;
	
	public PIDSource distancePIDSource = new PIDSource() {
		
		@Override
		public double pidGet() {
			// TODO Auto-generated method stub
			return conveyorEncoder.getDistance();
		}
	};
	public PIDSource speedPIDSource = new PIDSource() {
		
		@Override
		public double pidGet() {
			// TODO Auto-generated method stub
			return conveyorEncoder.getRate();
		}
	};
	
	public PIDOutput motorPIDOutput = new PIDOutput() {
		
		@Override
		public void pidWrite(double output) {
			// TODO Auto-generated method stub
			conveyorMotor.set(output);
		}
	};
	
	public ConveyorSubsystem(){
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    
    
}

