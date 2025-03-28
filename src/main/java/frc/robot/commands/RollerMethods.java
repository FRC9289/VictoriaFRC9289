package frc.robot.commands;

import frc.robot.SubsystemCommands.RollerCommands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Roller;
import edu.wpi.first.wpilibj2.command.Command;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Joystick;

public class RollerMethods extends Command {
    Roller roller;
    Joystick button;
    int flip = 1;
    RelativeEncoder arm_encoder;

    public RollerMethods(Roller roller, Joystick button, Arm arm) {
        this.roller = roller;
        this.button = button;
        this.arm_encoder = arm.getEncoder();
        addRequirements(roller);
    }

    @Override
    public void execute() {
        if (button.getRawButton(CommandConstants.ButtonB)) {
            RollerCommands command = new RollerCommands(.25, roller);
            command.execute();
        } else if (button.getRawAxis(CommandConstants.AxisLeftTrigger) > CommandConstants.TriggerThreshold) {
            RollerCommands command = new RollerCommands(-1 * button.getRawAxis(CommandConstants.AxisLeftTrigger), roller);
            command.execute();
        } else if (button.getRawButton(CommandConstants.ButtonShoulderL)) {
            RollerCommands command = new RollerCommands(-.3, roller);
            command.execute();
        } else if (button.getRawButton(CommandConstants.ButtonA)) {
            RollerCommands command = new RollerCommands(-.25, roller);
            command.execute();
        } else if (button.getRawAxis(CommandConstants.AxisRightTrigger) > CommandConstants.TriggerThreshold) {
            RollerCommands command = new RollerCommands(button.getRawAxis(CommandConstants.AxisRightTrigger), roller);
            command.execute();
        } else if (button.getRawButton(CommandConstants.ButtonShoulderR) && arm_encoder.getPosition() > 100) {
            RollerCommands command = new RollerCommands(.3, roller);
            command.execute();
        } else {
            RollerCommands command = new RollerCommands(0, roller);
            command.execute();
        }
    }
}
/*
 * Created by Aditya-2204 & Wolfram121
 */