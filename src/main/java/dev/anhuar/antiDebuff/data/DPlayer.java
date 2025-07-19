package dev.anhuar.antiDebuff.data;

/*
 * ========================================================
 * AntiDebuff - DPlayer.java
 *
 * @author Anhuar Ruiz | Anhuar Dev | myclass
 * @web https://anhuar.dev
 * @date 15/07/25
 *
 * License: MIT License - See LICENSE file for details.
 * Copyright (c) 2025 Anhuar Dev. All rights reserved.
 * ========================================================
 */

import lombok.Data;

@Data
public class DPlayer {

    private String name;
    private boolean activeEffect = false;
    private long timeRemaining = 0L;

}