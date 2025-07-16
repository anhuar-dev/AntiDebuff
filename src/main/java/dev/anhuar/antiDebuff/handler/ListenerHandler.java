package dev.anhuar.antiDebuff.handler;

/*
 * ========================================================
 * AntiDebuff - ListenerHandler.java
 *
 * @author Anhuar Ruiz | Anhuar Dev | myclass
 * @web https://anhuar.dev
 * @date 15/07/25
 *
 * License: MIT License - See LICENSE file for details.
 * Copyright (c) 2025 Anhuar Dev. All rights reserved.
 * ========================================================
 */

import dev.anhuar.antiDebuff.AntiDebuff;
import dev.anhuar.antiDebuff.listener.PlayerListener;
import org.bukkit.event.Listener;

import java.util.Arrays;
import java.util.List;

public class ListenerHandler {

    private final AntiDebuff plugin;

    public ListenerHandler(AntiDebuff plugin) {
        this.plugin = plugin;
        registerListeners();
    }

    private void registerListeners() {
        List<Listener> listeners = Arrays.asList(
                new PlayerListener()
        );

        for (Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}