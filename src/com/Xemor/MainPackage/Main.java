package com.Xemor.MainPackage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import com.Xemor.MainPackage.Events.ESBows;
import com.Xemor.MainPackage.Events.ESRLauncher;
import com.Xemor.MainPackage.Events.Rods.ESRods;
import com.Xemor.MainPackage.Events.Rods.ESRodsThrow;

public class Main extends JavaPlugin implements Listener{
	
	FileConfiguration config;
	
	@Override
	public void onEnable() {
		this.config = getConfig();
		config.options().copyDefaults(true);
		saveDefaultConfig();
		ESBows ESBows = new ESBows();
		ESRods ESRods = new ESRods();
		ESRodsThrow ESRodsThrow = new ESRodsThrow();
		ESRLauncher ESRLauncher = new ESRLauncher();
		ESBows.passData(this);
		ESRods.passData(this);
		ESRodsThrow.passData(this);
		ESRLauncher.passData(this);
		registerEvents(this, ESBows, ESRods, ESRodsThrow, ESRLauncher);
	}
	//Much easier then registering events in 10 different methods
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
	for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	}
	}
	/*
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
				Map<Enchantment, Integer> Enchantments = player.getItemInHand().getEnchantments();
				if (Enchantments.containsKey(Enchantment.LUCK)) {
					int maxduration = getConfig().getInt("maxduration");
					int minduration = getConfig().getInt("minduration");
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
			}
			
		}
		if (damager instanceof FishHook) {
			FishHook arrow = (FishHook) damager;
			ProjectileSource shooter = arrow.getShooter();
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
					int fireaspectticksperenchantlevel =  getConfig().getInt("fireaspectticksperenchantlevel");
					int flameticksperenchantlevel = getConfig().getInt("flameticksperenchantlevel");
					int fireduration = (flameticksperenchantlevel * levelflame) + (levelfaspect * fireaspectticksperenchantlevel);
					int level = levelflame + levelfaspect;
					entity.setFireTicks(level * fireduration);	
					}
				if (Enchantments.containsKey(Enchantment.LUCK)) {
					int maxduration = getConfig().getInt("maxduration");
					int minduration = getConfig().getInt("minduration");
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
						double multiplier = getConfig().getDouble("luremultiplier");
						int levellure = player.getItemInHand().getEnchantments().get(Enchantment.LURE);
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
	
	
	*/
	public void onDisable() {
	}
}
