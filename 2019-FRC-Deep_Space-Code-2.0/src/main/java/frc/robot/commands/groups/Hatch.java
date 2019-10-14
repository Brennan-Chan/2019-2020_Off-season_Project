/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import frc.robot.*;
import frc.robot.commands.*;

public class Hatch extends CommandGroup {
  /**
   * Intended effect:
   * When lined up with target(Retro Tape)
   * the robot will drive up to it and then stop at the distance 
   * Needed to place a hatch pannel 
   */
  public Hatch() {
    
    if(Robot.lm.getHorizontalOffset() <= .1 || Robot.lm.getHorizontalOffset() >= -.1){
      while(Robot.lm.validTarget()){
        addParallel(new TimedDrive(.4, 0, 3));
        addParallel(new LimeDrive());
        System.out.println(Robot.lm.distanceToTarget());
      }
      /** 
       * 
       * this was the code for the ultra sonic range finder 
       * but i instanciated it wrong 
       * so it doesnt work 
       * I would like to make it work
       * 
      while(Robot.us.distance() >= .5){
        System.out.println(Robot.us.distance());
        addSequential(new TimedDrive(.4,0,.5));
      }
      */ 
      addSequential(new TimedDrive(.4,0,.5));
    }
    else{
      System.out.print("The Target is not lined up");
    }
  }
}
