package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@SuppressWarnings("SpellCheckingInspection")
public final class ClearChat {
    public static CommandAPICommand build() {
        return new CommandAPICommand("clearchat")
                .withUsage("/clearchat")
                .withShortDescription("Clear the chat.")
                .withFullDescription( "Clear the chat.")
                .withPermission(Permission.CLEARCHAT)
                .withOptionalArguments(new PlayerArgument("target"))
                .executesPlayer((Player player, CommandArguments args) -> {
                    Player target = (Player) args.get("target");
                    if (target == null) {
                        Bukkit.getOnlinePlayers().forEach(ClearChat::clearChat);
                    } else {
                        clearChat(target);
                        if (target != player) {
                            Utils.sendMessage(player, "Cleared " + target.getName() + "'s chat!", true);
                        }
                    }
                });
    }

    private static void clearChat(Player player) {
        for (int i = 0; i < 100; i++) {
            player.sendMessage(Component.empty());
        }
        Utils.sendMessage(player, "Cleared the chat!", true);
    }
}
