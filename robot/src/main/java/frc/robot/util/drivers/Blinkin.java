package frc.robot.util.drivers;

import edu.wpi.first.wpilibj.Spark;

/**
 * Driver Class for a REV Robotics Blinkin Device
 */
public class Blinkin {

    /**
     * Represents a Fixed Palette Pattern on the Blinkin
     */
    public static enum FixedPalettePattern {
        RAINBOW_RAINBOW(-0.99),
        RAINBOW_PARTY(-0.97),
        RAINBOW_OCEAN(-0.95),
        RAINBOW_LAVA(-0.93),
        RAINBOW_FOREST(-0.91),
        RAINBOW_GLITTER(-0.89),
        CONFETTI(-0.87),
        SHOT_RED(-0.85),
        SHOT_BLUE(-0.83),
        SHOT_WHITE(-0.81),
        SINELON_RAINBOW(-0.79),
        SINELON_PARTY(-0.77),
        SINELON_OCEAN(-0.75),
        SINELON_LAVA(-0.73),
        SINELON_FOREST(-0.71),
        BPM_RAINBOW(-0.69),
        BPM_PARTY(-0.67),
        BPM_OCEAN(-0.65),
        BPM_LAVA(-0.63),
        BPM_FOREST(-0.61),
        FIRE_MEDIUM(-0.59),
        FIRE_LARGE(-0.57),
        TWINKLES_RAINBOW(-0.55),
        TWINKLES_PARTY(-0.53),
        TWINKLES_OCEAN(-0.51),
        TWINKLES_LAVA(-0.49),
        TWINKLES_FOREST(-0.47),
        COLOR_WAVES_RAINBOW(-0.45),
        COLOR_WAVES_PARTY(-0.43),
        COLOR_WAVES_OCEAN(-0.41),
        COLOR_WAVES_LAVA(-0.39),
        COLOR_WAVES_FOREST(-0.37),
        LARSON_RED(-0.35),
        LARSON_GRAY(-0.33),
        LIGHT_CHASE_RED(-0.31),
        LIGHT_CHASE_BLUE(-0.29),
        LIGHT_CHASE_GRAY(-0.27),
        HEARTBEAT_RED(-0.25),
        HEARTBEAT_BLUE(-0.23),
        HEARTBEAT_WHITE(-0.21),
        HEARTBEAT_GRAY(-0.19),
        BREATH_RED(-0.17),
        BREATH_BLUE(-0.15),
        BREATH_GRAY(-0.13),
        STROBE_RED(-0.11),
        STROBE_BLUE(-0.09),
        STROBE_GOLD(-0.07),
        STROBE_WHITE(-0.05);

        private double mValue;

        public double getValue() {
            return this.mValue;
        }

        private FixedPalettePattern(double val) {
            this.mValue = val;
        }
    };

    /**
     * Represents a user specified color(s) pattern on the Blinkin
     */
    public static enum ColorPattern {
        C1_END_TO_END_BLEND_TO_BLACK(-0.03),
        C1_LARSON(-0.01),
        C1_LIGHT_CHASE(0.01),
        C1_HEARTBEAT_SLOW(0.03),
        C1_HEARTBEAT_MEDIUM(0.05),
        C1_HEARTBEAT_FAST(0.07),
        C1_BREATH_SLOW(0.09),
        C1_BREATH_FAST(0.11),
        C1_SHOT(0.13),
        C1_STROBE(0.15),
        C2_END_TO_END_BLEND_TO_BLACK(0.17),
        C2_LARSON(0.19),
        C2_LIGHT_CHASE(0.21),
        C2_HEARTBEAT_SLOW(0.23),
        C2_HEARTBEAT_MEDIUM(0.25),
        C2_HEARTBEAT_FAST(0.27),
        C2_BREATH_SLOW(0.29),
        C2_BREATH_FAST(0.31),
        C2_SHOT(0.33),
        C2_STROBE(0.35),
        
        C1_C2_SPARKLE_C1_ON_C2(0.37),
        C1_C2_SPARKLE_C2_ON_C1(0.39),
        C1_C2_GRADIENT(0.41),
        C1_C2_BPM(0.43),
        C1_C2_END_TO_END_BLEND_C1_TO_C2(0.45),
        C1_C2_END_TO_END_BLEND_C2_TO_C1(0.47),
        C1_C2_NO_BLEND(0.49),
        C1_C2_TWINKLES(0.51),
        C1_C2_COLOR_WAVE(0.53),
        C1_C2_SINELON(0.55);

        private double mValue;

        public double getValue() {
            return this.mValue;
        }

        private ColorPattern(double val) {
            this.mValue = val;
        }
    }

    /**
     * Represents a Solid Color pattern on the Blinkin
     */
    public static enum SolidColor {
        HOT_PINK(0.57),
        DARK_RED(0.59),
        RED(0.61),
        RED_ORANGE(0.63),
        ORANGE(0.65),
        GOLD(0.67),
        YELLOW(0.69),
        LAWN_GREEN(0.71),
        LIME(0.73),
        DARK_GREEN(0.75),
        GREEN(0.77),
        BLUE_GREEN(0.79),
        AQUA(0.81),
        SKY_BLUE(0.83),
        DARK_BLUE(0.85),
        BLUE(0.87),
        BLUE_VIOLET(0.89),
        VIOLET(0.91),
        WHITE(0.93),
        GRAY(0.95),
        DARK_GRAY(0.97),
        BLACK(0.99);

        private double mValue;

        public double getValue() {
            return this.mValue;
        }

        private SolidColor(double val) {
            this.mValue = val;
        }
    };

    private int mPwmChannel;

    private Spark mController;

    public Blinkin(int channel) {
        mPwmChannel = channel;
        mController = new Spark(channel);
    }

    public void setDisplay(FixedPalettePattern mode) {
        mController.set(mode.getValue());
    }

    public void setDisplay(ColorPattern mode) {
        mController.set(mode.getValue());
    }

    public void setDisplay(SolidColor mode) {
        mController.set(mode.getValue());
    }
}