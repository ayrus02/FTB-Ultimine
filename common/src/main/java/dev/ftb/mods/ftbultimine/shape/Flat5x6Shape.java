package dev.ftb.mods.ftbultimine.shape;

import dev.ftb.mods.ftbultimine.FTBUltimine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Flat5x6Shape extends FlatShape {
    @Override
    public String getName() {
        return "flat_5x6";
    }

    @Override
    protected int maxWidth() { return 5; }

    @Override
    protected int maxDepth() { return 6; }
}
