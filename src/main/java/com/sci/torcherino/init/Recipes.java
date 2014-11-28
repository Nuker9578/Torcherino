package com.sci.torcherino.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcherino), new Object[]{"XCX", "CTC", "XCX", 'C', Items.clock, 'T', Blocks.torch});
    }

    private Recipes()
    {
    }
}