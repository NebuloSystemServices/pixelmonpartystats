package com.github.johnclark96.utils;

import com.github.johnclark96.ui.CustomMenuScreen;
import com.github.johnclark96.utils.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy {
    public void registerScreenFactories(FMLClientSetupEvent event) {
        ScreenManager.register(ModContainerTypes.CUSTOM_MENU_CONTAINER, CustomMenuScreen::new);
    }
}