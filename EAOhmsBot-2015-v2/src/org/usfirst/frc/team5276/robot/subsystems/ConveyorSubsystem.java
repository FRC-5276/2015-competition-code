package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 */
public class ConveyorSubsystem extends Subsystem {
	public static final double SPROCKET_DIAMETER = 6; //inches
	public static final double SPROCKET_CIRCUMFERENCE = SPROCKET_DIAMETER * Math.PI;
	public static final double GEAR_RATIO = 1/40; // output/input
	public static final double STAGE_DISTANCE = 12.0;
	public static final double UPR = 360; //Encoder Units Per Revolution
	public static final double DPP = SPROCKET_CIRCUMFERENCE/UPR; //Distance Per Pulse
	
	public static final double DISTANCE_KP = 0.0;
	public static final double DISTANCE_KI = 0.0;
	public static final double DISTANCE_KD = 0.0;
	public static final double SPEED_KP = 0.0;
	public static final double SPEED_KI = 0.0;
	public static final double SPEED_KD = 0.0;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Talon   conveyorMotor   = new Talon(RobotMap.conveyorMotor);
	public Encoder conveyorEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	

	
	private PIDSource distancePIDSource = new PIDSource() {
		@Override
		public double pidGet() {
			// TODO Auto-generated method stub
			return conveyorEncoder.getDistance();
		}
	};
	private PIDSource speedPIDSource = new PIDSource() {
		@Override
		public double pidGet() {
			// TODO Auto-generated method stub
			return conveyorEncoder.getRate();
		}
	};
	
	private PIDOutput speedPIDOutput = new PIDOutput() {
		@Override
		public void pidWrite(double output) {
			// TODO Auto-generated method stub
			conveyorMotor.set(output);
		}
	};
	
	private PIDOutput distancePIDOutput = new PIDOutput() {
		@Override
		public void pidWrite(double output) {
			if(speedPIDController.isEnable()){
				speedPIDController.setSetpoint(output);
			}else{
				conveyorMotor.set(output);
			}
			
		}
	};
	public PIDController distancePIDController = new PIDController(
			DISTANCE_KP, 
			DISTANCE_KI,
			DISTANCE_KD, 
			distancePIDSource, 
			distancePIDOutput);
	public PIDController speedPIDController = new PIDController(
			SPEED_KP, 
			SPEED_KI, 
			SPEED_KD, 
			speedPIDSource, 
			speedPIDOutput);
	
	public ConveyorSubsystem(){
		conveyorEncoder.setDistancePerPulse(DPP);
		distancePIDController.setPercentTolerance(20.0);
	}
	
	/**
	 * sets the speed range to use when distance is enabled and using the speed controller
	 * @param speed
	 */
	public void setSpeedRange(double speed){
		distancePIDController.setOutputRange(-speed, speed);
	}
	
	public void setPower(double power){
		conveyorMotor.set(power);
	}
	
	public void setSpeedTarget(double inchesPerSecond){
		speedPIDController.setSetpoint(inchesPerSecond);
	}
	
	public void setDistanceTarget(double inches){
		distancePIDController.setSetpoint(inches);
	}
	
	public void enableSpeedControl(){
		speedPIDController.enable();
	}
	
	public void disableSpeedControl(){
		speedPIDController.disable();
	}
	
	public void enableDistanceControl(){
		distancePIDController.enable();
	}
	
	public void disableDistanceControl(){
		distancePIDController.disable();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public String getSmartDashboardType() {
        return "PIDSubsystem";
    }
    public void initTable(ITable table) {
        speedPIDController.initTable(table);
        super.initTable(table);
    }
    
}

