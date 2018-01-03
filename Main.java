package minecraft.guishopplugin;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Economy econ = null;

    @Override
    public void onEnable() {

        setInstance(this);
        setPrefix(ChatColor.YELLOW + "Shop");

        registerEvents(getServer().getPluginManager());

        Plugin essentials = this.getServer().getPluginManager().getPlugin("essentials");

        if(!setupEconomy()) {
            getLogger().severe(String.format("[%s] - Disabled due to no vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }

    public boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    private void registerEvents(PluginManager pluginManager){
        pluginManager.registerEvents(new InteractShopListener(), this);
        pluginManager.registerEvents(new ShopClickListener(), this);
    }

    public static Main getInstance() {
        return instance;
    }

    public static void setInstance(Main instance) {
        Main.instance = instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        Main.prefix = prefix;
    }

    private static String prefix;
    private static Main instance;

    public ShopBuildManager getShopManager(){
        return new ShopBuildManager();
    }

}
