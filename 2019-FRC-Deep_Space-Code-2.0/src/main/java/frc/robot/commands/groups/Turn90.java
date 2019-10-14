/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.TimedDrive;

public class Turn90 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Turn90() {
    addSequential(new TimedDrive(.5, -.5, 2.9));
  }
}
