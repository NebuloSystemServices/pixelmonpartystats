package com.github.johnclark96.commands;

//import com.github.johnclark96.ui.CustomMenuContainer;
import com.github.johnclark96.ui.CustomMenuContainer;
import com.github.johnclark96.utils.PartyManager;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraftforge.fml.network.NetworkHooks;


import javax.annotation.Nullable;
import java.util.List;

import static com.github.johnclark96.PixelmonPartyStats.getLogger;

public class OpenMenuCommand {


    public OpenMenuCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("givs").executes((command) -> getPartyInfo(command.getSource())));
    }

    private void openCustomChestGUI(ServerPlayerEntity player) {
        NetworkHooks.openGui(player, new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new StringTextComponent("Party Stats");
            }

            @Nullable
            @Override
            public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
                return new CustomMenuContainer(id, playerInventory);
            }
        }, buffer -> {
            // You can send additional data through the buffer if needed
        });
    }

    private int getPartyInfo (CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrException();

        List<Pokemon> party = PartyManager.getPlayerParty(player);
        getLogger().info("Party size: " + party.size());

        for (int i = 0; i < party.size(); i++) {
            Pokemon pokemon = party.get(i);
            getLogger().info("Pokemon[" + i + "]: " + pokemon.getDisplayName() + " " + pokemon.getPokemonLevel() + " " + pokemon.getNature() + " " + pokemon.getGender());
        }

        source.sendSuccess(new StringTextComponent("Party info for " + player.getName().getString()), true);
        openCustomChestGUI(player);
        return 1;
    }

}
