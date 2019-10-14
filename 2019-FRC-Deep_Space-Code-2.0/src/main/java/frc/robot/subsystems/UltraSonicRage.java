/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Ultrasonic;
/**
 * The bare bones of a sonic range finder subsystem
 * can call the distance in inches
 * I dont know if this will activate when the robot is active 
 * or how it will shut down or not 
 */
public class UltraSonicRage extends Subsystem {
 // Ultrasonic ultra = new Ultrasonic(1, 1);
  
/** 
  public void getdistance(){
    double range = ultra.getRangeInches();
  }

  //use this to call the distance 
  public double distance(){
    return ultra.getRangeInches();
  }
  */
  @Override
  public void initDefaultCommand() {
    //ultra.setAutomaticMode(true);
  }
  
}
