package frc.robot.AutonCommands;


import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmMethods;
import frc.robot.SubsystemCommands.ArmCommands;
import frc.robot.SubsystemCommands.RollerCommands;
import frc.robot.SubsystemCommands.SwerveDriveCommands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DrivetrainOld;
import frc.robot.subsystems.Roller;

public class MiddleStartAuto extends SequentialCommandGroup{
    final double shooterSpeed = 1;

    public MiddleStartAuto(Roller roller, Arm arm)
    {
        addCommands(
            new SwerveDriveCommands(0, 0, .2).withTimeout(.95),
            new SwerveDriveCommands(-.2, 0, 0).withTimeout(6),
            new ArmCommands(-.05, arm).withTimeout(3),
            new RollerCommands(-.2, roller).withTimeout(5)
            
        );
        // should shoot, then either go straight or vee]=r slightly right then left
    }
}
