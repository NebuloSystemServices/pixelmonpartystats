package com.github.johnclark96.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class ItemHandlerInventoryWrapper implements IInventory {

    private final IItemHandler itemHandler;

    public ItemHandlerInventoryWrapper(IItemHandler itemHandler) {
        this.itemHandler = itemHandler;
    }

    public void setPredefinedItems() {
        // Set predefined items in the itemHandler here
    }

    @Override
    public int getContainerSize() {
        return itemHandler.getSlots();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int index) {
        return itemHandler.getStackInSlot(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return ItemStack.EMPTY; // Do not allow removing items
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ItemStack.EMPTY; // Do not allow removing items
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        // Do not allow setting items
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return true;
    }

    @Override
    public void clearContent() {

    }
}
