package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public final class GMC {
    public static CommandAPICommand build() {
        return new CommandAPICommand("gmc")
                .withUsage("/gmc [<target>]")
                .withShortDescription("Go into creative.")
                .withFullDescription( "Sets your gamemode or your target's gamemode to creative.")
                .withPermission(Permission.GMC)
                .withOptionalArguments(new PlayerArgument("target"))
                .executesPlayer((Player player, CommandArguments args) -> {
                    Player target = (Player) args.getOrDefault("target", player);
                    target.setGameMode(GameMode.CREATIVE);
                    if (target != player) {
                        Utils.sendMessage(player, "Set " + target.getName() + "'s gamemode to creative!", true);
                    }
                    Utils.sendMessage(target, "Set your gamemode to creative!", true);
                });
    }
}
