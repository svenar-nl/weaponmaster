package io.github.greatericontop.weaponmaster.ShreddedAxe;

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

import io.github.greatericontop.weaponmaster.WeaponMasterMain;
import io.github.greatericontop.weaponmaster.utils.MathHelper;
import io.github.greatericontop.weaponmaster.utils.TrueDamageHelper;
import io.github.greatericontop.weaponmaster.utils.Util;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class ShreddedListener implements Listener {
    private final Map<UUID, Integer> zombieCount = new HashMap<>();
    private final Set<UUID> allZombies = new HashSet<>();
    private final int SURVIVAL_DURATION = 700;
    private final double NEW_MAX_HP = 50.0;
    private final WeaponMasterMain plugin;
    private final Util util;
    public ShreddedListener(WeaponMasterMain plugin) {
        this.plugin = plugin;
        util = new Util(plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDeath(EntityDeathEvent event) {
        if (allZombies.contains(event.getEntity().getUniqueId())) {
            event.getEntity().setCustomName("§2Zombie");
            event.setDroppedExp(0);
            event.getDrops().clear();
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() != EntityType.PLAYER) { return; }
        Player player = (Player) event.getDamager();
        if (!util.checkForShreddedAxe(player.getInventory().getItemInMainHand())) { return; }
        if (!player.hasPermission("weaponmaster.shreddedaxe.use")) {
            player.sendMessage("§3Sorry, you cannot use this item yet. You need the permission §4weaponmaster.shreddedaxe.use§3.");
            return;
        }
        if (zombieCount.getOrDefault(player.getUniqueId(), 0) >= 10) {
            return;
        }
        zombieCount.put(player.getUniqueId(), zombieCount.getOrDefault(player.getUniqueId(), 0) + 1);
        LivingEntity victim = (LivingEntity) event.getEntity();
        Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE, true);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, SURVIVAL_DURATION*5, 0, true));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, SURVIVAL_DURATION*5, 0, true));
        zombie.setTarget(victim);
        zombie.setCanPickupItems(false);
        zombie.setCustomName(String.format("%s§7's §2Zombie", player.getDisplayName()));
        zombie.setCustomNameVisible(true);
        zombie.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(64.0);
        zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(NEW_MAX_HP);
        zombie.setHealth(NEW_MAX_HP);
        allZombies.add(zombie.getUniqueId());
        new BukkitRunnable() {
            int ticks = 0;
            public void run() {
                ticks++;
                if (zombie.isDead()) {
                    cancel();
                    zombieCount.put(player.getUniqueId(), zombieCount.get(player.getUniqueId()) - 1);
                    allZombies.remove(zombie.getUniqueId());
                    return;
                }
                double healthPercent = zombie.getHealth() / NEW_MAX_HP * 100;
                zombie.setCustomName(String.format("%s§7's §2Zombie §7- §%s%.0f%%", player.getDisplayName(), MathHelper.getColor(healthPercent), healthPercent));
                if (zombie.getTarget() != victim) {
                    zombie.setTarget(victim);
                }
                if (ticks >= SURVIVAL_DURATION && ticks % 20 == 0) {
                    TrueDamageHelper.dealTrueDamage(zombie,4.0, player);
                    zombie.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, zombie.getLocation().add(0.0, 0.0, 1.0), 10);
                }
            }
        }.runTaskTimer(plugin, 1L, 1L);
    }

}