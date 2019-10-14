/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

import frc.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.*;


public class DriveTrain extends Subsystem {
  //Declare TalonSRX motors
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.leftMaster);
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.rightMaster);
  public WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.leftSlave);
  public WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotMap.rightSlave);
  public WPI_TalonSRX middleLeft = new WPI_TalonSRX(RobotMap.leftDonkey);
  public WPI_TalonSRX middleRight = new WPI_TalonSRX(RobotMap.rightDonkey);
  public Faults fault= new Faults();


  
  /*Initialize Viktor controllers
  public WPI_VictorSPX frontLeft = new WPI_VictorSPX(RobotMap.leftMaster);
  public WPI_VictorSPX frontRight = new WPI_VictorSPX(RobotMap.rightMaster);
  public WPI_VictorSPX rearLeft = new WPI_VictorSPX(RobotMap.leftSlave);
  public WPI_VictorSPX rearRight = new WPI_VictorSPX(RobotMap.rightSlave);
  public WPI_VictorSPX middleRight = new WPI_VictorSPX(RobotMap.rightDonkey);
  public WPI_VictorSPX middleLeft = new WPI_VictorSPX(RobotMap.leftDonkey);
  */

  
  public DifferentialDrive dd = new DifferentialDrive(frontLeft, frontRight);

  final int kTimeoutMs = 30;

  public DriveTrain(){
    //Sets rear motors to follow rotation of the primary motors
    //frontRight.setInverted(false);
    //frontRight = new EncoderFollower(leftTrajectory);
    dd.setSafetyEnabled(false);
    frontLeft.setSensorPhase(false);
    rearLeft.follow(frontLeft);
    rearRight.follow(frontRight);
    middleLeft.follow(frontLeft);
    middleRight.follow(frontRight);

    //360 degree positon of MagEncoder's abosolute position
    /** 
     * velocity code that theoretically works but is outdated
     * and needs API updates 
    frontLeft.configSelectedFeedbackSensor(
      FeedbackDevice.CTRE_MagEncoder_Relative,0,kTimeoutMs);
    frontLeft.configNominalOutputForward(+0.0);
    frontLeft.configNominalOutputReverse(-0.0);
    frontLeft.configPeakOutputForward(+12.0);
    frontLeft.configPeakOutputReverse(-12.0);
    */

    //Configure encoders for master motors
    /*
    frontLeft.configSelectedFeedbackSensor(
      FeedbackDevice.CTRE_MagEncoder_Relative,0,kTimeoutMs);
    frontRight.configSelectedFeedbackSensor(
      FeedbackDevice.CTRE_MagEncoder_Relative,0,kTimeoutMs);
      */
  }

  public void ArcadeDrive (double x, double rotation){
    //Motion in the -x direction is actually forward
    dd.arcadeDrive(-x, rotation);
    frontLeft.getFaults(fault);

    
      System.out.println("Sensor Vel:" + frontLeft.getSelectedSensorVelocity());
      System.out.println("Sensor Pos:" + frontLeft.getSelectedSensorPosition());
      System.out.println("Out %" + frontLeft.getMotorOutputPercent());
      //System.out.println("Out Of Phase:" + frontLeft.SensorOutOfPhase);
    

    /**
     * comment this out if the code doesnt work 
     * this sould print the distance the motor travled 
     * I just followed the guide online 
    */
    //double X = OI.driver.getRawAxis(0);
    
    //System.out.println("Sensor Distance RIGHT:" + frontRight.getSelectedSensorPosition());
    //System.out.println("Sensor Distance LEFT:" + frontLeft.getSelectedSensorPosition());

  }

  @Override
  public void initDefaultCommand(){
    setDefaultCommand(new Drive());
  }
}
