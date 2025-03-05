// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.lib.drivers;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;


import edu.wpi.first.wpilibj.Preferences;

/** Add your docs here. */
public class VikingSparkMax extends SparkMax {
    /**
     * Creates a new CANSparkMax with the necessary configurations.
     * @param deviceId The device ID.
     * @param m The motor type (Brushed/Brushless).
     * @param mode The idle mode (kBrake/kCoast).
     * @param limit The current limit.
     * @param isInverted The invert type of the motor.
     */
    public VikingSparkMax(int deviceId, MotorType m, IdleMode mode, int limit, boolean isInverted){
        super(deviceId, m);
        SparkMaxConfig config = new SparkMaxConfig();

        config
            .inverted(isInverted)
            .idleMode(mode);
            
        super.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        
        String key = "Spark " + this.getDeviceId() + " Flashes";
        Preferences.setDouble(key, Preferences.getDouble(key, 0) + 1);
    }

    /**
     * Creates a new CANSparkMax with the necessary motor and PID configurations.
     * @param deviceId The device ID.
     * @param m The mo
     * 
     * or type (Brushed/Brushless).
     * @param mode The idle mode (kBrake/kCoast).
     * @param limit The current limit.
     * @param isInverted The invert type of the motor.
     * @param kP The proportional gain value.
     * @param kI The integral gain value.
     * @param kD The derivative gain value.
     * @param minOutput Reverse power minimum to allow the controller to output
     * @param maxOutput Reverse power maximum to allow the controller to output
     */
    public VikingSparkMax(int deviceId, MotorType m, IdleMode mode, int limit, boolean isInverted, 
        double kP, double kI, double kD, double minOutput, double maxOutput){
        super(deviceId, m);
        SparkMaxConfig config = new SparkMaxConfig();
        config
            .inverted(isInverted)
            .idleMode(mode);
        config.closedLoop
            .pid(kP, kI, kD);
            
        super.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        String key = "Spark " + this.getDeviceId() + " Flashes";
        Preferences.setDouble(key, Preferences.getDouble(key, 0) + 1);
    }
}