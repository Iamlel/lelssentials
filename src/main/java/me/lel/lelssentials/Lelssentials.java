package me.lel.lelssentials;

import me.lel.lelssentials.command.*;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("SpellCheckingInspection")
public final class Lelssentials extends JavaPlugin {
    @Override
    public void onEnable() {
        ClearChat.build().register(this);
        Feed.build().register(this);
        FlySpeed.build().register(this);
        GMC.build().register(this);
        GMS.build().register(this);
        Heal.build().register(this);
        WalkSpeed.build().register(this);

        this.getLogger().info("lelssentials plugin has been enabled!");

    }

    @Override
    public void onDisable() {
        this.getLogger().info("lelssentials plugin has been disabled!");
    }


}
