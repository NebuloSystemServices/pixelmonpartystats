package com.github.johnclark96.ui;

import com.github.johnclark96.utils.ItemHandlerInventoryWrapper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class CustomMenuContainer extends ChestContainer {

    public CustomMenuContainer(int id, PlayerInventory playerInventory) {
        this(id, playerInventory, new ItemStackHandler(9 * 6));
    }

    public CustomMenuContainer(int id, PlayerInventory playerInventory, ItemStackHandler inventory) {
        super(ContainerType.GENERIC_9x5, id, playerInventory, new ItemHandlerInventoryWrapper(inventory), 6);
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        Slot slot = getSlot(index);
        if (slot == null || !slot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = slot.getItem();
        ItemStack originalStack = stack.copy();

        int numRows = 5;
        int inventorySize = numRows * 9;

        if (index < inventorySize) {
            if (!moveItemStackTo(stack, inventorySize, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
        } else if (!moveItemStackTo(stack, 0, inventorySize, false)) {
            return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }

        return originalStack;
    }
}