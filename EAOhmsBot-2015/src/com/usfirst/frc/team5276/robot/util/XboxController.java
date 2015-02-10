package com.usfirst.frc.team5276.robot.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Miller
 */
public class XboxController extends Joystick {

    public XboxController(int port) {
        super(port);
    }
    
    public double getLeftXAxis(){
        return getRawAxis(1);
    }
    public double getLeftYAxis(){
        return getRawAxis(2);
    }
    public double  getTriggerAxis(){
        return getRawAxis(3);
    }
    
    public double getRightXAxis(){
        return getRawAxis(4);
    }
    
    public double getRightYAxis(){
        return getRawAxis(5);
    }
    
    public double getDirectionalPad(){
        return getRawAxis(6);
    }
    
}

