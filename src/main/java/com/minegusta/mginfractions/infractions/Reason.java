package com.minegusta.mginfractions.infractions;

import com.demigodsrpg.infractions.Infraction;
import com.minegusta.mginfractions.Main;

import java.util.UUID;

public enum Reason {
    SPAM(10),
    HEAVY_SPAM(40),
    NSFW_ROLEPLAY(20),
    RACISM(20),
    IMPERSONATION(15),
    DISRESPECT(20),
    SWEARING(5),
    BULLYING(30),
    ALT_ACCOUNT_ABUSE(30),
    HACKING(20),
    LARGE_HACKING(60),
    DUPING(35),
    ADVERTISING(20),
    NON_FACTION_GRIEFING(25),
    POWER_ABUSE(35),
    BAD_SHIT(20);

    private int value;

    private Reason(int value) {
        this.value = value;
    }

    public Infraction newInfraction(String proof, UUID playerId) {
        return new Infraction(value, System.currentTimeMillis(), Main.getPluginConfig().getString("server.name", "Minegusta"), name(), proof, playerId);
    }
}
