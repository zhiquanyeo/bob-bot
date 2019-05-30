/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.controllers.XboxController;
import frc.robot.subsystems.Claw;
import frc.robot.commands.SetClawTargetMode;
import frc.robot.commands.SetClawSpinMode;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // Assuming we use an XBOX controller (the logitechs should map similarly)
    // The drive controller should be the very first one listed in the DriverStation
    private XboxController mDriveController = new XboxController(0);

    /**
     * Get requested X-axis movement speed from the controller
     * Based on a Constants value, we may negate this to ensure
     * it gives a positive value when we want to go forward
     * @return requested speed
     */
    public double getDriveSpeed() {
        // left stick, Y axis
        return (Constants.LogitechController.kInvertMoveSpeed ? -1 : 1) * mDriveController.getLeftStickY(); 
    }

    /**
     * Get requested Z-axis rotation speed from the controller
     * @return requested rotation speed
     */ 
    public double getTurnSpeed() {
        // right stick, x axis
        return mDriveController.getRightStickX();
    }

    /**
     * Get quick turn state from the controller
     * @return true if we are in quick turn more
     */
    public boolean getQuickTurn() {
        // Left Shoulder button
        return mDriveController.leftBumper.get();
    }

    public OI() {
        this.mDriveController.buttonX.whenPressed(new SetClawTargetMode(Claw.TargetMode.CARGO));
        this.mDriveController.buttonB.whenPressed(new SetClawTargetMode(Claw.TargetMode.HATCH));
        this.mDriveController.buttonA.whileHeld(new SetClawSpinMode(Claw.SpinMode.INTAKE));
        this.mDriveController.buttonY.whileHeld(new SetClawSpinMode(Claw.SpinMode.EXHAUST));
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
