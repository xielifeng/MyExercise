package DesignPatterns.SimpleFactory;

abstract class Hat {
    HatColor myHatColor;

    @Override
    public String toString() {
        return "来，带上你的" + myHatColor + "帽子";
    }
}
