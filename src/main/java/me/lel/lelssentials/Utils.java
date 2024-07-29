package me.lel.lelssentials;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

public final class Utils {
    public static void sendMessage(Player player, String text, boolean status) {
        player.sendMessage(Component.text(text).color(TextColor.fromHexString(status ? "#55FF55" : "#FF5555")));
    }
}
