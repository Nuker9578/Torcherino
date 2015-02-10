package com.sci.torcherino.init;

import com.sci.torcherino.block.BlockRedstoneTorcherino;
import com.sci.torcherino.block.BlockTorcherino;
import com.sci.torcherino.tile.TileRedstoneTorcherino;
import com.sci.torcherino.tile.TileTorcherino;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class ModBlocks
{
    public static BlockTorcherino torcherino;
    public static BlockRedstoneTorcherino redtorcherino;

    public static void init()
    {
        ModBlocks.torcherino = new BlockTorcherino();

        GameRegistry.registerBlock(ModBlocks.torcherino, ModBlocks.torcherino.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileTorcherino.class, "torcherino_tile");
    }
   

    {
        ModBlocks.redtorcherino = new BlockRedstoneTorcherino();

        GameRegistry.registerBlock(ModBlocks.redtorcherino, ModBlocks.redtorcherino.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileRedstoneTorcherino.class, "redtorcherino_tile");
    }

    private ModBlocks()
    {
    }
}