package me.eyhc;

import me.eyhc.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class MineWater extends JavaPlugin {
    private static MineWater thisPlugin;

    public MineWater() {

    }

    @Override
    public void onEnable() {
        thisPlugin = this;
        this.getServer().getPluginManager().registerEvents(new Listeners(), this);

    }

    @Override
    public void onDisable() {
        thisPlugin = null;
    }

    public MineWater getInstance() {
        return this.thisPlugin;
    }
}
