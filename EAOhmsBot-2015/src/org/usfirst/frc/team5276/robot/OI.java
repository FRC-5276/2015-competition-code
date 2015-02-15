package org.usfirst.frc.team5276.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5276.robot.commands.AutonomousCommand;
import org.usfirst.frc.team5276.robot.commands.UpStageCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    public Joystick joystick1 = new Joystick(0);
    // Button button = new JoystickButton(stick, buttonNumber);
    public Joystick joystick2 = new Joystick(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public Button upButton = new JoystickButton(joystick2, 1);
    public Button downButton = new JoystickButton(joystick2, 2);
    
    public OI(){
    	upButton.whenPressed(new UpStageCommand());
    }
    
    
    //GYRO
    public Gyro gyro = new Gyro(1);
    //ENCODER
    public Encoder enc0 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    public Encoder enc1 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    public Encoder enc2 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    
}

