package DesignPatterns.SimpleFactory;

public class HatFactory {
    public static Hat createHat(HatColor hatColor) {
        switch (hatColor) {
            case RED:
                return new RedHat();
            case YELLOW:
                return new YellowHat();
            default:
                return new GreenHat();
        }
    }
}
