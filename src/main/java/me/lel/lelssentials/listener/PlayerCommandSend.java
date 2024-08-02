package me.lel.lelssentials.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class PlayerCommandSend implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerCommandSend(PlayerCommandSendEvent event) {
        event.getCommands().removeIf(cmd -> cmd.contains(":"));
    }
}

