package com.sci.torcherino.block;

import com.sci.torcherino.Torcherino;
import com.sci.torcherino.tile.TileTorcherino;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class BlockTorcherino extends BlockTorch implements ITileEntityProvider {
    public BlockTorcherino() {
        this.setBlockName("torcherino");
        this.setLightLevel(0.75f);
        this.setBlockTextureName("torcherino:torcherino" + (Torcherino.animatedTextures ? "_animated" : ""));
    }

    @Override
    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        if (!world.isRemote) {
            final TileEntity tile = world.getTileEntity(x, y, z);

            if (tile != null && tile instanceof TileTorcherino) {
                ((TileTorcherino) tile).setActive(!world.isBlockIndirectlyGettingPowered(x, y, z));
            }
        }

        super.onBlockAdded(world, x, y, z);
    }

    @Override
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(x, y, z);

            if (tile != null && tile instanceof TileTorcherino) {
                ((TileTorcherino) tile).setActive(!world.isBlockIndirectlyGettingPowered(x, y, z));
            }
        }

        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int par1, final float par2, final float par3, final float par4) {
        if (!world.isRemote) {
            final TileEntity tile = world.getTileEntity(x, y, z);

            if (tile == null || !(tile instanceof TileTorcherino)) {
                return false;
            }

            final TileTorcherino torch = (TileTorcherino) tile;

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
        return new TileTorcherino();
    }
}