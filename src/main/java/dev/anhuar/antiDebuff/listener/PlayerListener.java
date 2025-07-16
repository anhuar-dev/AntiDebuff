package dev.anhuar.antiDebuff.listener;

/*
 * ========================================================
 * AntiDebuff - PlayerListener.java
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
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final AntiDebuff plugin = AntiDebuff.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            plugin.getManagerHandler().getPlayerDataManager().load(event.getPlayer().getUniqueId());
        });

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            plugin.getManagerHandler().getPlayerDataManager().save(event.getPlayer().getUniqueId());
        });

    }
    
}