package com.github.johnclark96.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

import static com.github.johnclark96.PixelmonPartyStats.getLogger;

public class OpenMenuCommand {
    public OpenMenuCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("openmenu").executes((command) -> getPartyInfo(command.getSource())));
    }

    private int getPartyInfo (CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrException();
        getLogger().info("Player: " + player.getName().getString());

        source.sendSuccess(new StringTextComponent("Party info"), true);
        return 1;
    }


}
