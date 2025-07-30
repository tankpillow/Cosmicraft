package dev.tankpillow.cosmicraft;

import dev.tankpillow.cosmicraft.datagen.ModModelProvider;
import dev.tankpillow.cosmicraft.world.dimension.ModDimensions;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CosmicraftDataGenerator implements DataGeneratorEntrypoint 
{
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider::new);
	}
	
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
	}
}
