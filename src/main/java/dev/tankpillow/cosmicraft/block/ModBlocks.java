package dev.tankpillow.cosmicraft.block;

import dev.tankpillow.cosmicraft.Cosmicraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
	
	// --- Moon Blocks --- //
	public static final Block MOON_SAND = registerBlock("moon_sand", new Block(AbstractBlock.Settings.create()
			.strength(0.5f)
			.sounds(BlockSoundGroup.SAND)));
	public static final Block MOON_STONE = registerBlock("moon_stone", new Block(AbstractBlock.Settings.create()
			.strength(0.8f)
			.sounds(BlockSoundGroup.STONE)));
	
	
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(Cosmicraft.MOD_ID, name), block);
	}
	
	private static void registerBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, Identifier.of(Cosmicraft.MOD_ID, name), new BlockItem(block, new Item.Settings()));
	}

	public static void register() {
		Cosmicraft.LOGGER.info("Registering mod blocks for " + Cosmicraft.MOD_ID + "...");
	}
	
}
