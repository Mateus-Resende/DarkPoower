package mappings.base;

import java.util.ArrayList;

public enum Spells {

    HEALTH_POTION(-200, 12),
    FIRE_BREATH(400, 12),
    BIO_ANTRAX(360, 14),
    HEALING(-400, 16),
    ICE_FLAME(320, 14),
    POISONING(280, 12),
    STORM(200, 12);

    private Integer damage;
    private Integer mana;

    Spells(Integer damage, Integer mana){
        this.damage = damage;
        this.mana = mana;
    }

    public Integer getDamage(){
        return this.damage;
    }

    public Integer getMana() {
        return this.mana;
    }
    
}

