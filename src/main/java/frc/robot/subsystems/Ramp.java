/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


/**
 * The Ramp That Holds the ball/cargo.
 */
public class Ramp extends Subsystem {

  // Talons
  WPI_TalonSRX gateTalonSRX = null;
  //Solenoids
  DoubleSolenoid rampSolenoid = null;
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Ramp() {
    gateTalonSRX = new WPI_TalonSRX(RobotMap.RAMP_TALON);
    rampSolenoid = new DoubleSolenoid(RobotMap.RAMP_SOLENOID_DEPLOY,RobotMap.RAMP_SOLENOID_RETRACT);
  }

  public void rampUp() {
    rampSolenoid.set(Value.kForward);
	}
  public void rampDown() {
    rampSolenoid.set(Value.kReverse);
  }
  public void gateUp() {
    gateTalonSRX.set(ControlMode.PercentOutput, -1);
  }
  public void gateDown() {
    gateTalonSRX.set(ControlMode.PercentOutput, 1);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
