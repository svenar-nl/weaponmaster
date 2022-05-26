package io.github.greatericontop.weaponmaster.dragon_manager;

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
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class FightManager implements Listener {

    public EnderDragon currentlyActiveDragon = null;
    public double damageDealtToDragonThroughExplosions = 0.0;
    private final WeaponMasterMain plugin;
    public FightManager(WeaponMasterMain plugin) {
        this.plugin = plugin;
    }


    @EventHandler(priority = EventPriority.NORMAL)
    public void onDragonSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof EnderDragon)) { return; }
        // TODO: only trigger sometimes, maybe 20%
        this.currentlyActiveDragon = (EnderDragon) entity;
        buffDragon(currentlyActiveDragon);
        this.damageDealtToDragonThroughExplosions = 0.0;
        new MidFightTasks(plugin, currentlyActiveDragon).startFightTasks();
    }

    public void buffDragon(EnderDragon dragon) {
        double DRAGON_MAX_HP = 700.0;
        dragon.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(DRAGON_MAX_HP); // up from 200, the default
        dragon.setHealth(DRAGON_MAX_HP);
        dragon.setCustomName("§cWeaponMaster Dragon");
        dragon.setCustomNameVisible(true);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onDragonExplosionDamage(EntityDamageEvent event) {
        if (currentlyActiveDragon == null) { return; }
        if (!event.getEntity().getUniqueId().equals(currentlyActiveDragon.getUniqueId())) { return; }
        if (!(event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) { return; }
        if (damageDealtToDragonThroughExplosions >= 80.0) {
            event.setDamage(event.getDamage() * 0.1);
        } else if (damageDealtToDragonThroughExplosions + event.getDamage() >= 80.0) {
            double fullDamage = 80.0 - damageDealtToDragonThroughExplosions;
            event.setDamage(fullDamage + 0.1 * (event.getDamage()-fullDamage));
        }
        damageDealtToDragonThroughExplosions += event.getFinalDamage();
    }

}
