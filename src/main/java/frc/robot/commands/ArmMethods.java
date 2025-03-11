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
            ArmCommands cmd = new ArmCommands(.1, arm);
            cmd.execute();
        }
        else if (button.getRawButton(CommandConstants.ButtonShoulderR)) {
            ArmCommands cmd = new ArmCommands(-.1, arm);
            cmd.execute();
       /* } else if (button.getRawButton(CommandConstants.ButtonShoulderL)) {
            ArmCommands cmd = new ArmCommands(0.1, arm);
            cmd.execute45(); */
        }
        else{
            ArmCommands cmd = new ArmCommands(-.01, arm);
            cmd.execute();
        }
    }
}