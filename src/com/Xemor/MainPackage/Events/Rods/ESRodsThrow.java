package com.Xemor.MainPackage.Events.Rods;

import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

import com.Xemor.MainPackage.Main;

public class ESRodsThrow implements Listener{

	private Main plugin;
	
	public void passData(Main pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onFish(PlayerFishEvent fishevent) {
		System.out.println("rod throw");
		Player player = fishevent.getPlayer();
		Map<Enchantment, Integer> Enchantments = player.getItemInHand().getEnchantments();
		if (Enchantments.containsKey(Enchantment.FIRE_ASPECT) || Enchantments.containsKey(Enchantment.ARROW_FIRE)) {
			fishevent.getHook().setFireTicks(200);
		}
		if (Enchantments.containsKey(Enchantment.LURE)) {
			if (fishevent.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
				Entity entity = fishevent.getCaught();
				if (entity instanceof Player) {
					double multiplier = plugin.getConfig().getDouble("luremultiplier");
					int levellure = player.getItemInHand().getEnchantments().get(Enchantment.LURE);
					double levelmultiplier = (levellure / 10) + 1;
					multiplier = levelmultiplier * multiplier;
					multiplier = multiplier * -1;
					Vector x = (player.getLocation().getDirection().multiply(multiplier));
					entity.setVelocity(x);
				}
			}
			}
		
	}
	
	
}
