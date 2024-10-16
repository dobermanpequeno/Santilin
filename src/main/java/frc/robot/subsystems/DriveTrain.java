package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants;

public class DriveTrain {
    Motors rightMotors;
    Motors leftMotors;

    DifferentialDrive driveTrain;
    ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    ShuffleboardTab shuffleboard;

    public DriveTrain() {
        rightMotors = new
        
        Motors(Constants.DriveTrainConstants.frontRightId, Constants.DriveTrainConstants.backRightId, false);

        leftMotors  = new
        Motors(Constants.DriveTrainConstants.frontLeftId, Constants.DriveTrainConstants.backLeftId, true);

        driveTrain = new DifferentialDrive(rightMotors::set,leftMotors::set);

        shuffleboard = Shuffleboard.getTab("Gyro");
        shuffleboard.addDouble("Robot yaw: ", (() -> gyro.getAngle()));
    }

    public void moveRobot(double xSpeed, double rotation) {
        driveTrain.arcadeDrive(xSpeed, rotation);
    }
}