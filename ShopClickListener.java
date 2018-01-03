package minecraft.guishopplugin;

import net.ess3.api.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class ShopClickListener extends JavaPlugin implements Listener {

    private static Economy econ = null;
    HashMap<String, Double>balance = new HashMap<String, Double>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        balance.put(event.getPlayer().getName(), econ.getBalance(event.getPlayer().getName()));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        if(balance.containsKey(event.getPlayer().getName()))
            balance.remove(event.getPlayer().getName());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        try {
            Player player = (Player) event.getWhoClicked();
            if(event.getInventory().getName().equals("Shop")) {

                event.setCancelled(true);

                if(event.getCurrentItem().getType() == Material.COAL) {

                    openSellShop(player);

                }

            } else if(event.getInventory().getName().equals("Sell shop")) {
                event.setCancelled(true);
                String name = player.getName();
                if(event.getCurrentItem().getType() != Material.STAINED_GLASS_PANE) {
                    int price = Integer.valueOf(event.getCurrentItem().getItemMeta().getLore().get(0).replace("Price: ", "").replace(" Money", ""));
                    if(econ.format(econ.getBalance(player.getName())) >= price) {
                        balance.put(player.getBalance() - price);
                        player.getInventory().addItem(event.getCurrentItem());
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        player.closeInventory();
                    } else {
                        player.sendMessage(ChatColor.RED + "YOU DON'T HAVE ENOUGH MONEY!");
                    }
                }
            }
        } catch (NullPointerException e) {

        }
    }

    private void openSellShop(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*3, "Sell shop");

        for(int i = 0; i < 9*3; i++) {
            inventory.setItem(i, Items.createItem(Material.STAINED_GLASS_PANE, 1, 15, ""));
        }

        inventory.setItem(0, Items.createItem(Material.COAL, 1, 0, "Coal"));

        player.openInventory(inventory);
    }

}
