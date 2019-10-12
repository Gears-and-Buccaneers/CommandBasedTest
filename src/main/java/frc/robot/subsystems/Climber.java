/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Controls the level 2 climbing mechanism.
 */
public class Climber extends Subsystem {
  //Solenoids
  DoubleSolenoid climbSolenoid = null;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Climber() {
    climbSolenoid = new DoubleSolenoid(RobotMap.CLIMBER_SOLENOID_DEPLOY, RobotMap.CLIMBER_SOLENOID_RETRACT);
  }

  public void deploy() {
    climbSolenoid.set(Value.kForward);
  }
  public void retract() {
    climbSolenoid.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
