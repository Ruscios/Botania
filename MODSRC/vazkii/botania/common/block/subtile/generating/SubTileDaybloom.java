/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jan 25, 2014, 3:09:35 PM (GMT)]
 */
package vazkii.botania.common.block.subtile.generating;

import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.subtile.SubTileGenerating;
import vazkii.botania.common.lexicon.LexiconData;

public class SubTileDaybloom extends SubTileGenerating {

	@Override
	public int getColor() {
		return 0xFFFF00;
	}

	@Override
	public boolean shouldSyncPassiveGeneration() {
		return true;
	}

	@Override
	public LexiconEntry getEntry() {
		return LexiconData.daybloom;
	}

}
