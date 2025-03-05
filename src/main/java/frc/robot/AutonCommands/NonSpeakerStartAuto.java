package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SubsystemCommands.SwerveDriveCommands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Roller;

public class NonSpeakerStartAuto extends SequentialCommandGroup{
    
    public NonSpeakerStartAuto()
    {
        addCommands(
            new SwerveDriveCommands(.4, 0, 0).withTimeout(10),
            new SwerveDriveCommands(0, 0, 0)
        );
    }
}
