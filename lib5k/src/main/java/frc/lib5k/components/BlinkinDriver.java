package frc.lib5k.components;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

/**
 * A wrapper for the REV Blinkin LED driver <br>
 * http://www.revrobotics.com/rev-11-1105/
 */
public class BlinkinDriver implements Sendable {

    public enum LEDSetting {
        RAINBOW(-0.99), RAINBOW_PARTY(-0.97), RAINBOW_OCEAN(-0.95), RAINBOW_LAVA(-0.93), RAINBOW_FOREST(-0.91),
        RAINBOW_GLITTER(-0.89), CONFETTI(-0.87), RED_SHOT(-0.85), BLUE_SHOT(-0.83), WHITE_SHOT(-0.81),
        SINELON_RAINBOW(-0.79), SINELON_PARTY(-0.77), SINELON_OCEAN(-0.75), SINELON_LAVA(-0.73), SINELON_FOREST(-0.71),
        BPM_RAINBOW(-0.69), BPM_OCEAN(-0.65), BPM_LAVA(-0.63), BPM_FOREST(-0.61), FIRE_MEDIUM(-0.59), FIRE_LARGE(-0.57),
        TWINKLES_RAINBOW(-0.55), TWINKLES_PARTY(-0.53), TWINKLES_OCEAN(-0.51), TWINKLES_LAVA(-0.49),
        TWINKLES_FOREST(-0.47), WAVES_RAINBOW(-0.45), WAVES_PARTY(-0.43), WAVES_OCEAN(-0.41), WAVES_LAVA(-0.39),
        WAVES_FOREST(-0.37), LARSON_RED(-0.35), LARSON_GRAY(-0.33), CHASE_RED(-0.31), CHASE_BLUE(-0.29),
        CHASE_GRAY(-0.27), HEARTBEAT_RED(-0.25), HEARTBEAT_BLUE(-0.23), HEARTBEAT_WHITE(-0.21), HEARTBEAT_GRAY(-0.19),
        BREATH_RED(-0.17), BREATH_BLUE(-0.15), BREATH_GRAY(-0.13), STROBE_BLUE(-0.09), STROBE_GOLD(-0.07),
        STROBE_WHITE(-0.05), COLOR1_BLEND_TO_BLACK(-0.03), COLOR1_LARSON(-0.01), COLOR1_CHASE(0.01),
        COLOR1_HEARTBEAT_SLOW(0.03), COLOR1_HEARTBEAT_MEDIUM(0.05), COLOR1_HEARTBEAT_FAST(0.07),
        COLOR1_BREATH_SLOW(0.09), COLOR1_BREATH_FAST(0.11), COLOR1_SHOT(0.13), COLOR1_STROBE(0.15),
        COLOR2_BLEND_TO_BLACK(0.17), COLOR2_LARSON(0.19), COLOR2_CHASE(0.21), COLOR2_HEARTBEAT_SLOW(0.23),
        COLOR2_HEARTBEAT_MEDIUM(0.25), COLOR2_HEARTBEAT_FAST(0.27), COLOR2_BREATH_SLOW(0.29), COLOR2_BREATH_FAST(0.31),
        COLOR2_SHOT(0.33), COLOR2_STROBE(0.35), SPARKLE_1_ON_2(0.37), SPARKLE_2_ON_1(0.39), GRADIENT_1_AND_2(0.41),
        BPM_1_AND_2(0.43), END_BLEND_1_AND_2(0.45), END_BLEND(0.47), COLOR_1_AND_2_NO_BLEND(0.49),
        TWINKLE_1_AND_2(0.51), WAVES_1_AND_2(0.53), SINELON_1_AND_2(0.55), HOT_PINK(0.57), DARK_RED(0.59), RED(0.61),
        RED_ORANGE(0.63), ORANGE(0.65), GOLD(0.67), YELLOW(0.69), LAWN_GREEN(0.71), LIME(0.73), DARK_GREEN(0.75),
        GREEN(0.77), BLUE_GREEN(0.79), AQUA(0.81), SKY_BLUE(0.83), DARK_BLUE(0.85), BLUE(0.87), BLUE_VIOLET(0.89),
        VIOLET(0.91), WHITE(0.93), GRAY(0.95), DARK_GRAY(0.97), BLACK(0.99);

        private double m_pwmVal;

        LEDSetting(double pwm_val) {
            m_pwmVal = pwm_val;
        }

        public double get() {
            return m_pwmVal;
        }

    }

    Spark m_controller;

    /**
     * A wrapper for the REV Blinkin LED driver
     * 
     * @param pwm_port The PWM channel for the deivce
     */
    public BlinkinDriver(int pwm_port) {
        m_controller = new Spark(pwm_port);
    }

    /**
     * Set the LED driver to a specific setting
     * 
     * @param setting LED pattern
     */
    public void set(LEDSetting setting) {
        m_controller.set(setting.get());
    }

    /**
     * This method handles interaction with some internal WPIlib services
     */
    @Override
    public void initSendable(SendableBuilder builder) {

    }

}