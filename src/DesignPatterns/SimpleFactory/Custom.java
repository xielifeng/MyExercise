package DesignPatterns.SimpleFactory;

public class Custom {
    public static void main(String[] args) {
        Hat yelloHat = HatFactory.createHat(HatColor.YELLOW);
        System.out.println(yelloHat);
        Hat greenHat = HatFactory.createHat(HatColor.GREEN);
        System.out.println(greenHat);
    }
}
