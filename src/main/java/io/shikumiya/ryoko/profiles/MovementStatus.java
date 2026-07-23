package io.shikumiya.ryoko.profiles;

import org.bukkit.scheduler.BukkitTask;

public class MovementStatus {

    private int JUMPING_STATUS;
    private boolean LAST_JUMP_INPUT;
    private BukkitTask GLIDING_TASK;

    public MovementStatus() {
        this.JUMPING_STATUS = 0;
        this.LAST_JUMP_INPUT = false;
    }

    public int getJumpStatus() {
        return this.JUMPING_STATUS;
    }

    public boolean getLastJumpInput() {
        return this.LAST_JUMP_INPUT;
    }

    public BukkitTask getGlidingTask() {
        return this.GLIDING_TASK;
    }

    public void setJumpStatus(int status) {
        this.JUMPING_STATUS = status;
    }

    public void setLastJumpInput(boolean TF) {
        this.LAST_JUMP_INPUT = TF;
    }

    public void setGlidingTask(BukkitTask task) {
        this.GLIDING_TASK = task;
    }
}
