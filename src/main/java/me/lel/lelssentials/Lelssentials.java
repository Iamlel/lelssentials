package me.lel.lelssentials;

import me.lel.lelssentials.command.*;
import me.lel.lelssentials.listener.PlayerCommandSend;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("SpellCheckingInspection")
public final class Lelssentials extends JavaPlugin {
    @Override
    public void onEnable() {
        // commands
        Broadcast.build().register(this);
        ClearChat.build().register(this);
        Feed.build().register(this);
        FlySpeed.build().register(this);
        GiveItem.build().register(this);
        GMC.build().register(this);
        GMS.build().register(this);
        Heal.build().register(this);
        WalkSpeed.build().register(this);

        final PluginManager manager = this.getServer().getPluginManager();
        // events
        manager.registerEvents(new PlayerCommandSend(), this);

        this.getLogger().info("lelssentials plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("lelssentials plugin has been disabled!");
    }
}
