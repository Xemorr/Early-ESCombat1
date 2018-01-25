package com.Xemor.MainPackage.Events;

import java.util.List;
import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import com.Xemor.MainPackage.Main;

public class ESBows implements Listener{
	
	private Main plugin;
	
	public void passData(Main pl)
	{
		plugin = pl;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHit(EntityDamageByEntityEvent entityevent) {
		System.out.println("a");
		Entity damager = entityevent.getDamager();
		if (damager instanceof Arrow) {
			Arrow arrow = (Arrow) damager;
			ProjectileSource shooter = arrow.getShooter();
			if (shooter instanceof Player) {
				Player player = (Player) shooter;
				List<String> Lore = player.getItemInHand().getItemMeta().getLore();
				Map<Enchantment, Integer> Enchantments = player.getItemInHand().getEnchantments();
				if (Enchantments.containsKey(Enchantment.LUCK)) {
					int maxduration = plugin.getConfig().getInt("maxduration");
					int minduration = plugin.getConfig().getInt("minduration");
					maxduration = maxduration * 20;
					minduration = minduration * 20;
					Integer level = Enchantments.get(Enchantment.LUCK);
					int id = (int )(Math.random() * 50 + 1);
					int potency = (int )(Math.random() * level + 1);
					int duration = (int )(Math.random() * maxduration + minduration);
					Entity entity = entityevent.getEntity();
					if (entity instanceof Player) {
						((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.getById(id),duration, potency));
					}
					
				}
				if (Lore.contains("Nimble")) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6, 2));
					
				}
				
			}
			
		}
					
					}
}
