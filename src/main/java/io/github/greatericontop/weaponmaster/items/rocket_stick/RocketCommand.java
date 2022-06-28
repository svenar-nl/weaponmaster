package io.github.greatericontop.weaponmaster.items.rocket_stick;

/*
 * WeaponMaster Copyright (C) 2021-present greateric.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty  of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.greatericontop.weaponmaster.util.Util;

public class RocketCommand implements CommandExecutor {

    private final Util util;
    public RocketCommand() {
        util = new Util(null);
    }

    private void sendInfo(CommandSender to) {
        to.sendMessage("§6----------------------------------------");
        to.sendMessage("§2§lRocket Stick");
        to.sendMessage("§e§oby greateric");
        to.sendMessage("§3Use §2/rocketstick give§3 to give yourself the item.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendInfo(sender);
            return true;
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("give")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§3Sorry, players only.");
                return true;
            }
            ItemStack rocket = util.generateMeta(util.ROCKET_STICK_LORE, util.ROCKET_STICK_NAME, Material.STICK);
            rocket.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
            ((Player) sender).getInventory().addItem(rocket);
            sender.sendMessage("§7Gave you §f[" + util.ROCKET_STICK_NAME + "§f]§7.");
            return true;
        }
        return false;
    }
}
