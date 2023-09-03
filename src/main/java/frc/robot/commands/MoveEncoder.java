// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Brazo;

public class MoveEncoder extends CommandBase {
  Brazo brazo;
  /** Creates a new MoveEncoder. */
  public MoveEncoder(Brazo b) {
    brazo = b;
    addRequirements(brazo);
  }
  public MoveEncoder() {
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while t he command is scheduled.
  @Override
  public void execute() {
    
     if (brazo.Positionencoder()<42){
    brazo.MoveEncoder(Constants.SPEED*(42-brazo.Positionencoder()));
    SmartDashboard.putNumber("Valor Encoder", brazo.Positionencoder());
  }

  else {
    brazo.MoveEncoder(0);
  } 
}
  // Called once the command ends or is interrupted.
  @Override 
  public void end(boolean interrupted) {
    brazo.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
