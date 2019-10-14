/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
//import frc.robot.RobotMap;
import frc.robot.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Drive2Pannel extends CommandGroup {
  /**
   * drives to the target 
   * or 
   * searches for the target 
   */
  public Drive2Pannel() {
   
    if(Robot.lm.validTarget()){
      addParallel(new LimeDrive());
      addParallel(new TimedDrive(0.6, 0, 1.4));
      addSequential(new WaitCommand(1));
      System.out.println("Driving to the target");
    }
    else if(!Robot.lm.validTarget()){
      addParallel(new LimeLightSeek(), 4);
      addParallel(new WaitCommand(1));
      addSequential(new WaitCommand(1));
      System.out.println( "searching 4 target" + Robot.lm.horizontalOffset);
    }
    while(Robot.lm.validTarget()){
        addSequential(new LimeLightSeek(),4);
        addParallel(new LimeDrive());
        addParallel(new WaitCommand(3));
        System.out.println(Robot.lm.distanceToTarget());
    }
      
      //addSequential(new TimedDrive(0.5, 0, 1.4));
    
    }
  }
