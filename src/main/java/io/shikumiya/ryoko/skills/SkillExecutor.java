package io.shikumiya.ryoko.skills;

import org.bukkit.entity.Player;

public class SkillExecutor {

    public static void CastSkill(Player player, String skill) {

        if (skill == null || skill.isEmpty()) return;
        String[] parts = skill.split(":",2);

        if (parts.length == 1) {
            switch (parts[0]) {
                case "Sprint": Sprint.Cast(player);
            }
            return;
        }

        String prefix = parts[0].toLowerCase();
        String skill_ = parts[1];

        switch (prefix) {
            case "mm":
            case "mythicmobs":
            case "mythic":
                CastMythicSkill.onCast(player, skill_);
        }
        return;
    }

}
