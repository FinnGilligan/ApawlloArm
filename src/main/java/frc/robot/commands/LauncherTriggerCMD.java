package frc.robot.commands;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class LauncherTriggerCMD extends CommandBase{
    private Launcher launcher;
    private Supplier<Double> speed;

    public LauncherTriggerCMD(Launcher launcher, Supplier<Double> speed) {
        this.launcher = launcher;
        this.speed = speed;
        addRequirements(launcher);
    }

    public void initialize() {}

    @Override
    public void execute() {
        launcher.setSpeed(speed.get() / 2);
    }

    @Override
    public void end(boolean interrupted) {
        launcher.stop();
    }

    @Override
    public boolean isFinished() {
    return false;
    }
}