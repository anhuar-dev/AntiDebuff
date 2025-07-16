package dev.anhuar.antiDebuff.command;

/*
 * ========================================================
 * AntiDebuff - AdminCommand.java
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
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command("antidebuff")
@CommandPermission("antidebuff.admin")
public class AdminCommand {

    private final AntiDebuff plugin = AntiDebuff.getInstance();

    @DefaultFor("antidebuff")
    public void onDefaultCommand() {
    }

    @Subcommand("give")
    public void onGiveCommand() {
    }

    @Subcommand("effect add")
    public void onAddCommand() {
    }

    @Subcommand("effect remove")
    public void onRemoveCommand() {
    }

}