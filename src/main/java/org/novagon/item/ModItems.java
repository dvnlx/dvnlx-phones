package org.novagon.item;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.novagon.DvnlxPhones;

public class ModItems {
    public static Item STANDARD_PHONE = registerItem("standard_phone", new Item(new FabricItemSettings().maxCount(1)));

    private static void addItemstoTabGroup(FabricItemGroupEntries entries){
        entries.add(STANDARD_PHONE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DvnlxPhones.MOD_ID, name), item);
    }
    public static void registerModItems(){
        DvnlxPhones.LOGGER.debug("Reg item for " + DvnlxPhones.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::addItemstoTabGroup);
    }
}
