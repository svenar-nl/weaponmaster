package io.github.greatericontop.weaponmaster.DragonSword;

/*
    Copyright (C) 2021 greateric.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import io.github.greatericontop.weaponmaster.utils.PaperUtils;
import io.github.greatericontop.weaponmaster.utils.Util;
import io.github.greatericontop.weaponmaster.WeaponMasterMain;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DragonItemListener implements Listener {

    // triangular distribution parameters
    // on average, if the ability triggers, deal 35% more damage
    private final double A = 0.0;
    private final double B = 0.8;
    private final double C = 0.25;

    private final WeaponMasterMain plugin;
    private final Util util;
    public DragonItemListener(WeaponMasterMain plugin) {
        this.plugin = plugin;
        util = new Util(plugin);
    }

    private double triangular(double random) {
        // triangular distribution code stolen from https://stackoverflow.com/questions/33220176/triangular-distribution-in-java
        double F = (C - A) / (B - A);
        if (random < F) {
            return A + Math.sqrt(random * (B - A) * (C - A));
        } else {
            return B - Math.sqrt((1-random) * (B - A) * (B - C));
        }
    }

    @EventHandler(priority = EventPriority.HIGH) // runs at the end (before life helmet though) to stack bonuses
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() != EntityType.PLAYER) { return; }
        Player player = (Player)event.getDamager();
        if (!util.checkForDragonSword(player.getInventory().getItemInMainHand())) { return; }
        if (!player.hasPermission("weaponmaster.dragonsword.use")) {
            player.sendMessage("§3Sorry, you cannot use this item yet. You need the permission §4weaponmaster.dragonsword.use§3.");
            return;
        }
        // increment damage
        if (Math.random() < 0.5) {
            double multiplier = triangular(Math.random());
            event.setDamage(event.getDamage()*(1+multiplier));
            PaperUtils.sendActionBar(player, String.format("§3Hit increased by §4%.1f%% §3for §4%.1f§3.", multiplier*100, event.getDamage()));
            player.sendMessage(String.format("§3Hit increased by §4%.1f%% §3for §4%.1f§3.", multiplier*100, event.getDamage()));
        }
    }

}