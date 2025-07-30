package dev.tankpillow.cosmicraft.world.dimension;

import dev.tankpillow.cosmicraft.Cosmicraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

public class ModDimensions {
	
	public static final RegistryKey<DimensionOptions> MOON_KEY = RegistryKey.of(RegistryKeys.DIMENSION, 
			new Identifier(Cosmicraft.MOD_ID, "the_moon"));
	public static final RegistryKey<World> MOON_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD, 
			new Identifier(Cosmicraft.MOD_ID, "the_moon"));
	public static final RegistryKey<DimensionType> MOON_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
			new Identifier(Cosmicraft.MOD_ID, "the_moon_type"));

	public static void bootstrapType(Registerable<DimensionType> context) {
		context.register(MOON_TYPE, new DimensionType(
				null, // fixedTime
				false, // hasSkylight
				false, // hasCeiling
				false, // ultraWarm
				true, // natural
				1.0, // coordinateScale
				true, // bedWords
				false, // respawnAnchorWorks
				0, // minY
				256, // height
				256, // logicalHeight
				BlockTags.INFINIBURN_OVERWORLD, // infiniBurn
				DimensionTypes.OVERWORLD_ID, // effectsLocation
				1.0f, // ambientLight
				new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
	}
	
}
