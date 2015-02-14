
package org.usfirst.frc.team5276.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5276.robot.commands.AutonomousCommand;
import org.usfirst.frc.team5276.robot.subsystems.ConveyorSubsystem;
import org.usfirst.frc.team5276.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team5276.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5276.robot.subsystems.OmniDriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
	public static final OmniDriveSubsystem omnidriveSubsystem = new OmniDriveSubsystem();
	public static final ConveyorSubsystem conveyorSubsystem = new ConveyorSubsystem();
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		System.out.println("This is working!");
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomousCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    CameraServer server;
    
    public Robot(){
    	String cam = "cam";
    	
    	server = CameraServer.getInstance();
    	server.setQuality(50);
    	server.startAutomaticCapture(cam);
    }
    
    public void operatorControl(){
    	while (isOperatorControl() && isEnabled()){
    		Timer.delay(0.005);
    	}
    }
    
}
