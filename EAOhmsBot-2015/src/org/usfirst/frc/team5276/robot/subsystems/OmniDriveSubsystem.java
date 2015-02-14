package org.usfirst.frc.team5276.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 *theta = joystick.getAngleRadians;
z = joystick.zAxis;
r = sqrt((joystick.xAxis)^2 + (joystick.yAxis)^2);
k = ((joystick.getSliderAxis)/2) + 0.5;
change_theta = gyroSensor.getAngleRadians;
theta = theta - change_theta;
while (theta < 0) {
	theta = theta + 2π;
}
while (theta > 360) {
	theta = theta - 2π;
}
a = r * cos(theta);
b = r * sin(theta);
A = a + z;
B = b + z;
C = a - z;
D = b - z;
max = 1;
if (A > max) {
	max = A;
}
if (B > max) {
	max = B;
}
if (C > max) {
	max = C;
}
if (D > max) {
	max = D;
}
A/=max;
B/=max;
C/=max;
D/=max;
A*=k;
B*=k;
C*=k;
D*=k;
 */
public class OmniDriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    Talon A = new Talon(0);
    Talon B = new Talon(1);
    Talon C = new Talon(2);
    Talon D = new Talon(3);
    
    public void OmniDrive(double theta, double z, double k, double change_theta, double r) {
    	k = (k/2) + 0.5;	// This changes the range of k from [-1, 1] to [-0.5, 0.5] to [0,1]
    	theta-=change_theta;	// This sets theta equal to theta - change_theta, so the gyro value is subtracted
    	double doubpi = 2*Math.PI; // This is just set so 2*Math.PI doesn't have to be written over and over again
    	while (theta < 0) {
    		theta+=doubpi;
    	}
    	while (theta > doubpi) {
    		theta-=doubpi;
    	}
    	// This all just makes sure that theta is in the range [0, 2pi]
    	double a = r * Math.cos(theta);
    	// This calculates the x-coordinate (a) of the vector used; r is multiplied so the original magnitude is used
    	double b = r * Math.sin(theta);
    	// This calculates the y-coordinate (b) of the vector used; r is multiplied so the original magnitude is used
    	double A = a + z;	// Wheel A is equal to the a value + the z value
    	double B = b + z;	// Wheel B is equal to the b value + the z value
    	double C = a - z;	// Wheel C is equal to the a value - the z value
    	double D = b - z;	// Wheel D is equal to the b value - the z value
    	double max = 1;
    	if (A > max) {
    		max = A;
    	}
    	if (B > max) {
    		max = B;
    	}
    	if (C > max) {
    		max = C;
    	}
    	if (D > max) {
    		max = D;
    	}
    	// This all just calculates the maximum value of A, B, C, and D, so that if it is greater than 1, it is scaled down
    	A/=max;
    	B/=max;
    	C/=max;
    	D/=max;
    	// This divides all of the wheel speeds by the scaling factor
    	A*=k;
    	B*=k;
    	C*=k;
    	D*=k;
    	// This multiplies all of the wheel speeds by the constant on which the slider value is set on the joystick
    }
    
}

