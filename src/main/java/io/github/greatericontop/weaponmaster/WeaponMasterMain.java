package io.github.greatericontop.weaponmaster;

import io.github.greatericontop.weaponmaster.dragon_manager.FightManager;
import io.github.greatericontop.weaponmaster.items.anduril.AndurilCommand;
import io.github.greatericontop.weaponmaster.items.anduril.AndurilItemListener;
import io.github.greatericontop.weaponmaster.items.anduril.AndurilRecipe;
import io.github.greatericontop.weaponmaster.items.artemisBow.ArtemisCommand;
import io.github.greatericontop.weaponmaster.items.artemisBow.ArtemisItemListener;
import io.github.greatericontop.weaponmaster.items.artemisBow.ArtemisRecipe;
import io.github.greatericontop.weaponmaster.items.assaultRifle.AssaultCommand;
import io.github.greatericontop.weaponmaster.items.assaultRifle.AssaultListener;
import io.github.greatericontop.weaponmaster.items.atomBomb.AtomCommand;
import io.github.greatericontop.weaponmaster.items.atomBomb.AtomItemListener;
import io.github.greatericontop.weaponmaster.items.caveman_sword.CavemanCommand;
import io.github.greatericontop.weaponmaster.items.caveman_sword.CavemanItemListener;
import io.github.greatericontop.weaponmaster.items.caveman_sword.CavemanRecipe;
import io.github.greatericontop.weaponmaster.items.copper_sword.CopperSwordCommand;
import io.github.greatericontop.weaponmaster.items.copper_sword.CopperSwordListener;
import io.github.greatericontop.weaponmaster.items.copper_sword.CopperSwordRecipe;
import io.github.greatericontop.weaponmaster.items.death_scythe.ScytheCommand;
import io.github.greatericontop.weaponmaster.items.death_scythe.ScytheItemListener;
import io.github.greatericontop.weaponmaster.items.death_scythe.ScytheRecipe;
import io.github.greatericontop.weaponmaster.items.dragon_armor.DragonArmorCommand;
import io.github.greatericontop.weaponmaster.items.dragon_armor.DragonArmorListener;
import io.github.greatericontop.weaponmaster.items.dragon_armor.DragonArmorRecipe;
import io.github.greatericontop.weaponmaster.items.dragon_elytra.DragonElytraUpgradeListener;
import io.github.greatericontop.weaponmaster.items.dragon_elytra.ElytraCommand;
import io.github.greatericontop.weaponmaster.items.dragon_elytra.ElytraItemListener;
import io.github.greatericontop.weaponmaster.items.dragon_sword.DragonCommand;
import io.github.greatericontop.weaponmaster.items.dragon_sword.DragonItemListener;
import io.github.greatericontop.weaponmaster.items.dragon_sword.DragonRecipe;
import io.github.greatericontop.weaponmaster.items.dragon_sword.DragonUpgradeListener;
import io.github.greatericontop.weaponmaster.items.excalibur.ExcaliburCommand;
import io.github.greatericontop.weaponmaster.items.excalibur.ExcaliburItemListener;
import io.github.greatericontop.weaponmaster.items.excalibur.ExcaliburRecipe;
import io.github.greatericontop.weaponmaster.items.exodus.ExodusCommand;
import io.github.greatericontop.weaponmaster.items.exodus.ExodusItemListener;
import io.github.greatericontop.weaponmaster.items.exodus.ExodusRecipe;
import io.github.greatericontop.weaponmaster.items.fireball.FireballCommand;
import io.github.greatericontop.weaponmaster.items.fireball.FireballListener;
import io.github.greatericontop.weaponmaster.items.fireball.FireballRecipe;
import io.github.greatericontop.weaponmaster.items.helios.HeliosCommand;
import io.github.greatericontop.weaponmaster.items.helios.HeliosItemListener;
import io.github.greatericontop.weaponmaster.items.helios.HeliosRecipe;
import io.github.greatericontop.weaponmaster.items.hermes_boots.HermesCommand;
import io.github.greatericontop.weaponmaster.items.hermes_boots.HermesItemListener;
import io.github.greatericontop.weaponmaster.items.hermes_boots.HermesRecipe;
import io.github.greatericontop.weaponmaster.items.life_helmet.LifeHelmetCommand;
import io.github.greatericontop.weaponmaster.items.life_helmet.LifeHelmetListener;
import io.github.greatericontop.weaponmaster.items.life_helmet.LifeHelmetRecipe;
import io.github.greatericontop.weaponmaster.items.miner_blessing.MinerCommand;
import io.github.greatericontop.weaponmaster.items.miner_blessing.MinerItemListener;
import io.github.greatericontop.weaponmaster.items.miner_blessing.MinerRecipe;
import io.github.greatericontop.weaponmaster.items.napalm_missile.NapalmCommand;
import io.github.greatericontop.weaponmaster.items.napalm_missile.NapalmItemListener;
import io.github.greatericontop.weaponmaster.items.netherite_staff.NetheriteStaffCommand;
import io.github.greatericontop.weaponmaster.items.netherite_staff.NetheriteStaffListener;
import io.github.greatericontop.weaponmaster.items.netherite_staff.NetheriteStaffRecipe;
import io.github.greatericontop.weaponmaster.items.ninja_bow.NinjaCommand;
import io.github.greatericontop.weaponmaster.items.ninja_bow.NinjaItemListener;
import io.github.greatericontop.weaponmaster.items.ninja_bow.NinjaRecipe;
import io.github.greatericontop.weaponmaster.items.pilot_sword.PilotCommand;
import io.github.greatericontop.weaponmaster.items.pilot_sword.PilotItemListener;
import io.github.greatericontop.weaponmaster.items.poseidon_trident.TridentCommand;
import io.github.greatericontop.weaponmaster.items.poseidon_trident.TridentListener;
import io.github.greatericontop.weaponmaster.items.poseidon_trident.TridentRecipe;
import io.github.greatericontop.weaponmaster.items.rocket_stick.RocketCommand;
import io.github.greatericontop.weaponmaster.items.rocket_stick.RocketItemListener;
import io.github.greatericontop.weaponmaster.items.rpg_launcher.LauncherCommand;
import io.github.greatericontop.weaponmaster.items.rpg_launcher.RPGItemListener;
import io.github.greatericontop.weaponmaster.items.scylla.ScyllaCommand;
import io.github.greatericontop.weaponmaster.items.scylla.ScyllaItemListener;
import io.github.greatericontop.weaponmaster.items.scylla.ScyllaRecipe;
import io.github.greatericontop.weaponmaster.items.shredded_axe.ShreddedCommand;
import io.github.greatericontop.weaponmaster.items.shredded_axe.ShreddedListener;
import io.github.greatericontop.weaponmaster.items.shredded_axe.ShreddedRecipe;
import io.github.greatericontop.weaponmaster.items.sniper_rifle.SniperCommand;
import io.github.greatericontop.weaponmaster.items.sniper_rifle.SniperItemListener;
import io.github.greatericontop.weaponmaster.items.valkyrie_axe.ValkyrieCommand;
import io.github.greatericontop.weaponmaster.items.valkyrie_axe.ValkyrieItemListener;
import io.github.greatericontop.weaponmaster.items.valkyrie_axe.ValkyrieRecipe;
import io.github.greatericontop.weaponmaster.items.vamp_axe.VampCommand;
import io.github.greatericontop.weaponmaster.items.vamp_axe.VampItemListener;
import io.github.greatericontop.weaponmaster.items.vamp_axe.VampRecipe;
import io.github.greatericontop.weaponmaster.items.warlock_pants.WarlockCommand;
import io.github.greatericontop.weaponmaster.items.warlock_pants.WarlockItemListener;
import io.github.greatericontop.weaponmaster.items.warlock_pants.WarlockRecipe;
import io.github.greatericontop.weaponmaster.other_crafts.CoreStaffRecipe;
import io.github.greatericontop.weaponmaster.other_crafts.CustomItemListener;
import io.github.greatericontop.weaponmaster.other_crafts.FlaskRecipe;
import io.github.greatericontop.weaponmaster.other_crafts.HideLeviathanRecipe;
import io.github.greatericontop.weaponmaster.other_crafts.MinorItemCommand;
import io.github.greatericontop.weaponmaster.util.PaperUtils;

import org.bukkit.plugin.java.JavaPlugin;

public class WeaponMasterMain extends JavaPlugin {

    public PaperUtils paperUtils = null;
    public FightManager dragonManager = null;

    @Override
    public void onEnable() {
        long t = System.currentTimeMillis();

        this.getLogger().info("--------------------");
        this.getLogger().info("#######################################################################################################################");
        this.getLogger().info("# ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ #");
        this.getLogger().info("#▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌#");
        this.getLogger().info("#▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ #");
        this.getLogger().info("#▐░▌          ▐░▌       ▐░▌▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌          #");
        this.getLogger().info("#▐░▌ ▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌          #");
        this.getLogger().info("#▐░▌▐░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░▌          #");
        this.getLogger().info("#▐░▌ ▀▀▀▀▀▀█░▌▐░█▀▀▀▀█░█▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌     ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌          #");
        this.getLogger().info("#▐░▌       ▐░▌▐░▌     ▐░▌  ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌          #");
        this.getLogger().info("#▐░█▄▄▄▄▄▄▄█░▌▐░▌      ▐░▌ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ #");
        this.getLogger().info("#▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌#");
        this.getLogger().info("# ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀       ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ #");
        this.getLogger().info("#######################################################################################################################");
        this.getLogger().info("");
        this.getLogger().info("WeaponMaster");
        this.getLogger().info("");
        this.getLogger().info("Copyright (C) greateric 2021-2022. Licensed under GPL v3.");
        this.getLogger().info("Initializing WeaponMaster by greateric");
        this.getLogger().info("--------------------");

        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);

        paperUtils = new PaperUtils(this);

        this.getCommand("weaponmaster").setExecutor(new WeaponMasterCommand(this));
        this.getCommand("weaponmaster").setTabCompleter(new WeaponMasterCommandTabCompleter());
        // RPG Launcher
        this.getServer().getPluginManager().registerEvents(new RPGItemListener(this), this);
        this.getCommand("rpgl").setExecutor(new LauncherCommand());
        // Vamp Axe
        this.getServer().getPluginManager().registerEvents(new VampItemListener(this), this);
        this.getCommand("vampaxe").setExecutor(new VampCommand());
        new VampRecipe().regRecipe();
        // Scythe
        this.getServer().getPluginManager().registerEvents(new ScytheItemListener(this), this);
        this.getCommand("scythe").setExecutor(new ScytheCommand());
        new ScytheRecipe().regRecipe();
        // Dragon Sword
        this.getServer().getPluginManager().registerEvents(new DragonItemListener(this), this);
        this.getCommand("dragonsword").setExecutor(new DragonCommand());
        new DragonRecipe().regRecipe();
        this.getServer().getPluginManager().registerEvents(new DragonUpgradeListener(this), this);
        // Artemis Bow
        this.getServer().getPluginManager().registerEvents(new ArtemisItemListener(this), this);
        this.getCommand("artemis").setExecutor(new ArtemisCommand());
        new ArtemisRecipe().regRecipe();
        // Anduril
        this.getCommand("anduril").setExecutor(new AndurilCommand());
        new AndurilItemListener(this).regAndurilRunnable();
        new AndurilRecipe().regRecipe();
        // Excalibur
        this.getCommand("excalibur").setExecutor(new ExcaliburCommand());
        this.getServer().getPluginManager().registerEvents(new ExcaliburItemListener(this), this);
        new ExcaliburRecipe().regRecipe();
        // Exodus
        this.getCommand("exodus").setExecutor(new ExodusCommand());
        this.getServer().getPluginManager().registerEvents(new ExodusItemListener(this), this);
        new ExodusRecipe().regRecipe();
        // Rocket Stick
        this.getCommand("rocketstick").setExecutor(new RocketCommand());
        this.getServer().getPluginManager().registerEvents(new RocketItemListener(this), this);
        // Helios
        this.getCommand("helios").setExecutor(new HeliosCommand());
        this.getServer().getPluginManager().registerEvents(new HeliosItemListener(this), this);
        new HeliosRecipe().regRecipe();
        // Scylla's Chestplate
        this.getCommand("scylla").setExecutor(new ScyllaCommand());
        this.getServer().getPluginManager().registerEvents(new ScyllaItemListener(this), this);
        new ScyllaRecipe().regRecipe();
        // Hermes' Boots
        this.getCommand("hermesboots").setExecutor(new HermesCommand());
        this.getServer().getPluginManager().registerEvents(new HermesItemListener(this), this);
        new HermesRecipe().regRecipe();
        // Helmet of Life
        LifeHelmetListener lifeHelmetListener = new LifeHelmetListener(this);
        this.getCommand("lifehelmet").setExecutor(new LifeHelmetCommand(lifeHelmetListener));
        this.getServer().getPluginManager().registerEvents(lifeHelmetListener, this);
        new LifeHelmetRecipe().regRecipe();
        // Caveman Sword
        this.getCommand("cavemansword").setExecutor(new CavemanCommand());
        this.getServer().getPluginManager().registerEvents(new CavemanItemListener(this), this);
        new CavemanRecipe().regRecipe();
        // Warlock Pants
        this.getCommand("warlockpants").setExecutor(new WarlockCommand());
        new WarlockItemListener(this).regWarlockRunnable();
        new WarlockRecipe().regRecipe();
        // Fireball
        this.getCommand("fireball").setExecutor(new FireballCommand());
        this.getServer().getPluginManager().registerEvents(new FireballListener(this), this);
        new FireballRecipe().regRecipe();
        // Atom Bomb
        this.getCommand("atombomb").setExecutor(new AtomCommand());
        this.getServer().getPluginManager().registerEvents(new AtomItemListener(this), this);
        // Netherite Staff
        this.getCommand("netheritestaff").setExecutor(new NetheriteStaffCommand());
        this.getServer().getPluginManager().registerEvents(new NetheriteStaffListener(this), this);
        new NetheriteStaffRecipe().regRecipe();
        // Sniper Rifle
        this.getCommand("sniperrifle").setExecutor(new SniperCommand());
        this.getServer().getPluginManager().registerEvents(new SniperItemListener(this), this);
        // Miner's Blessing
        MinerItemListener minerListener = new MinerItemListener(this);
        this.getCommand("minersblessing").setExecutor(new MinerCommand());
        this.getServer().getPluginManager().registerEvents(minerListener, this);
        minerListener.regHasteRunnable();
        new MinerRecipe().regRecipe();
        // Pilot's Sword
        this.getCommand("pilotsword").setExecutor(new PilotCommand());
        this.getServer().getPluginManager().registerEvents(new PilotItemListener(this), this);
        //new PilotRecipe().regRecipe();
        // Shredded Axe
        this.getCommand("shreddedaxe").setExecutor(new ShreddedCommand());
        this.getServer().getPluginManager().registerEvents(new ShreddedListener(this), this);
        new ShreddedRecipe().regRecipe();
        // Napalm Missile
        this.getCommand("napalm").setExecutor(new NapalmCommand());
        this.getServer().getPluginManager().registerEvents(new NapalmItemListener(this), this);
        // Ninja Bow
        this.getCommand("ninjabow").setExecutor(new NinjaCommand());
        this.getServer().getPluginManager().registerEvents(new NinjaItemListener(this), this);
        new NinjaRecipe().regRecipe();
        // Dragon Armor
        this.getCommand("dragonarmor").setExecutor(new DragonArmorCommand());
        this.getServer().getPluginManager().registerEvents(new DragonArmorListener(this), this);
        new DragonArmorRecipe().registerAll();
        // Copper Sword
        this.getCommand("coppersword").setExecutor(new CopperSwordCommand());
        this.getServer().getPluginManager().registerEvents(new CopperSwordListener(this), this);
        new CopperSwordRecipe().regRecipe();
        // Poseidon's Trident
        TridentListener tridentListener = new TridentListener(this);
        this.getCommand("poseidontrident").setExecutor(new TridentCommand());
        this.getServer().getPluginManager().registerEvents(tridentListener, this);
        tridentListener.regTridentRunnable();
        new TridentRecipe().regRecipe();
        // Valkyrie Axe
        this.getCommand("valkyrieaxe").setExecutor(new ValkyrieCommand());
        this.getServer().getPluginManager().registerEvents(new ValkyrieItemListener(this), this);
        new ValkyrieRecipe().regRecipe();
        // Assault Rifle
        this.getCommand("assaultrifle").setExecutor(new AssaultCommand());
        this.getServer().getPluginManager().registerEvents(new AssaultListener(this), this);
        // Dragon Elytra
        this.getCommand("dragonelytra").setExecutor(new ElytraCommand());
        this.getServer().getPluginManager().registerEvents(new ElytraItemListener(this).regDragonElytraRunnable(), this);
        this.getServer().getPluginManager().registerEvents(new DragonElytraUpgradeListener(this), this);
        // Custom Items
        this.getCommand("minoritem").setExecutor(new MinorItemCommand());
        new HideLeviathanRecipe().regRecipe();
        new FlaskRecipe().regRecipe();
        new CoreStaffRecipe().regRecipe();
        // Custom Item Listener
        this.getServer().getPluginManager().registerEvents(new CustomItemListener(this), this);
        // Dragon Fight
        dragonManager = new FightManager(this);
        this.getServer().getPluginManager().registerEvents(dragonManager, this);

        this.getLogger().info(String.format("Finished setting up! [%d ms]", System.currentTimeMillis()-t));
    }

}
