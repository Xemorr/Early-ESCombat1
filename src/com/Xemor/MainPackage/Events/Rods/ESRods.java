package com.Xemor.MainPackage.Events.Rods;

import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import com.Xemor.MainPackage.Main;

public class ESRods implements Listener{

	private Main plugin;
	
	public void passData(Main pl)
	{
		plugin = pl;
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHit(EntityDamageByEntityEvent entityevent) {
		Entity damager = entityevent.getDamager();
		if (damager instanceof FishHook) {
			FishHook rod = (FishHook) damager;
			ProjectileSource shooter = rod.getShooter();
			if (shooter instanceof Player) {
				Entity entity = entityevent.getEntity();
				Player player = (Player) shooter;
				Map<Enchantment, Integer> Enchantments = player.getItemInHand().getEnchantments();
				if (Enchantments.containsKey(Enchantment.FIRE_ASPECT) || Enchantments.containsKey(Enchantment.ARROW_FIRE)) {
					int levelfaspect = 0;
					int levelflame = 0;
					if (Enchantments.containsKey(Enchantment.FIRE_ASPECT)) {
						levelfaspect = player.getItemInHand().getEnchantments().get(Enchantment.FIRE_ASPECT);
					}
					if (Enchantments.containsKey(Enchantment.ARROW_FIRE)) {
						levelflame = player.getItemInHand().getEnchantments().get(Enchantment.ARROW_FIRE);
					}
					int fireaspectticksperenchantlevel =  plugin.getConfig().getInt("fireaspectticksperenchantlevel");
					int flameticksperenchantlevel = plugin.getConfig().getInt("flameticksperenchantlevel");
					int fireduration = (flameticksperenchantlevel * levelflame) + (levelfaspect * fireaspectticksperenchantlevel);
					int level = levelflame + levelfaspect;
					entity.setFireTicks(level * fireduration);	
					}
				if (Enchantments.containsKey(Enchantment.LUCK)) {
					int maxduration = plugin.getConfig().getInt("maxduration");
					int minduration = plugin.getConfig().getInt("minduration");
					maxduration = maxduration * 20;
					minduration = minduration * 20;
					Integer level = Enchantments.get(Enchantment.LUCK);
					int id = (int )(Math.random() * 50 + 1);
					int potency = (int )(Math.random() * level + 1);
					int duration = (int )(Math.random() * maxduration + minduration);
					if (entity instanceof Player) {
						((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.getById(id),duration, potency));
					}

				if (Enchantments.containsKey(Enchantment.KNOCKBACK)) {
					if (entity instanceof Player) {
						double multiplier = plugin.getConfig().getDouble("luremultiplier");
						int levellure = player.getItemInHand().getEnchantments().get(Enchantment.KNOCKBACK);
						double levelmultiplier = (levellure / 10) + 1;
						multiplier = levelmultiplier * multiplier;
						Vector x = (player.getLocation().getDirection().multiply(multiplier));
						entity.setVelocity(x);
					}
					
				}
			}
			
		}
		}
					
					}
}
