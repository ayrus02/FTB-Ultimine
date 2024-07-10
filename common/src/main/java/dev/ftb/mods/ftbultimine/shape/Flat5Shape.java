package dev.ftb.mods.ftbultimine.shape;

public class Flat5Shape extends FlatShape {
    @Override
    public String getName() {
        return "flat_5";
    }

    @Override
    protected int maxWidth() { return 5; }

    @Override
    protected int maxDepth() { return Integer.MAX_VALUE; }
}
