package minecraft.guishopplugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        setInstance(this);
        setPrefix(ChatColor.YELLOW + "Shop");

        registerEvents(getServer().getPluginManager());
    }

    private void registerEvents(PluginManager pluginManager){

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

}
