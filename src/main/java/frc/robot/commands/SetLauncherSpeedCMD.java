package frc.robot.commands;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.Constants;


public class SetLauncherSpeedCMD extends Command{
    private Launcher launcher;
    private double speed;

    public SetLauncherSpeedCMD(Launcher launcher, double speed) {
        this.launcher = launcher;
        this.speed = speed;
        addRequirements(launcher);
    }

    public void initialize() {}

    @Override
    public void execute() {
        launcher.setSpeed(this.speed);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        boolean leftSideUpToSpeed = Math.abs(launcher.getLeftVelocity()-this.speed) < Constants.EndEffectorConstants.launcherThreshold;
        boolean rightSideUpToSpeed = Math.abs(launcher.getRightVelocity()-this.speed) <  Constants.EndEffectorConstants.launcherThreshold;
        return leftSideUpToSpeed && rightSideUpToSpeed;
    }
}