
package org.usfirst.frc.team5276.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5276.robot.commands.SampleAutonomous;
import org.usfirst.frc.team5276.robot.commands.PickUpCratesAutonomous;
import org.usfirst.frc.team5276.robot.subsystems.ConveyorSubsystem;
import org.usfirst.frc.team5276.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team5276.robot.subsystems.IntakeSubsystem;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
	public static ConveyorSubsystem conveyorSubsystem = new ConveyorSubsystem();
	public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		System.out.println("This is working!");
        // instantiate the command used for the autonomous period
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Autonomous Option 1", new SampleAutonomous());
        autoChooser.addObject("Autonomous Option 2", new PickUpCratesAutonomous());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
    	autonomousCommand.start();
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
    
//    CameraServer server;
    
    public Robot(){
//    	try{
//    		String cam = "cam0";
//        	
//        	server = CameraServer.getInstance();
//        	server.setQuality(50);
//        	server.startAutomaticCapture(cam);
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
    	
    }
    
    public void operatorControl(){
    	while (isOperatorControl() && isEnabled()){
    		Timer.delay(0.005);
    	}
    }
    
}
