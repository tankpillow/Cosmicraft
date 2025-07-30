package dev.tankpillow.cosmicraft.datagen;

import dev.tankpillow.cosmicraft.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider
{

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_SAND);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_STONE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		
	}
	
	
}
