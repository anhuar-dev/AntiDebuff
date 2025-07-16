package dev.anhuar.antiDebuff.handler;

/*
 * ========================================================
 * AntiDebuff - CommandHandler.java
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
import dev.anhuar.antiDebuff.command.AdminCommand;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class CommandHandler {

    private final BukkitCommandHandler commandHandler;

    public CommandHandler(AntiDebuff plugin) {
        this.commandHandler = BukkitCommandHandler.create(plugin);
        commandHandler.registerDependency(AntiDebuff.class, plugin);

        registerCommands();
    }

    private void registerCommands() {
        commandHandler.register(new AdminCommand());
    }
}