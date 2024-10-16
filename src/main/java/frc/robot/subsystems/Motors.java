package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class Motors {
    int motor1Id;
    VictorSPX motor1;
     int motor2Id;
    VictorSPX motor2;

    public Motors(int Motor1Id, int Motor2Id, boolean invert){
        this.motor1Id = motor1Id;
        this.motor1 = new VictorSPX(motor1Id);
        this.motor2Id = motor2Id;
        this.motor2 = new VictorSPX(motor2Id);

        this.motor1.setInverted(invert);

        this.motor2.setInverted(invert);
    }

    public void set(double percentage) {
        this.motor1.set(ControlMode.PercentOutput, percentage);
    }


}