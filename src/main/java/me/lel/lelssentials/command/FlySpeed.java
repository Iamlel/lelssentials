package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import org.bukkit.entity.Player;

public class FlySpeed {
    public static CommandAPICommand build() {
        return new CommandAPICommand("flyspeed")
                .withUsage("/flyspeed [<target>|<speed>]")
                .withShortDescription("Set your flyspeed.")
                .withFullDescription( "Set your flyspeed to a value between -10 and 10.")
                .withPermission(Permission.FLYSPEED)
                .withOptionalArguments(new IntegerArgument("speed", -10, 10), new PlayerArgument("target"))
                .executesPlayer((Player player, CommandArguments args) -> {
                    Player target = (Player) args.getOrDefault("target", player);
                    int speed = (int) args.getOrDefault("speed", 1);
                    speed = (speed > 10) ? 10 : Math.max(speed, -10);


                    target.setFlySpeed((float) speed / 10);
                    if (target != player) {
                        Utils.sendMessage(player, "Changed " + target.getName() + "'s flyspeed to " + speed + "!", true);
                    }
                    Utils.sendMessage(target, "Changed your flyspeed to " + speed + "!", true);
                });
    }
}
