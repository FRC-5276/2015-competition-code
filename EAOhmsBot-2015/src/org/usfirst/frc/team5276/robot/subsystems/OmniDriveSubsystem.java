package org.usfirst.frc.team5276.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.Math.*;
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
    
//    Talon A = new Talon(0);
//    Talon B = new Talon(1);
//    Talon C = new Talon(2);
//    Talon D = new Talon(3);
    public void OmniDrive(double x, double y, double z, double k, double change_theta) {
    	double theta = Math.atan2(x, y);
    	double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    	k = (k/2) + 0.5;
    	theta-=change_theta;
    	while (theta < 0) {
    		
    	}
    }
    
}

