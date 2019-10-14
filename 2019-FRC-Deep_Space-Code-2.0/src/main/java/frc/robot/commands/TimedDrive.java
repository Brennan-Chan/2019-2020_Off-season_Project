package frc.robot.commands;

import frc.robot.Robot;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command autonomously drives the robot forward at a fixed level of power for a given amount of time
 */
public class TimedDrive extends Command {

    private double x, y;
    protected double time;
    protected double power;
    protected long endTime;

    public TimedDrive(double x, double y, double duration) {
        requires(Robot.dd);
        this.x = x;
        this.y = y;
        this.time = duration;
        this.setTimeout(duration);
    }

    protected void initialize(){
        
    }

    protected void execute(){
        Robot.dd.ArcadeDrive(-x, y);
        Timer.delay(0.005);
    }


    protected boolean isFinished(){
        if (this.isTimedOut()){
            return true;
        } 
        
        else{
            return false;
        }
        
    }

    // Called once after isFinished returns true
    protected void end(){
        Robot.dd.ArcadeDrive(0, 0);
    }
}