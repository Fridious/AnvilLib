package de.fridious.anvillib;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/*
 * (C) Copyright 2019 AnvilLib
 *
 * @author Philipp Elvin Friedhoff
 * @since 25.01.19 18:51
 * @Website https://github.com/Fridious/AnvilLib
 *
 * The DKBans Project is under the Apache License, version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

public abstract class AnvilGui {

    private final Player player;
    private final Inventory inventory;
    private final Object container;
    private final int containerId;
    private boolean clearItemsOnClose;

    public AnvilGui(Player player) {
        this.player = player;
        this.container = AnvilLib.REFLECTION_ANVIL.newContainerAnvil(player);
        this.inventory = AnvilLib.REFLECTION_ANVIL.toBukkitInventory(container);
        this.containerId = AnvilLib.REFLECTION_ANVIL.getNextContainerId(player);
        this.clearItemsOnClose = true;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Object getContainer() {
        return container;
    }

    public int getContainerId() {
        return containerId;
    }

    public boolean isClearItemsOnClose() {
        return clearItemsOnClose;
    }

    public String getInput() {
        ItemStack itemStack = getInventory().getItem(AnvilSlot.OUTPUT);
        if(itemStack == null) return null;
        String input = itemStack.getItemMeta().hasDisplayName() ? itemStack.getItemMeta().getDisplayName() : " ";
        return input == null || input.equalsIgnoreCase(itemStack.getType().toString()) ? " " : input;
    }

    public void setClearItemsOnClose(boolean clearItemsOnClose) {
        this.clearItemsOnClose = clearItemsOnClose;
    }

    protected abstract void onOpen(InventoryOpenEvent event);
    protected abstract void onClick(InventoryClickEvent event);
    protected abstract void onClose(InventoryCloseEvent event);
}