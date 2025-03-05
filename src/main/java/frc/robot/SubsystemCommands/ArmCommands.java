package frc.robot.SubsystemCommands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class ArmCommands extends Command {
    Arm arm;
    double power;

    public ArmCommands(double speed, Arm arm) {
        this.arm = arm;
        this.power = speed;
        addRequirements(arm);
    }

    public void execute() {
        arm.move(power);
    }

    public void stop() {
        arm.move(0);
    } 
}
// Written by Wolfram121