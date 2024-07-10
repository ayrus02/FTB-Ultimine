package dev.ftb.mods.ftbultimine.shape;

import dev.ftb.mods.ftbultimine.FTBUltimine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Flat3x6Shape implements Shape {
    @Override
    public String getName() {
        return "flat_3x6";
    }

    @Override
    public List<BlockPos> getBlocks(ShapeContext context) {
        List<BlockPos> list = new ArrayList<>(18);

        BlockPos basePos = context.pos();
        list.add(basePos);
        int depth = 0;

        Player uncachedPlayer = FTBUltimine.instance.getUncachedPlayer();
        String cardinalDirection = "";

        if (uncachedPlayer != null)
            cardinalDirection = FTBUltimine.instance.getCardinalDirection(uncachedPlayer.getDirection());

        while (depth < maxDepth() && list.size() < context.maxBlocks()) {
            int size = list.size();
            LAYER: for (int a = -1; a <= 1; a++) {
                    if (depth > 0 || a != 0) {

                        BlockPos pos = basePos;

                        switch (context.face().getAxis())
                        {
                            case X: // EAST(+) | WEST(-)
                                pos = basePos.offset(0, 0, a);
                                break;
                            case Y: // UP(+) |  DOWN(-)
                                if (cardinalDirection.equals("EAST")
                                        || cardinalDirection.equals("WEST"))
                                    pos = basePos.offset(0, 0, a);
                                else // cardinalDirection = NORTH || SOUTH
                                    pos = basePos.offset(a, 0, 0);
                                break;
                            case Z: // SOUTH(+) | NORTH(-)
                                pos = basePos.offset(a, 0, 0);
                                break;
                        };

                        if (context.check(pos)) {
                            list.add(pos);

                            if (list.size() >= context.maxBlocks()) {
                                break LAYER;
                            }
                        }
                    }
            }
            if (list.size() == size && depth > 0) {
                break; // none of the blocks behind that could be mined: so stop the iteration
            }
            basePos = basePos.relative(context.face().getOpposite());
            depth++;
        }

        return list;
    }

    protected int maxDepth() {
        return 6;
    }
}
