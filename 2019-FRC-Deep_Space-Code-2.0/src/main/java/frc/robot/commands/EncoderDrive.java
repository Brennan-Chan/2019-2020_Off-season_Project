/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class EncoderDrive extends Command {
  

  public EncoderDrive() {
    requires(Robot.dd);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.dd.frontLeft.configClearPositionOnQuadIdx(true, 4000000);

    while(Robot.dd.frontLeft.getSelectedSensorPosition() <= 39){
      Robot.dd.ArcadeDrive(OI.driver.getRawAxis(1), -.4);
      System.out.println("Sensor Distance LEFT:" + Robot.dd.frontLeft.getSelectedSensorPosition());
        Timer.delay(0.004);
    }




  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
   if(Robot.dd.frontLeft.getSelectedSensorPosition() == 39){
     return true;
   }
   else{
    return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.dd.ArcadeDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
