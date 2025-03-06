package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


//Imma treat Climber like an human arm

public class Climber extends SubsystemBase {
    public SparkMax climberMotorShoulder;
    public SparkMax climberMotorElbow;
    public SparkMax climberMotorWrist;
    public SparkMax climberMotorHand;

    public final int SPARKMAX_ID_SHOULDER;
    public final int SPARKMAX_ID_ELBOW;
    public final int SPARKMAX_ID_WRIST;
    public final int SPARKMAX_ID_HAND;

    public Climber() {
        SPARKMAX_ID_SHOULDER = 14;
        SPARKMAX_ID_ELBOW = 15;
        SPARKMAX_ID_WRIST = 16;
        SPARKMAX_ID_HAND = 0;

        climberMotorShoulder = new SparkMax(SPARKMAX_ID_SHOULDER, MotorType.kBrushless);
        climberMotorElbow = new SparkMax(SPARKMAX_ID_ELBOW, MotorType.kBrushless);
        climberMotorHand = new SparkMax(SPARKMAX_ID_HAND, MotorType.kBrushless);
        climberMotorWrist = new SparkMax(SPARKMAX_ID_WRIST, MotorType.kBrushless);
    }

    public void move_shoulder(double speed){
        climberMotorShoulder.set(speed);
    }

    public void move_elbow(double speed){
        climberMotorElbow.set(speed);
    }

    public void move_wrist(double speed){
        climberMotorWrist.set(speed);
    }

    public void move_hand(double speed){
        climberMotorHand.set(speed);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Climber Motor Shoulder "+SPARKMAX_ID_SHOULDER, climberMotorShoulder.get());
        SmartDashboard.putNumber("Climber Motor Elbow "+SPARKMAX_ID_ELBOW, climberMotorElbow.get());
        SmartDashboard.putNumber("Climber Motor Wrist "+SPARKMAX_ID_WRIST, climberMotorWrist.get());
        SmartDashboard.putNumber("Climber Motor Hand "+SPARKMAX_ID_HAND, climberMotorHand.get());
    }
}

//Created by Aditya-2204