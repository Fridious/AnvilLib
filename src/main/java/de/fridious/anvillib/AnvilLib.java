package de.fridious.anvillib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import java.util.LinkedList;
import java.util.List;

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

public class AnvilLib {

    public static final ReflectionAnvil REFLECTION_ANVIL = new ReflectionAnvil();
    public static final List<AnvilGui> ANVIL_GUIS = new LinkedList<>();
    private Plugin plugin;

    private AnvilLib(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(new InventoryListeners(), plugin);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public AnvilGui registerAnvilGui(AnvilGui anvilGui) {
        ANVIL_GUIS.add(anvilGui);
        return anvilGui;
    }

    public static AnvilLib create(Plugin plugin) {
        return new AnvilLib(plugin);
    }
}