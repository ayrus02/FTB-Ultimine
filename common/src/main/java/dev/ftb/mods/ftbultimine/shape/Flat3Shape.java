package dev.ftb.mods.ftbultimine.shape;

public class Flat3Shape extends FlatShape {
    @Override
    public String getName() {
        return "flat_3";
    }

    @Override
    protected int maxWidth() { return 3; }

    @Override
    protected int maxDepth() { return Integer.MAX_VALUE; }
}
