/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Mar 14, 2014, 8:54:11 PM (GMT)]
 */
package vazkii.botania.common.block.subtile.functional;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.subtile.SubTileFunctional;
import vazkii.botania.common.lexicon.LexiconData;

public class SubTileFallenKanade extends SubTileFunctional {

	@Override
	public void onUpdate() {
		super.onUpdate();

		final int range = 3;
		final int cost = 60;

		List<EntityPlayer> players = supertile.getWorldObj().getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(supertile.xCoord - range, supertile.yCoord - range, supertile.zCoord - range, supertile.xCoord + range, supertile.yCoord + range, supertile.zCoord + range));
		for(EntityPlayer player : players) {
			if(player.getActivePotionEffect(Potion.regeneration) == null && mana >= cost) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 60, 3));
				mana -= cost;
				sync();
			}
		}
	}

	@Override
	public int getColor() {
		return 0xFFFF00;
	}

	@Override
	public int getMaxMana() {
		return 240;
	}

	@Override
	public LexiconEntry getEntry() {
		return LexiconData.fallenKanade;
	}

}
