package com.Xemor.MainPackage.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.util.Vector;

import com.Xemor.MainPackage.Main;
//To-Do:
//Add Explosion
//Make it look for the exact item.
//Balance/Make Adjustments
//Add a cooldown
//Make it actually work lmao

public class ESRLauncher implements Listener{
	
private Main plugin;
	
	public void passData(Main pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onSwing(PlayerAnimationEvent event) {
		Player player = event.getPlayer();
		String Launcher = new String("Rocket Launcher");
		if (player.getItemInHand().getItemMeta().getLore().contains(Launcher)) {
			player.setVelocity(new Vector(0, 15, 0)); //Flings player into Air
		}
			
	}

}
