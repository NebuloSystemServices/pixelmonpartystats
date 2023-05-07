//package com.github.johnclark96.ui;
//
//import com.github.johnclark96.utils.CustomData;
//import com.pixelmonmod.pixelmon.api.storage.*;
//import com.pixelmonmod.pixelmon.api.storage.PartyStorage;
//import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.inventory.container.ContainerType;
//import net.minecraft.inventory.container.Slot;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.StringTextComponent;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.CapabilityInject;
//import net.minecraftforge.common.capabilities.ICapabilityProvider;
//
//public class CustomMenuContainer extends Container {
//    @CapabilityInject(CustomData.class)
//    private static Capability<CustomData> CUSTOM_DATA_CAPABILITY;
//
//    private final CustomData customData;
//
//    public CustomMenuContainer(int windowId, PlayerInventory playerInventory, ICapabilityProvider capabilityProvider) {
//        super(ContainerType.GENERIC_9x3, windowId);
//
//        customData = capabilityProvider.getCapability(CUSTOM_DATA_CAPABILITY).orElse(null);
//
//        addSlots(playerInventory, capabilityProvider);
//    }
//
//    private void addSlots(PlayerInventory playerInventory, ICapabilityProvider capabilityProvider) {
//        // Retrieve Pixelmon data from the player's party
//        PlayerPartyStorage party = StorageProxy.getParty(player);
//
//
//        for (int i = 0; i < partyStorage.getSlotCount(); i++) {
//            StoragePosition position = new StoragePosition(StorageType.PARTY, i);
//            PixelmonEntity pixelmon = partyStorage.get(position).getOrCreatePixelmon();
//
//            // You can access and use the Pixelmon data as needed
//            // For example, you can get the species name using pixelmon.getSpecies().getPokemonName()
//
//            // Create a slot for each Pixelmon in the party
//            Slot slot = new Slot(partyStorage, i, 8 + i * 18, 20);
//            this.addSlot(slot);
//        }
//
//        // Add player inventory slots
//        int startX = 8;
//        int startY = 84;
//        int slotSizePlus2 = 18;
//
//        for (int row = 0; row < 3; ++row) {
//            for (int col = 0; col < 9; ++col) {
//                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, startX + col * slotSizePlus2, startY + row * slotSizePlus2));
//            }
//        }
//
//        for (int row = 0; row < 9; ++row) {
//            this.addSlot(new Slot(playerInventory, row, startX + row * slotSizePlus2, startY + 58));
//        }
//    }
//
//    @Override
//    public boolean stillValid(PlayerEntity player) {
//        return true;
//    }
//
//    @Override
//    public ITextComponent getDisplayName() {
//        return new StringTextComponent("Custom Menu");
//    }
//}
