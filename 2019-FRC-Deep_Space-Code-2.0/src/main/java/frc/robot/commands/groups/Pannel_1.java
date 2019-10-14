/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.*;

public class Pannel_1 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Pannel_1() {
    addSequential(new RightSideCargo());
    addSequential(new TimedDrive(.9, -.9, .5));
    addSequential(new Drive2Pannel());
    addSequential(new TakeHatch());
  }
}
