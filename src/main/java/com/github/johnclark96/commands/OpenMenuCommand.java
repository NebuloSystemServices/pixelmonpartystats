package com.github.johnclark96.commands;

//import com.github.johnclark96.ui.CustomMenuContainer;
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
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;



import static com.github.johnclark96.PixelmonPartyStats.getLogger;

public class OpenMenuCommand {
    private Pokemon slotone;
    private Pokemon slottwo;
    private Pokemon slotfour;
    private Pokemon slotfive;
    private Pokemon slotsix;


    public OpenMenuCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("givs").executes((command) -> getPartyInfo(command.getSource())));
    }

    private int getPartyInfo (CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrException();
        getLogger().info("Player: " + player.getName().getString());
        PlayerPartyStorage party = StorageProxy.getParty(player);
        getLogger().info("Party: " + party.getTeam().toString());
        getLogger().info("Party size: " + party.getTeam().size());

        source.sendSuccess(new StringTextComponent("Party info for " + player.getName().getString()), true);

        Pokemon slotone = party.getTeam().get(0);
        Pokemon slottwo = party.getTeam().get(1);
//        Pokemon slotthree = party.getTeam().get(2).toPokemon();
//        Pokemon slotfour = party.getTeam().get(3).toPokemon();
//        Pokemon slotfive = party.getTeam().get(4).toPokemon();
//        Pokemon slotsix = party.getTeam().get(5).toPokemon();
        getLogger().info(slotone.getDisplayName());
        getLogger().info(slottwo.getDisplayName());
//        getLogger().info(slotthree.getDisplayName());

//        level = slotone.getPokemonLevel();

        //Get the pokemons Level


        getLogger().info("Pokemon[1]: " + slotone.getDisplayName() + " " + slotone.getPokemonLevel() + " " + slotone.getNature() + " " + slotone.getGender());
        getLogger().info("Pokemon[2]: " + slottwo.getDisplayName() + " " + slottwo.getPokemonLevel() + " " + slottwo.getNature() + " " + slottwo.getGender());


//        for (int i = 0; i < party.getTeam().size(); i++) {
//            getLogger().info("Pokemon: " + party.getTeam().get(i).getDisplayName());
//        }

        //Check each pokemon in the party and print their name and level
//        for (int i = 0; i < party.getTeam().size(); i++) {
//            PlayerPartyStorage party2 = StorageProxy.getParty(player);
//            getLogger().info("Pokemon: " + party2.getTeam().get(i).getDisplayName());
//        }

//        //Check each pokemon in the party and print their name and level
//        for (int i = 0; i < party.getTeam().size(); i++) {
//            PlayerPartyStorage party3 = StorageProxy.getParty(player);
//            getLogger().info("Pokemon: " + party3.getTeam().get(i).getDisplayName());
//            player.sendMessage(new StringTextComponent("Pokemon: " + party3.getTeam().get(i).getDisplayName()), player.getUUID());
//        }



//        player.sendMessage(new StringTextComponent("Player: " + player.getName().getString()), player.getUUID());
//        player.sendMessage(new StringTextComponent("Party size: " + party.getTeam().size()), player.getUUID());
//        player.sendMessage(new StringTextComponent("Pokemon: " + party.getTeam().get(0).getDisplayName() + ", " + party.getTeam().get(1).getDisplayName()), player.getUUID());



//        int containerId = player.containerCounter.nextContainerCounter;
//        Container container = new CustomMenuContainer(containerId, player.inventory);
//        player.openMenu(container);

        source.sendSuccess(new StringTextComponent("Party info for " + player.getName().getString()), true);
        return 1;
    }

}
