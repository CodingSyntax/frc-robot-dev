/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ColorDetection;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive wheelsMotor1;
  private DifferentialDrive wheelsMotor2;
  
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  @Override
  public void robotInit() {
    wheelsMotor1 = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(2));
    wheelsMotor2 = new DifferentialDrive(new PWMVictorSPX(1), new PWMVictorSPX(3));
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
   
  }

  //An automatic update method.
  @Override
  public void teleopPeriodic() 
  {
    //Driving with controllers
    wheelsMotor2.tankDrive(-m_leftStick.getY(), -(m_rightStick.getY()*.951));
    wheelsMotor1.tankDrive(-m_leftStick.getY(), -(m_rightStick.getY()*.951));


  }
}
