/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ExtendDonger;
import frc.robot.commands.RetractDonger;
import frc.robot.commands.RaiseRamp;
import frc.robot.commands.LowerRamp;
import frc.robot.commands.RaiseGate;
import frc.robot.commands.LowerGate;
import frc.robot.commands.ToggleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //Joystick pad;

  //pad = new Joystick(0);
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  public Joystick pad = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);

  double throttle = pad.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS); // Left JoyStick Vert.
  double turn = pad.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);     // Right JoyStick Horiz.

  //-----------old button values for reference--------------
  // boolean swapButton = pad.getRawButton(4); // Triangle / Y
  // boolean dongerPistonButton = pad.getRawButton(3); // Opens or Closes Dong Arms  : Square / X
  // boolean rampButton = pad.getRawButton(8); // Options ? / Start
  // boolean stopButton = pad.getRawButton(7); // Share ? / Back
  // boolean dongerDeployedButton = pad.getRawButton(6); // Deploys or Retracts dong   : R1 / RB
  // boolean gateButton = pad.getRawButton(5); // L1 / LB
  // boolean climbButton = pad.getRawButton(1); // X / A
  // double fullYeet = pad.getRawAxis(2);
  // double forceGate = pad.getRawAxis(3);
  // double time = System.currentTimeMillis();

  Button D1 = new JoystickButton(pad, 1);
	Button D2 = new JoystickButton(pad, 2);
	Button D3 = new JoystickButton(pad, 3);
	Button D4 = new JoystickButton(pad, 4);
	Button D5 = new JoystickButton(pad, 5);
	Button D6 = new JoystickButton(pad, 6);
	Button D7 = new JoystickButton(pad, 7);
	Button D8 = new JoystickButton(pad, 8);
	Button D9 = new JoystickButton(pad, 9);


  public OI() {
    //boolean isOpen = false;
    D6.whenPressed(new ToggleCommand(new ExtendDonger(0.2), new RetractDonger(0.2)));
    D8.whenPressed(new ToggleCommand(new RaiseRamp(), new LowerRamp()));
    D5.whenPressed(new ToggleCommand(new RaiseGate(0.15), new LowerGate(0.15)));
  }
}
