package com.alecz.walkspeed;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class WalkSpeed extends JavaPlugin {
    public static Logger log;

    public void onEnable(){

        log = getServer().getLogger();
        WSCommandHandler handler = new WSCommandHandler();
        getCommand("walkspeed").setExecutor(handler);
        getCommand("flyspeed").setExecutor(handler);

    }

    public void onDisable(){

    }
}
