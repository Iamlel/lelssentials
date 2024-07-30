package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public final class GMS {
    public static CommandAPICommand build() {
        return new CommandAPICommand("gms")
                .withUsage("/gms [<target>]")
                .withShortDescription("Go into survival.")
                .withFullDescription( "Sets your gamemode or your target's gamemode to survival.")
                .withPermission(Permission.GMS)
                .withOptionalArguments(new PlayerArgument("target"))
                .executesPlayer((Player player, CommandArguments args) -> {
                    Player target = (Player) args.getOrDefault("target", player);
                    target.setGameMode(GameMode.SURVIVAL);
                    if (target != player) {
                        Utils.sendMessage(player, "Set " + target.getName() + "'s gamemode to survival!", true);
                    }
                    Utils.sendMessage(target, "Set your gamemode to survival!", true);
                });
    }
}
