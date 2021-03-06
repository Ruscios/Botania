/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Mar 19, 2014, 10:16:53 PM (GMT)]
 */
package vazkii.botania.common.block.subtile.functional;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import vazkii.botania.api.subtile.SubTileFunctional;

public class SubTileAgricarnation extends SubTileFunctional {

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(supertile.getWorldObj().getTotalWorldTime() % 3 == 0) {
			int range = 5;
			int x = supertile.xCoord + supertile.getWorldObj().rand.nextInt(range * 2 + 1) - range;
			int z = supertile.zCoord + supertile.getWorldObj().rand.nextInt(range * 2 + 1) - range;

			for(int i = 4; i > -2; i--) {
				int y = supertile.yCoord + i;

				if(supertile.getWorldObj().isAirBlock(x, y, z))
					continue;

				if(isPlant(x, y, z) && mana > 5) {
					Block block = supertile.getWorldObj().getBlock(x, y, z);
					mana -= 5;
					supertile.getWorldObj().scheduleBlockUpdate(x, y, z, block, 1);
					supertile.getWorldObj().playAuxSFX(2005, x, y, z, 6 + supertile.getWorldObj().rand.nextInt(4));

					break;
				}
			}
		}
	}

	boolean isPlant(int x, int y, int z) {
		Block block = supertile.getWorldObj().getBlock(x, y, z);
		if(block == Blocks.grass || block == Blocks.leaves || block == Blocks.leaves2 || (block instanceof BlockBush && !(block instanceof BlockCrops)))
			return false;

		Material mat = block.getMaterial();
		return mat != null && (mat == Material.plants || mat == Material.cactus || mat == Material.grass || mat == Material.leaves || mat == Material.vine || mat == Material.wood || mat == Material.gourd);
	}

	@Override
	public int getColor() {
		return 0x8EF828;
	}

	@Override
	public int getMaxMana() {
		return 200;
	}

}
