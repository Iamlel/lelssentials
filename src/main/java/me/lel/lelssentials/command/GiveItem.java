package me.lel.lelssentials.command;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.ItemStackArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import me.lel.lelssentials.Permission;
import me.lel.lelssentials.Utils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public final class GiveItem {
    @SuppressWarnings("SpellCheckingInspection")
    public static CommandAPICommand build() {
        return new CommandAPICommand("giveitem")
                .withAliases("i")
                .withUsage("/giveitem <item> [<amount>]")
                .withShortDescription("Give yourself an item.")
                .withFullDescription( "Give yourself an item.")
                .withPermission(Permission.GIVEITEM)
                .withArguments(new ItemStackArgument("item"))
                .withOptionalArguments(new IntegerArgument("amount", 1))
                .executesPlayer((Player player, CommandArguments args) -> {
                    ItemStack i = (ItemStack) args.get("item");
                    int amount = (int) args.getOrDefault("amount", 1);

                    assert i != null;
                    i.setAmount(amount);

                    HashMap<Integer, ItemStack> items = player.getInventory().addItem(i);
                    Utils.sendMessage(player, "Gave you " + amount + " of " + i + " !", true);
                    if (!items.isEmpty()) {
                        // since we are only adding 1 type of item, the hashmap should only contain 1 element.
                        Utils.sendMessage(player, "Could not add " + items.get(1).getAmount() + " of " + i + " !", false);
                    }
                });
    }
}
