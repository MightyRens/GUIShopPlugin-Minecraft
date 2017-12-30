package minecraft.guishopplugin;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class InteractShopListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        if(event.getRightClicked() instanceof Villager) {
            event.setCancelled(true);
        }
    }

}
