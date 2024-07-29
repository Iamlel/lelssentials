package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class Heal {
    public static CommandAPICommand build() {
        return new CommandAPICommand("heal")
                .withUsage("/heal [<target>]")
                .withShortDescription("Heal yourself.")
                .withFullDescription( "Heal yourself or a target.")
                .withPermission(Permission.HEAL)
                .withOptionalArguments(new PlayerArgument("target"))
                .executesPlayer((Player player, CommandArguments args) -> {
                    Player target = (Player) args.getOrDefault("target", player);
                    AttributeInstance maxHealth = target.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                    assert maxHealth != null;

                    target.setHealth(maxHealth.getValue());
                    if (target != player) {
                        Utils.sendMessage(player, "Healed " + target.getName() + "!", true);
                    }
                    Utils.sendMessage(target, "Healed you!", true);
                });
    }
}
