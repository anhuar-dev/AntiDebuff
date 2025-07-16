package dev.anhuar.antiDebuff.handler;

/*
 * ========================================================
 * AntiDebuff - MongoHandler.java
 *
 * @author Anhuar Ruiz | Anhuar Dev | myclass
 * @web https://anhuar.dev
 * @date 15/07/25
 *
 * License: MIT License - See LICENSE file for details.
 * Copyright (c) 2025 Anhuar Dev. All rights reserved.
 * ========================================================
 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import dev.anhuar.antiDebuff.AntiDebuff;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.ChatColor;

@Getter
public class MongoHandler {

    private final AntiDebuff plugin;
    private final MongoClient mongoClient;
    private final MongoCollection<Document> players;

    public MongoHandler(AntiDebuff plugin) {
        this.plugin = plugin;
        String uri = plugin.getSetting().getConfig().getString("DATABASE.MONGO.URI", "mongodb://localhost:27017");
        String databaseName = plugin.getSetting().getConfig().getString("DATABASE.MONGO.DATABASE", "Antidebuff");
        String collectionName = plugin.getSetting().getConfig().getString("DATABASE.MONGO.COLLECTION", "players");

        this.mongoClient = MongoClients.create(uri);
        this.players = mongoClient.getDatabase(databaseName).getCollection(collectionName);

        plugin.getLogger().info(ChatColor.GREEN + "✓ Conexión con MongoDB establecida correctamente! " + ChatColor.GRAY + "(Base de datos: " + ChatColor.WHITE + databaseName + ChatColor.GRAY + ")");
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();

            plugin.getLogger().info(ChatColor.RED + "✗ Conexión con MongoDB cerrada correctamente.");
        }
    }
}