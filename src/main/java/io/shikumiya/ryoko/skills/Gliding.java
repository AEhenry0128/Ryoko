package io.shikumiya.ryoko.skills;

import io.shikumiya.ryoko.characters.Character;
import io.shikumiya.ryoko.characters.CharacterManager;
import io.shikumiya.ryoko.main;
import io.shikumiya.ryoko.profiles.Profile;
import org.bukkit.Input;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class Gliding {

    public static void start(Player player, Profile profile) {

        cancel(profile);
        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline() || player.isDead() || player.isOnGround() || player.isClimbing()) {
                    profile.getMovementStatus().setJumpStatus(0);
                    profile.getMovementStatus().setGlidingTask(null);
                    cancel();
                    return;
                }
                if (player.getVelocity().getY() < -0.1) {

                    player.setFallDistance(0);
                    //thx ai math
                    Input input = player.getCurrentInput();
                    Location loc = player.getLocation();

                    Vector forward = loc.getDirection().setY(0).normalize();
                    Vector right = new Vector(-forward.getZ(), 0, forward.getX());

                    Vector accel = new Vector(0, 0, 0);
                    if (input.isForward())  accel.add(forward);
                    if (input.isBackward()) accel.subtract(forward);
                    if (input.isRight())    accel.add(right);
                    if (input.isLeft())     accel.subtract(right);

                    Vector v = player.getVelocity();

                    if (accel.lengthSquared() > 0) {
                        accel.normalize().multiply(0.08);
                        v.add(accel);
                    }

                    double maxSpeed = 0.15;
                    Vector flat = new Vector(v.getX(), 0, v.getZ());
                    if (flat.length() > maxSpeed) {
                        flat.normalize().multiply(maxSpeed);
                        v.setX(flat.getX()).setZ(flat.getZ());
                    }

                    if (accel.lengthSquared() == 0) {
                        v.setX(v.getX() * 0.96).setZ(v.getZ() * 0.96);
                    }

                    player.setVelocity(v.setY(-0.1));
                    //
                }
            }
        }.runTaskTimer(main.getPlugin(main.class), 0L, 1L);

        profile.getMovementStatus().setGlidingTask(task);
    }


    public static void cancel(Profile profile) {
        BukkitTask task = profile.getMovementStatus().getGlidingTask();
        if (task != null) {
            task.cancel();
            profile.getMovementStatus().setGlidingTask(null);
        }

    }

}
