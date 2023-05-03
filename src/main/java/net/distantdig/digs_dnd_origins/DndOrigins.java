package net.distantdig.digs_dnd_origins;

import net.distantdig.digs_dnd_origins.entity.ModEntities;
import net.distantdig.digs_dnd_origins.entity.custom.ToyFrogEntity;
import net.distantdig.digs_dnd_origins.entity.projectiles.RedSpitEntity;
import net.distantdig.digs_dnd_origins.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DndOrigins implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "digs_dnd_origins";
    public static final Logger LOGGER = LoggerFactory.getLogger("digs_dnd_origins");
    public static final EntityType<RedSpitEntity> RedSpitEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "red_spit"),
            FabricEntityTypeBuilder.<RedSpitEntity>create(SpawnGroup.MISC, RedSpitEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10).build()
    );
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        ModItems.registerModItems();
        FabricDefaultAttributeRegistry.register(ModEntities.TOY_FROG, ToyFrogEntity.setAttributes());

        LOGGER.info("Hello Fabric world!");
    }
}