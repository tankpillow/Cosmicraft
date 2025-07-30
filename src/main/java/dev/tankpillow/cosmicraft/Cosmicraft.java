package dev.tankpillow.cosmicraft;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.tankpillow.cosmicraft.block.ModBlocks;
import dev.tankpillow.cosmicraft.itemgroup.ModItemGroup;

public class Cosmicraft implements ModInitializer 
{
	
	public static final String MOD_ID = "cosmicraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() 
	{
		ModBlocks.register();
		ModItemGroup.register();
	}
}