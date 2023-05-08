package com.github.johnclark96.utils;

import com.github.johnclark96.ui.CustomMenuContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.rmi.registry.Registry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModContainerTypes {

    public static ContainerType<CustomMenuContainer> CUSTOM_MENU_CONTAINER;

    @SubscribeEvent
    public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
        CUSTOM_MENU_CONTAINER = new ContainerType<>(CustomMenuContainer::new);
        CUSTOM_MENU_CONTAINER.setRegistryName("custom_menu_container");
        event.getRegistry().register(CUSTOM_MENU_CONTAINER);
    }

}
