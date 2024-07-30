package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import org.bukkit.entity.Player;

public final class WalkSpeed {
    public static CommandAPICommand build() {
        return new CommandAPICommand("walkspeed")
                .withUsage("/walkspeed [<target>|<speed>]")
                .withShortDescription("Set your walkspeed.")
                .withFullDescription( "Set your walkspeed to a value between -10 and 10.")
                .withPermission(Permission.WALKSPEED)
                .withOptionalArguments(new IntegerArgument("speed", -10, 10), new PlayerArgument("target"))
                .executesPlayer((Player player, CommandArguments args) -> {
                    Player target = (Player) args.getOrDefault("target", player);
                    int speed = (int) args.getOrDefault("speed", 2);

                    target.setWalkSpeed((float) speed / 10);
                    if (target != player) {
                        Utils.sendMessage(player, "Changed " + target.getName() + "'s walkspeed to " + speed + "!", true);
                    }
                    Utils.sendMessage(target, "Changed your walkspeed to " + speed + "!", true);
                });
    }
}
