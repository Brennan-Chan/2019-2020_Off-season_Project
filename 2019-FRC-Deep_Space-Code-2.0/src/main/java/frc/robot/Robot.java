/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.UsbCamera;


import frc.robot.commands.*;
import frc.robot.commands.groups.*;
import frc.robot.subsystems.*;

/*
  The VM is configured to automatically run this class, and to call the
  functions corresponding to each mode, as described in the TimedRobot
  documentation. If you change the name of this class or the package after
  creating this project, you must also update the build.gradle file in the
  project.
*/
public class Robot extends TimedRobot {
  //Subsystem instancing
  public static Limelight lm = new Limelight();
  public static DriveTrain dd = new DriveTrain();
  public static HatchGrabber hg = new HatchGrabber();
  public static Feeder fd = new Feeder();
  public static Conveyor cv = new Conveyor();
  public static UltraSonicRage us = new UltraSonicRage();

  public static RobotMap rm = new RobotMap();
  public static OI oi;
  
  public static UsbCamera hgCamera = new UsbCamera("Front Camera", 1);
  public static Encoder encoderRight;
  public static Encoder encoderLeft;
 

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  //INIT METHODS
  @Override
  public void robotInit(){
    oi = new OI();
    //TODO: Add drive modes (autonomous) to SmartDashboard here and in autonomousInit()
    m_chooser.setDefaultOption("Teleop Drive", new Drive());
    m_chooser.addOption("Auto Drive", new TakeHatch());
    SmartDashboard.putData("Teleop", m_chooser);

    hgCamera.setFPS(30);
    hgCamera.setResolution(160,120);
    CameraServer.getInstance().startAutomaticCapture();
    //Robot.dd.frontLeft.configClearPositionOnQuadIdx(true, 0);
    //Robot.dd.frontRight.configClearPositionOnQuadIdx(true, 0);
    
  }
  

    public static double tinch = 18.5259719;

  

  @Override
  public void disabledInit(){
    System.out.println("You DIED");
  }

  public static double getLeftEncoderPosition() {
    return (encoderLeft.getDistance());
  }

  public static double getRightEncoderPosition() {
  return (encoderRight.getDistance());
  }

  @Override
  public void teleopInit(){
    //Cancels autonomous mode upon initializing operator control
    if (m_autonomousCommand != null){
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void autonomousInit(){
    m_autonomousCommand = m_chooser.getSelected();
    if (m_autonomousCommand != null){
      m_autonomousCommand.start();
    }
  }

  //PERIODIC FUNCTIONS
  @Override
  public void robotPeriodic(){
    
  }

  @Override
  public void disabledPeriodic(){
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic(){
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic(){
  }
}
