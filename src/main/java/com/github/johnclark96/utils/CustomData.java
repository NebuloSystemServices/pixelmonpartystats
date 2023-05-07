package com.github.johnclark96.utils;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class CustomData implements INBTSerializable<CompoundNBT> {
    private boolean someFlag;

    public boolean getSomeFlag() {
        return someFlag;
    }

    public void setSomeFlag(boolean value) {
        someFlag = value;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        compound.putBoolean("SomeFlag", someFlag);
        return compound;
    }

    @Override
    public void deserializeNBT(CompoundNBT compound) {
        someFlag = compound.getBoolean("SomeFlag");
    }
}
