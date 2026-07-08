package io.shikumiya.ryoko.events;

import io.lumine.mythic.api.skills.Skill;
import io.lumine.mythic.api.skills.SkillCaster;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Optional;

public class CastMythicSkillEvent {

    public static void onCast(Player player, String skillID) {

        Optional<Skill> skillOpt = MythicBukkit.inst().getSkillManager().getSkill(skillID);

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
