package frc.team3171.drive;

// FRC Imports
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

// CTRE Imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;;

/**
 * Encapsulates the {@link TalonSRX} to comply with the {@link MotorController}
 * interface so that it can function within FRC designed drive trains.
 * 
 * @author Mark Ebert
 */
public class FRCTalonSRX extends TalonSRX implements MotorController {

    /**
     * Constructor
     * 
     * @param deviceNumber
     *            [0,62]
     */
    public FRCTalonSRX(int deviceNumber) {
        super(deviceNumber);
        configFactoryDefault();
        setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void set(double speed) {
        set(ControlMode.PercentOutput, speed);
    }

    @Override
    public double get() {
        return getMotorOutputPercent();
    }

    @Override
    public void disable() {
        set(ControlMode.Disabled, 0);
    }

    @Override
    public void stopMotor() {
        set(ControlMode.Disabled, 0);
    }

}