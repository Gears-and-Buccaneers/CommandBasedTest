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
import frc.robot.commands.RotateDonger;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Add your docs here.
 */
public class Donger extends Subsystem {

  public boolean isOut = false;
  // Talons
  WPI_TalonSRX rotateTalonSRX = null;
  //Solenoids
  DoubleSolenoid dongerSolenoid = null;
  
  public Donger() {
    rotateTalonSRX = new WPI_TalonSRX(RobotMap.DONGER_ROTATETALON);
    dongerSolenoid = new DoubleSolenoid(RobotMap.DONGER_SOLENOID_DEPLOY,RobotMap.DONGER_SOLENOID_RETRACT);
  }

  public void dongExtend() {
		rotateTalonSRX.set(ControlMode.PercentOutput, -1);
	}
  public void dongRetract() {
		rotateTalonSRX.set(ControlMode.PercentOutput, 1);
  }
  public void dongOpen() {
    dongerSolenoid.set(Value.kForward);
  }
  public void dongClose() {
    dongerSolenoid.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new RotateDonger());
  }
}
