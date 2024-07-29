package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import org.bukkit.entity.Player;

public class Feed {
    public static CommandAPICommand build() {
        return new CommandAPICommand("feed")
                .withUsage("/feed [<target>]")
                .withShortDescription("Feed yourself.")
                .withFullDescription( "Feed yourself or a target.")
                .withPermission(Permission.FEED)
                .withOptionalArguments(new PlayerArgument("target"))
                .executesPlayer((Player player, CommandArguments args) -> {
                    Player target = (Player) args.getOrDefault("target", player);
                    target.setFoodLevel(20); // max food
                    if (target != player) {
                        Utils.sendMessage(player, "Fed " + target.getName() + "!", true);
                    }
                    Utils.sendMessage(target, "Fed you!", true);
                });
    }
}
