/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final byte Port_PanelMotor = 5;
    private static VictorSPX PanelMotor;
    private static XboxController Stick;
    //Panel 氣壓的東西
    private static Solenoid left,right;
    private static boolean on = false;
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    System.out.println("Panel Initialzied");
    PanelMotor = new VictorSPX(Port_PanelMotor);
    PanelMotor.setInverted(false);
    PanelMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putBoolean("Panel initialized", true);

        if(Stick.getBumper(Hand.kLeft)){
            PanelMotor.set(ControlMode.PercentOutput, 0.5);
        }
        else if (Stick.getBumper(Hand.kRight)) {
            PanelMotor.set(ControlMode.PercentOutput, -0.5);
        }
        else {
            PanelMotor.set(ControlMode.PercentOutput, 0);
        }
    
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
