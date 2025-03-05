package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubsystemCommands.ArmCommands;
import frc.robot.subsystems.Arm;

public class ArmMethods extends Command {
    Arm arm;
    Joystick button;

    public ArmMethods (Arm arm, Joystick button) {
        this.arm = arm;
        this.button = button;
        addRequirements(arm);
    }

    @Override
    public void execute() {
        if (button.getRawButton(CommandConstants.ButtonShoulderL)) {
            ArmCommands command = new ArmCommands(.1, arm);
            command.execute();
        }
        else if (button.getRawButton(CommandConstants.ButtonShoulderR)) {
            ArmCommands command = new ArmCommands(-.1, arm);
            command.execute();
        }
        else{
            ArmCommands command = new ArmCommands(-.03, arm);
            command.execute();
        }
    }
}
