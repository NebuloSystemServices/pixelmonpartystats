package com.github.johnclark96.utils;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class ModCapabilityProvider {
    public static void registerCapabilities() {
        CapabilityManager.INSTANCE.register(CustomData.class, new CustomDataCapability.Storage(), CustomData::new);
    }

    // Call this method during mod initialization to register the capabilities
    // For example, in your mod main class's constructor or in FMLCommonSetupEvent
}
