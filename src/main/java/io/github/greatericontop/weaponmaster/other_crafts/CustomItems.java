package io.github.greatericontop.weaponmaster.other_crafts;

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

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomItems {

    public final UUID ENERGY_MODIFIER_UUID = UUID.fromString("00000000-1111-0000-0000-c61288850beb");

    public final String LEVIATHAN_HEART_NAME = "§9Heart of Leviathan";
    public final String CORE_STAFF_NAME = "§4Nether Reactor Core";
    public final String FLASK_ICHOR_NAME = "§cFlask of Ichor";
    public final String DRAGON_SCALE_NAME = "§d§lDragon Scale";
    public final String MAGIC_ENERGY_BAR_NAME = "§eMagic Energy Bar";

    public List<String> LEVIATHAN_HEART_LORE = new ArrayList<String>();
    public List<String> CORE_STAFF_LORE = new ArrayList<String>();
    public List<String> DRAGON_SCALE_LORE = new ArrayList<String>();
    public List<String> MAGIC_ENERGY_BAR_LORE = new ArrayList<String>();

    public CustomItems() {
        LEVIATHAN_HEART_LORE.add("id: LEVIATHAN_HEART");
        LEVIATHAN_HEART_LORE.add("§9The heart of a sea monster.");
        LEVIATHAN_HEART_LORE.add("§712% chance to drop on elder guardian kills");

        CORE_STAFF_LORE.add("id: CORE_STAFF");
        CORE_STAFF_LORE.add("§9The powerful core From the depths of the Nether.");
        CORE_STAFF_LORE.add("§7Crafted using the finest magic.");

        DRAGON_SCALE_LORE.add("id: DRAGON_SCALE");
        DRAGON_SCALE_LORE.add("§dA magical artifact stolen from the dragon as it was dying.");
        DRAGON_SCALE_LORE.add("§dThis dragon scale carries an immense magical power of the dragon.");
        DRAGON_SCALE_LORE.add("§dIt can be added to other dragon items to multiply their strength.");

        MAGIC_ENERGY_BAR_LORE.add("id: MAGIC_ENERGY_BAR");
        MAGIC_ENERGY_BAR_LORE.add("§9Consume this item to gain an additional heart.");
        MAGIC_ENERGY_BAR_LORE.add("§7You can accumulate up to 6 hearts, but 2 are lost per death.");
    }

    public ItemStack generateLeviathanHeartItemStack() {
        ItemStack stack = new ItemStack(Material.BLUE_ICE, 1);
        ItemMeta iMeta = stack.getItemMeta();
        iMeta.setDisplayName(LEVIATHAN_HEART_NAME);
        iMeta.setLore(LEVIATHAN_HEART_LORE);
        stack.setItemMeta(iMeta);
        return stack;
    }

    public ItemStack generateCoreStaffItemStack() {
        ItemStack stack = new ItemStack(Material.NETHER_BRICK, 1);
        ItemMeta iMeta = stack.getItemMeta();
        iMeta.addEnchant(Enchantment.SOUL_SPEED, 1, false);
        iMeta.setDisplayName(CORE_STAFF_NAME);
        iMeta.setLore(CORE_STAFF_LORE);
        stack.setItemMeta(iMeta);
        return stack;
    }

    public ItemStack generateFlaskIchorItemStack() {
        ItemStack stack = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta iMeta = (PotionMeta) stack.getItemMeta();
        iMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 1, 3), true);
        iMeta.setColor(Color.MAROON);
        iMeta.setDisplayName(FLASK_ICHOR_NAME);
        stack.setItemMeta(iMeta);
        return stack;
    }

    public ItemStack generateDragonScaleItemStack() {
        ItemStack stack = new ItemStack(Material.PHANTOM_MEMBRANE, 1);
        ItemMeta iMeta = stack.getItemMeta();
        iMeta.setDisplayName(DRAGON_SCALE_NAME);
        List<String> lore = new ArrayList<String>();
        lore.addAll(DRAGON_SCALE_LORE);
        lore.add(String.format("§7#%s", UUID.randomUUID())); // make similar items unstackable - they are bulk deleted in anvils
        iMeta.setLore(lore);
        stack.setItemMeta(iMeta);
        return stack;
    }

    public ItemStack generateMagicEnergyBarItemStack() {
        ItemStack stack = new ItemStack(Material.COOKIE, 1);
        ItemMeta iMeta = stack.getItemMeta();
        iMeta.setDisplayName(MAGIC_ENERGY_BAR_NAME);
        iMeta.setLore(MAGIC_ENERGY_BAR_LORE);
        stack.setItemMeta(iMeta);
        return stack;
    }

}
