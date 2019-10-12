/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

  // Talons
	WPI_TalonSRX leftFrontTalon = null;
	WPI_TalonSRX leftBackTalon = null;
	WPI_TalonSRX rightFrontTalon = null;
	WPI_TalonSRX rightBackTalon = null;

	DifferentialDrive differentialDrive = null;

	public DriveBase() {
		// Talons
		leftFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);
		SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);

		differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

	}

	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveArcade());
	}
}