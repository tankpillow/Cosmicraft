package dev.tankpillow.cosmicraft.itemgroup;

import dev.tankpillow.cosmicraft.Cosmicraft;
import dev.tankpillow.cosmicraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

	public static final ItemGroup COSMIC_BLOCKS = Registry.register(Registries.ITEM_GROUP, Identifier.of(Cosmicraft.MOD_ID, "cosmic_blocks"),
			FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.MOON_SAND))
					.displayName(Text.translatable("itemgroup." + Cosmicraft.MOD_ID + ".cosmic_blocks"))
					.entries((displayContext, entries) -> {
						entries.add(ModBlocks.MOON_SAND);
						entries.add(ModBlocks.MOON_STONE);
					}).build());
	
	public static void register() {
		Cosmicraft.LOGGER.info("Registering mod item groups for " + Cosmicraft.MOD_ID + "...");
	}
	
}
