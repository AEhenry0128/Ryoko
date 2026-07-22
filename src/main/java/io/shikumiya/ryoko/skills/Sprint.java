package io.shikumiya.ryoko.skills;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Sprint {

    public static void Cast(Player player) {

        if (!player.isOnGround()) return;
        //thx ai math
        double yaw = Math.toRadians(player.getLocation().getYaw());
        Vector dash = new Vector(-Math.sin(yaw), 0, Math.cos(yaw))
                .multiply(1)
                .setY(0.1);
        player.setVelocity(dash);

    }
}
