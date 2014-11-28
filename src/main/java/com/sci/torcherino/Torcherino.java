package com.sci.torcherino;

import com.sci.torcherino.init.ModBlocks;
import com.sci.torcherino.init.Recipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(modid = Props.ID, name = Props.NAME, version = Props.VERSION)
public class Torcherino
{
    private static Torcherino instance;

    @Mod.InstanceFactory
    public static Torcherino instance()
    {
        if (Torcherino.instance == null)
            Torcherino.instance = new Torcherino();
        return Torcherino.instance;
    }

    private Torcherino()
    {
    }

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent evt)
    {
        ModBlocks.init();
        Recipes.init();
    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent evt)
    {
    }

    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent evt)
    {
    }
}