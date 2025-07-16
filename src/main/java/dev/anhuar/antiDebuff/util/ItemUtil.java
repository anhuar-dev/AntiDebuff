package dev.anhuar.antiDebuff.util;

/*
 * ========================================================
 * AntiDebuff - ItemUtil.java
 *
 * @author Anhuar Ruiz | Anhuar Dev | myclass
 * @web https://anhuar.dev
 * @date 15/07/25
 *
 * License: MIT License - See LICENSE file for details.
 * Copyright (c) 2025 Anhuar Dev. All rights reserved.
 * ========================================================
 */

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemUtil {

    public static ItemStack createItem(Material material, String displayName) {
        return createItem(material, 1, displayName, null);
    }

    public static ItemStack createItem(Material material, String displayName, String... lore) {
        return createItem(material, 1, displayName, Arrays.asList(lore));
    }

    public static ItemStack createItem(Material material, int amount, String displayName) {
        return createItem(material, amount, displayName, null);
    }

    public static ItemStack createItem(Material material, int amount, String displayName, List<String> lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            if (displayName != null && !displayName.isEmpty()) {
                meta.setDisplayName(ColorUtil.format(displayName));
            }

            if (lore != null && !lore.isEmpty()) {
                List<String> coloredLore = new ArrayList<>();
                for (String line : lore) {
                    coloredLore.add(ColorUtil.format(line));
                }
                meta.setLore(coloredLore);
            }

            item.setItemMeta(meta);
        }

        return item;
    }

    public static ItemStack createEnchantedItem(Material material, String displayName, Enchantment enchantment, int level) {
        ItemStack item = createItem(material, displayName);
        item.addUnsafeEnchantment(enchantment, level);
        return item;
    }

    public static ItemStack createGlowingItem(Material material, String displayName, String... lore) {
        ItemStack item = createItem(material, displayName, lore);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.addEnchant(Enchantment.UNBREAKING, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }

        return item;
    }

    public static ItemStack createSkull(String playerName, String displayName, String... lore) {
        ItemStack skull = createItem(Material.PLAYER_HEAD, displayName, lore);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();

        if (skullMeta != null) {
            skullMeta.setOwner(playerName);
            skull.setItemMeta(skullMeta);
        }

        return skull;
    }

    public static void setDisplayName(ItemStack item, String displayName) {
        if (item != null && displayName != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ColorUtil.format(displayName));
                item.setItemMeta(meta);
            }
        }
    }

    public static void setLore(ItemStack item, String... lore) {
        setLore(item, Arrays.asList(lore));
    }

    public static void setLore(ItemStack item, List<String> lore) {
        if (item != null && lore != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                List<String> coloredLore = new ArrayList<>();
                for (String line : lore) {
                    coloredLore.add(ColorUtil.format(line));
                }
                meta.setLore(coloredLore);
                item.setItemMeta(meta);
            }
        }
    }

    public static void addLore(ItemStack item, String... newLore) {
        if (item != null && newLore != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                List<String> currentLore = meta.getLore();
                if (currentLore == null) {
                    currentLore = new ArrayList<>();
                }

                for (String line : newLore) {
                    currentLore.add(ColorUtil.format(line));
                }

                meta.setLore(currentLore);
                item.setItemMeta(meta);
            }
        }
    }

    public static void setPersistentData(ItemStack item, JavaPlugin plugin, String key, String value) {
        if (item != null && plugin != null && key != null && value != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, value);
                item.setItemMeta(meta);
            }
        }
    }

    public static void setPersistentData(ItemStack item, JavaPlugin plugin, String key, int value) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.INTEGER, value);
                item.setItemMeta(meta);
            }
        }
    }

    public static void setPersistentData(ItemStack item, JavaPlugin plugin, String key, boolean value) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.BYTE, (byte) (value ? 1 : 0));
                item.setItemMeta(meta);
            }
        }
    }

    public static void setPersistentData(ItemStack item, JavaPlugin plugin, String key, double value) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.DOUBLE, value);
                item.setItemMeta(meta);
            }
        }
    }

    public static String getPersistentDataString(ItemStack item, JavaPlugin plugin, String key) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                return meta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.STRING);
            }
        }
        return null;
    }

    public static Integer getPersistentDataInt(ItemStack item, JavaPlugin plugin, String key) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                return meta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.INTEGER);
            }
        }
        return null;
    }

    public static Boolean getPersistentDataBoolean(ItemStack item, JavaPlugin plugin, String key) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                Byte value = meta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.BYTE);
                return value != null ? value == 1 : null;
            }
        }
        return null;
    }

    public static Double getPersistentDataDouble(ItemStack item, JavaPlugin plugin, String key) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                return meta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.DOUBLE);
            }
        }
        return null;
    }

    public static boolean hasPersistentData(ItemStack item, JavaPlugin plugin, String key) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                return meta.getPersistentDataContainer().has(namespacedKey);
            }
        }
        return false;
    }

    public static void removePersistentData(ItemStack item, JavaPlugin plugin, String key) {
        if (item != null && plugin != null && key != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                meta.getPersistentDataContainer().remove(namespacedKey);
                item.setItemMeta(meta);
            }
        }
    }

    public static PersistentDataContainer getPersistentDataContainer(ItemStack item) {
        if (item != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                return meta.getPersistentDataContainer();
            }
        }
        return null;
    }

    public static void hideItemFlags(ItemStack item, ItemFlag... flags) {
        if (item != null) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.addItemFlags(flags);
                item.setItemMeta(meta);
            }
        }
    }

    public static void hideAllItemFlags(ItemStack item) {
        hideItemFlags(item, ItemFlag.values());
    }

    public static boolean isValidItem(ItemStack item) {
        return item != null && item.getType() != Material.AIR;
    }

    public static boolean hasDisplayName(ItemStack item) {
        return isValidItem(item) && item.getItemMeta() != null && item.getItemMeta().hasDisplayName();
    }

    public static boolean hasLore(ItemStack item) {
        return isValidItem(item) && item.getItemMeta() != null && item.getItemMeta().hasLore();
    }

    public static ItemStack createBarrier(String displayName, String... lore) {
        return createItem(Material.BARRIER, displayName, lore);
    }

    public static ItemStack createFiller(Material material) {
        ItemStack filler = new ItemStack(material);
        ItemMeta meta = filler.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(" ");
            filler.setItemMeta(meta);
        }
        return filler;
    }

    public static ItemStack createGlassFiller(String color) {
        Material glass;
        switch (color.toLowerCase()) {
            case "white":
                glass = Material.WHITE_STAINED_GLASS_PANE;
                break;
            case "black":
                glass = Material.BLACK_STAINED_GLASS_PANE;
                break;
            case "red":
                glass = Material.RED_STAINED_GLASS_PANE;
                break;
            case "green":
                glass = Material.GREEN_STAINED_GLASS_PANE;
                break;
            case "blue":
                glass = Material.BLUE_STAINED_GLASS_PANE;
                break;
            case "yellow":
                glass = Material.YELLOW_STAINED_GLASS_PANE;
                break;
            case "orange":
                glass = Material.ORANGE_STAINED_GLASS_PANE;
                break;
            case "purple":
                glass = Material.PURPLE_STAINED_GLASS_PANE;
                break;
            case "pink":
                glass = Material.PINK_STAINED_GLASS_PANE;
                break;
            case "gray":
                glass = Material.GRAY_STAINED_GLASS_PANE;
                break;
            default:
                glass = Material.GLASS_PANE;
                break;
        }
        return createFiller(glass);
    }

    public static ItemStack createItemWithData(Material material, String displayName, JavaPlugin plugin, String dataKey, String dataValue, String... lore) {
        ItemStack item = createItem(material, displayName, lore);
        setPersistentData(item, plugin, dataKey, dataValue);
        return item;
    }
}