package io.github.wkmartins.keepEffectsAfterDeath;

import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DeathRespawnListener implements Listener {
    private final Map<Player, Collection<PotionEffect>> effectsBeforeDeathMap = new HashMap<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        final Player player = event.getPlayer();
        final Collection<PotionEffect> effects = player.getActivePotionEffects();
        effectsBeforeDeathMap.put(player, effects);
    }

    @EventHandler
    public void onPostRespawn(PlayerPostRespawnEvent event) {
        final Player player = event.getPlayer();
        final Collection<PotionEffect> effectsBeforeDeath = effectsBeforeDeathMap.remove(player);
        for (PotionEffect effect : effectsBeforeDeath) {
            player.addPotionEffect(effect);
        }
    }
}