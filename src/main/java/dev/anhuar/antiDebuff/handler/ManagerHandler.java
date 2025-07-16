package dev.anhuar.antiDebuff.handler;

/*
 * ========================================================
 * AntiDebuff - ManagerHandler.java
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
import dev.anhuar.antiDebuff.manager.PlayerDataManager;
import lombok.Getter;

@Getter
public class ManagerHandler {

    private final AntiDebuff plugin;

    private PlayerDataManager playerDataManager;

    public ManagerHandler(AntiDebuff plugin) {
        this.plugin = plugin;
        registerManager();
    }

    public void registerManager() {
        this.playerDataManager = new PlayerDataManager();
    }
}