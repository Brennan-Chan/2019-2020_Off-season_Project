/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestingTimedDrive extends CommandGroup {
  /*
  Additionally drives towards the target in addition to adjusting towards the target
  */
  public TestingTimedDrive(){
    addSequential(new TimedDrive(0.7, 0.7, 3));
    addSequential(new TimedDrive(-.5, .5, 2.9));
    addSequential(new TimedDrive(.5, .5, 2));
    addSequential(new TimedDrive(.5, -.5, 2.9));
    addSequential(new TimedDrive(.7, .7, 1));
    addSequential(new TimedDrive(-.5, .5, 2.9));

    addParallel(new LimeDrive());
    addParallel(new TimedDrive(0.7, .7, 3));
  }
}
