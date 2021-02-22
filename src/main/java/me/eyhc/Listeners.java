package me.eyhc;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;


public class Listeners implements Listener {


    public Listeners() {

    }

    @EventHandler
    public void onBreak (PlayerInteractEvent e) {
        (new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach((p) -> {
                    final Block b1 = p.getTargetBlockExact(3, FluidCollisionMode.ALWAYS);
                    if (b1 != null && b1.getType().name().contains("WATER")) {
                        (new BukkitRunnable() {
                            public void run() {
                                if (b1.equals(p.getTargetBlockExact(3, FluidCollisionMode.ALWAYS))) {
                                    if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
                                        b1.setBlockData(Material.AIR.createBlockData(), false);
                                        if (!p.getGameMode().equals(GameMode.CREATIVE) && !p.getGameMode().equals(GameMode.SPECTATOR)) {
                                            Location l = b1.getLocation();
                                            p.getWorld().dropItemNaturally(l, new ItemStack(Material.WATER_BUCKET));
                                        }
                                    }
                                }

                            }
                        }).run();
                    }
                });
            }
        }).run();
    }
}
