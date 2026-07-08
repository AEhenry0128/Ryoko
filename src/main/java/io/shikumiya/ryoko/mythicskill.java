package io.shikumiya.ryoko;

import io.lumine.mythic.api.skills.Skill;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.bukkit.events.MythicSkillEvent;
import io.lumine.mythic.core.skills.SkillExecutor;

public class mythicskill {

    public static void castTest() {
        Skill test = MythicBukkit.inst().getSkillManager().getSkill("hello_world").orElse(null);
        SkillExecutor.class.cast(test);


    }

}
