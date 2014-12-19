package com.minegusta.mginfractions;

import com.demigodsrpg.infractions.InfractionsConfig;
import org.bukkit.configuration.Configuration;

public class MGInfractionsConfig implements InfractionsConfig {
    private Configuration conf;

    public MGInfractionsConfig(Configuration conf) {
        this.conf = conf;
    }

    @Override
    public String databaseUrl() {
        return conf.getString("database.url", "postgresql://localhost:5432/minecraft?user=minecraft&password=minecraft");
    }

    @Override
    public int maxScore() {
        return conf.getInt("max.score", 100);
    }

    @Override
    public boolean requireProof() {
        return conf.getBoolean("proof.require", true);
    }

    @Override
    public boolean useBitly() {
        return conf.getBoolean("proof.bitly.use", false);
    }

    @Override
    public String bitlyUser() {
        return conf.getString("proof.bitly.username", "");
    }

    @Override
    public String bitlyKey() {
        return conf.getString("proof.bitly.key", "");
    }

    @Override
    public boolean canKick() {
        return conf.getBoolean("can.kick", true);
    }

    @Override
    public String warnMessage() {
        return conf.getString("message.warn", "You have received an infraction. Reason: %reason%.");
    }

    @Override
    public String banMessage() {
        return conf.getString("message.ban", "You have been banned for being bad.");
    }
}
