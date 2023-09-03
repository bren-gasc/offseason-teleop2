// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

// ID motores
public static final int IDM1 = 1;
public static final int IDM2 = 2;
public static final int IDM3 = 3;
public static final int IDM4 = 4;
//Motor controllers
public static final int SpeedAxis = 4;
public static final int RotationAxis = 1;
//Speed
public static final double MAXSPEED = 0.7;
//XBOX Ids
public static final int JOYID1 = 1;
public static final int IDMS = 5;
public static final double SPEED = 0.3;
public static final int JOYID2 = 2;
//Auto
public static final int SPEED2 = 1;

//Camera   ID LLANTAS GARRA ID
public static final int MotorAID = 1;
public static final int MotorBID = 2;
public static final int ControlGarraID = 2;
}
