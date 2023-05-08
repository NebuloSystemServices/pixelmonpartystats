package com.github.johnclark96.utils;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;

import javax.sql.rowset.spi.SyncFactoryException;
import java.util.List;
import java.util.logging.Logger;

import static javax.sql.rowset.spi.SyncFactory.getLogger;

public class PartyManager {

    public static List<Pokemon> getPlayerParty(PlayerEntity player) {
        return StorageProxy.getParty((ServerPlayerEntity) player).getTeam();

    }
    public PartyManager() {



    }
}
