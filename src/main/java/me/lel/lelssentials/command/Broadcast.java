package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import me.lel.lelssentials.Permission;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;

public final class Broadcast {
    public static CommandAPICommand build() {
        return new CommandAPICommand("broadcast")
                .withUsage("/broadcast <message>")
                .withShortDescription("Broadcast a message.")
                .withFullDescription( "Broadcast a message with MiniMessage formats.")
                .withPermission(Permission.BROADCAST)
                .withArguments(new GreedyStringArgument("message"))
                .executes((sender, args) -> {
                    String message = (String) args.get("message");
                    assert message != null;
                    Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize(message));
                });
    }
}
