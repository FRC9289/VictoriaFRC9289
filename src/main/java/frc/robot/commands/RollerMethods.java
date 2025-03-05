package frc.robot.commands;

import frc.robot.SubsystemCommands.RollerCommands;
import frc.robot.subsystems.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

public class RollerMethods extends Command {
    Roller roller;
    Joystick button;

    public RollerMethods(Roller roller, Joystick button) {
        this.roller = roller;
        this.button = button;
        addRequirements(roller);
    }

    @Override
    public void execute() {
        if (button.getRawButton(CommandConstants.ButtonB)) {
            RollerCommands command = new RollerCommands(.2, roller);
            command.execute();
        }
        else if (button.getRawButton(CommandConstants.ButtonA)) {
            RollerCommands command = new RollerCommands(-.2, roller);
            command.execute();
        }
        else{
            RollerCommands command = new RollerCommands(0, roller);
            command.execute();
        }
    }
}

/*
 * Created by Aditya-2204
 */