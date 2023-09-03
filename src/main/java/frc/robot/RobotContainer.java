// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.Auto1;
import frc.robot.commands.ChassisJoysticks;
import frc.robot.commands.Llantas;
import frc.robot.commands.MoveEncoder;
import frc.robot.subsystems.Brazo;
import frc.robot.subsystems.DriveTrainTankFalcon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  //cosas llantas
  private final Intake intake;
  private final Llantas Llantas;
  public static XboxController ControlGarra;

  

// The robot's subsystems and commands are defined here...
  public final DriveTrainTankFalcon drivetrain;
  public final ChassisJoysticks JoyChassis;
public final Auto1 autonomo;

public final Brazo brazo;
public final MoveEncoder moveEncoder;

  public static XboxController Joystick1;
  public static XboxController Joystick2;


  // Replace with CommandPS4Controller or CommandJoystick if needed
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
   drivetrain = new DriveTrainTankFalcon();
   JoyChassis = new ChassisJoysticks(drivetrain);
   JoyChassis.addRequirements(drivetrain);
   drivetrain.setDefaultCommand(JoyChassis);

   brazo = new Brazo();
   moveEncoder = new MoveEncoder(brazo);
   moveEncoder.addRequirements(brazo);
   
   autonomo = new Auto1(drivetrain, 50, 0.4, 0);
   autonomo.addRequirements(drivetrain);


   Joystick1 = new XboxController(Constants.JOYID1);
   Joystick2 = new XboxController(3);


   intake = new Intake();
   Llantas = new Llantas(intake, 0);
   Llantas.addRequirements(intake);



   ControlGarra = new XboxController(Constants.ControlGarraID);


   // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    JoystickButton Sbutton = new JoystickButton(Joystick2, XboxController.Button.kA.value);
    Sbutton.whileTrue(new MoveEncoder(brazo));




    // Garra llantas
    JoystickButton Y = new JoystickButton(ControlGarra, XboxController.Button.kY.value);
    Y.whileTrue(new Llantas(intake, 0.4));

    JoystickButton B = new JoystickButton(ControlGarra, XboxController.Button.kB.value);
    B.whileTrue(new Llantas(intake, -0.2));

    JoystickButton X = new JoystickButton(ControlGarra, XboxController.Button.kX.value);
    X.whileTrue(new Llantas(intake, 0.6));

    JoystickButton A = new JoystickButton(ControlGarra, XboxController.Button.kA.value);
    A.whileTrue(new Llantas(intake, -0.3));

    
    
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autonomo;
  }
  
}
