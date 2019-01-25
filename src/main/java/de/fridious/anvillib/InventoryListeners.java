package de.fridious.anvillib;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

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

public class InventoryListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        for(AnvilGui anvilGui : AnvilLib.ANVIL_GUIS) {
            if(anvilGui.getInventory().equals(event.getInventory())) {
                anvilGui.onClick(event);
            }
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        for(AnvilGui anvilGui : AnvilLib.ANVIL_GUIS) {
            if(anvilGui.getInventory().equals(event.getInventory())) {
                anvilGui.onOpen(event);
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        for(AnvilGui anvilGui : AnvilLib.ANVIL_GUIS) {
            if(anvilGui.getInventory().equals(event.getInventory())) {
                if(anvilGui.isClearItemsOnClose()) anvilGui.getInventory().clear();
                anvilGui.onClose(event);
            }
        }
    }

}