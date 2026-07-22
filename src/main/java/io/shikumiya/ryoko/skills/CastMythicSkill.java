package io.shikumiya.ryoko.skills;

import io.lumine.mythic.api.skills.Skill;
import io.lumine.mythic.api.skills.SkillCaster;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.shikumiya.ryoko.messages.MessageHelper;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Optional;

public class CastMythicSkill {

    public static void onCast(Player player, String skillID) {

        Optional<Skill> skillOpt = MythicBukkit.inst().getSkillManager().getSkill(skillID);
        if (skillOpt.isEmpty()) {
            MessageHelper.sendMessage(player,"not found mythic skill.");
            return;
        };

        Skill skill = skillOpt.get();
        SkillCaster caster = MythicBukkit.inst().getSkillManager().getCaster(BukkitAdapter.adapt(player));

        skill.execute(
                null,
                caster,
                BukkitAdapter.adapt(player),
                caster.getLocation(),
                new HashSet<>(),
                new HashSet<>(),
                1.0f
        );
    }

}
