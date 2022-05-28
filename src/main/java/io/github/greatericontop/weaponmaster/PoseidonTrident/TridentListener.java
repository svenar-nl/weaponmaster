package io.github.greatericontop.weaponmaster.PoseidonTrident;

import io.github.greatericontop.weaponmaster.WeaponMasterMain;
import io.github.greatericontop.weaponmaster.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class TridentListener implements Listener {

    private final WeaponMasterMain plugin;
    private final Util util;
    public TridentListener(WeaponMasterMain plugin) {
        this.plugin = plugin;
        util = new Util(plugin);
    }

    public void regTridentRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (!player.hasPermission("weaponmaster.poseidontrident.use")) { continue; }
                    if (!util.checkForPoseidonTrident(player.getInventory().getItemInMainHand())) { continue; }
                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 39, 0));
                    ItemStack it = player.getInventory().getItemInMainHand();
                    ItemMeta im = it.getItemMeta();
                    im.removeEnchant(Enchantment.RIPTIDE);
                    it.setItemMeta(im);
                    if (player.isInWater() && Math.random() < 0.015) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 39, 0));
                    }
                }
            }
        }.runTaskTimer(plugin, 200L, 5L);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void tridentThrow(ProjectileLaunchEvent event) {
        if (!(event.getEntity().getShooter() instanceof Player)) { return; }
        Player player = (Player) event.getEntity().getShooter();
        if (!util.checkForPoseidonTrident(player.getInventory().getItemInMainHand())) { return; }
        if (!player.hasPermission("weaponmaster.poseidontrident.use")) {
            player.sendMessage("§3Sorry, you cannot use this item yet. You need the permission §4weaponmaster.poseidontrident.use§3.");
            return;
        }
        player.removePotionEffect(PotionEffectType.CONDUIT_POWER);
        player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, player.getEyeLocation().add(player.getEyeLocation().getDirection().multiply(0.9)), 15);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onProjHit(ProjectileHitEvent event) {
        if (!(event.getEntity().getShooter() instanceof Player)) { return; }
        Player player = (Player) event.getEntity().getShooter();
        if (!util.checkForPoseidonTrident(player.getInventory().getItemInMainHand())) { return; }
        if (!player.hasPermission("weaponmaster.poseidontrident.use")) {
            player.sendMessage("§3Sorry, you cannot use this item yet. You need the permission §4weaponmaster.poseidontrident.use§3.");
            return;
        }
        if (player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.CHANNELING) &&
                !(player.getWorld().isThundering()) &&
                Math.random() < 0.15) {
            event.getHitEntity().getWorld().spawnEntity(event.getHitEntity().getLocation(), EntityType.LIGHTNING);
        }
    }
}
