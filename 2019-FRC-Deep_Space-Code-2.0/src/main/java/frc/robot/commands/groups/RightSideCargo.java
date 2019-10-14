/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;
public class RightSideCargo extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RightSideCargo() {
    addSequential(new TimedDrive(.7, .7, 0.7));
    addSequential(new TimedDrive(0.7, 0, 2.63));
    addSequential(new TimedDrive(.5, -.5, 0.7));
  }
}
