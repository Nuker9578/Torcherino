package com.sci.torcherino.block;

import com.sci.torcherino.Torcherino;
import com.sci.torcherino.tile.TileRedstoneTorcherino;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class BlockRedstoneTorcherino extends BlockRedstoneTorch implements ITileEntityProvider {

private boolean field_150113_a;

public BlockRedstoneTorcherino() {
    this.setBlockName("redtorcherino");
    this.setLightLevel(0.75f);
    this.setBlockTextureName("torcherino:redtorcherino" + (Torcherino.animatedTextures ? "_animated" : ""));
}

    @Override
    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        if (!world.isRemote) {
            final TileEntity tile = world.getTileEntity(x, y, z);

            if (tile != null && tile instanceof TileRedstoneTorcherino) {
                ((TileRedstoneTorcherino) tile).setActive(!world.isBlockIndirectlyGettingPowered(x, y, z));
            }
        }

        super.onBlockAdded(world, x, y, z);
    }
    
    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_)
    {
        if (!this.field_150113_a)
        {
            return 0;
        }
        else
        {
            int i1 = p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_);
            return i1 == 5 && p_149709_5_ == 1 ? 0 : (i1 == 3 && p_149709_5_ == 3 ? 0 : (i1 == 4 && p_149709_5_ == 2 ? 0 : (i1 == 1 && p_149709_5_ == 5 ? 0 : (i1 == 2 && p_149709_5_ == 4 ? 0 : 15))));
        }
    }

    @Override
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(x, y, z);

            if (tile != null && tile instanceof TileRedstoneTorcherino) {
                ((TileRedstoneTorcherino) tile).setActive(!world.isBlockIndirectlyGettingPowered(x, y, z));
            }
        }

        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int par1, final float par2, final float par3, final float par4) {
        if (!world.isRemote) {
            final TileEntity tile = world.getTileEntity(x, y, z);

            if (tile == null || !(tile instanceof TileRedstoneTorcherino)) {
                return false;
            }

            final TileRedstoneTorcherino torch = (TileRedstoneTorcherino) tile;

            torch.changeMode(player.isSneaking());

            if (player.isSneaking()) {
                player.addChatComponentMessage(new ChatComponentText("Changed speed: " + torch.getSpeedDescription()));
            } else {
                player.addChatComponentMessage(new ChatComponentText("Changed mode: " + torch.getModeDescription()));
            }
        }

        return false;
    }

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileRedstoneTorcherino();
    }
}