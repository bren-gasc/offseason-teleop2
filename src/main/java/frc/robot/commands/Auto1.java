// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainTankFalcon;

public class Auto1 extends CommandBase {
  DriveTrainTankFalcon drivetrainPrueba;
  double dist;
  double distancia;
  public boolean finish = false;
  double rotacion;
  /** Creates a new Auto1. */
  public Auto1(DriveTrainTankFalcon dr, double di, double dis, double ro)
{
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrainPrueba = dr;
    dist = di;
    distancia = dis;
    rotacion = ro;
    addRequirements(drivetrainPrueba);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double valorencodercm = drivetrainPrueba.EncoderChassis()*0.25*0.625*3.141592*6*2.54;
    while((valorencodercm) < dist){
      drivetrainPrueba.auto1(distancia, rotacion);
    }
    finish = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainPrueba.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
