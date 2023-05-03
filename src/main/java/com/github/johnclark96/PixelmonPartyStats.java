package com.github.johnclark96;

import com.github.johnclark96.commands.OpenMenuCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PixelmonPartyStats.MOD_ID)
@Mod.EventBusSubscriber(modid = PixelmonPartyStats.MOD_ID)
public class PixelmonPartyStats {

    public static final String MOD_ID = "pixelmonpartystats";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    private static PixelmonPartyStats instance;

    public PixelmonPartyStats() {
        instance = this;
    }

    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {
        // Logic for when the server is starting here

        // Here is how you register a listener for Pixelmon events
        // Pixelmon has its own event bus for its events, as does TCG
        // So any event listener for those mods need to be registered to those specific event buses
//        Pixelmon.EVENT_BUS.register(new PixelmonEggHatchExampleListener());
//        Pixelmon.EVENT_BUS.register(new PokemonSpawnExampleListener());

    }

    @SubscribeEvent
    public static void onServerStarted(FMLServerStartedEvent event) {
        // Logic for once the server has started here
    }

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        //Register command logic here
        // Commands don't have to be registered here
        // However, not registering them here can lead to some hybrids/server software not recognising the commands
//        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
//        OpenMenuCommand.register(dispatcher);
        new OpenMenuCommand(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onServerStopping(FMLServerStoppingEvent event) {
        // Logic for when the server is stopping
    }

    @SubscribeEvent
    public static void onServerStopped(FMLServerStoppedEvent event) {
        // Logic for when the server is stopped
    }

    public static PixelmonPartyStats getInstance() {
        return instance;
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
