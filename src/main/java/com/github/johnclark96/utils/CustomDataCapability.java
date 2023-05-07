package com.github.johnclark96.utils;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.common.util.Direction;

import javax.annotation.Nullable;

public class CustomDataCapability {
    @CapabilityInject(CustomData.class)
    public static Capability<CustomData> CUSTOM_DATA_CAPABILITY;

    public static class Storage implements Capability.IStorage<CustomData> {
        @Override
        public CompoundNBT writeNBT(Capability<CustomData> capability, CustomData instance, Direction side) {
            CompoundNBT compound = new CompoundNBT();
            compound.putBoolean("SomeFlag", instance.getSomeFlag());
            return compound;
        }

        @Override
        public void readNBT(Capability<CustomData> capability, CustomData instance, Direction side, INBT nbt) {

        }

//        @Override
//        public void readNBT(Capability<CustomData> capability, CustomData instance, Direction side, CompoundNBT nbt) {
//            instance.setSomeFlag(nbt.getBoolean("SomeFlag"));
//        }
//
//        @Nullable
//        @Override
//        public INBT writeNBT(Capability<CustomData> capability, CustomData instance, Direction side) {
//            return null;
//        }
    }

    public static class Provider implements ICapabilitySerializable<CompoundNBT> {
        private final CustomData data = new CustomData();

        @Override
        public CompoundNBT serializeNBT() {
            return data.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundNBT nbt) {
            data.deserializeNBT(nbt);
        }

        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction facing) {
            if (capability == CUSTOM_DATA_CAPABILITY) {
                return LazyOptional.of(() -> data).cast();
            }
            return LazyOptional.empty();
        }
    }
}
