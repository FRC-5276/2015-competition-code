package org.usfirst.frc.team5276.robot.subsystems;

import org.usfirst.frc.team5276.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
    RobotDrive intakeDrive = new RobotDrive(RobotMap.intakeMotorLeft, RobotMap.intakeMotorRight);
    
    public IntakeSubsystem() {
    	intakeDrive.setInvertedMotor(MotorType.kFrontLeft, true);
    }
    
    public void setIntake(double linear, double rotation){
    	intakeDrive.arcadeDrive(linear, rotation);
    }

    public void setIntake(double linear) {
    	setIntake(linear, 0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new IntakeSystemCommand());
    }

}

