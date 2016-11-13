package mappings.base;

import java.util.ArrayList;

public enum Spells {

    HEALTH_POTION   (0, 200, 12), // poção de vida
    FIRE_BREATH     (400, 0, 12), // hálito de fogo
    BIO_ANTRAX      (360, 0, 14), // bio antraz
    HEALING         (0, 400, 16), // cura
    ICE_FLAME       (320, 0, 14), // flama gelada
    POISONING       (280, 0, 12), // envenenamento
    STORM           (200, 0, 12); // tempestade

    private Integer damage;
    private Integer mana;
    private Integer heal;

    Spells(Integer damage, Integer heal,  Integer mana){
        this.damage = damage;
        this.mana = mana;
        this.heal = heal;
    }

    public Integer getDamage(){
        return this.damage;
    }

    public Integer getHeal() { return this.heal; }

    public Integer getMana() {
        return this.mana;
    }

    public boolean isHealingSpell() {
        return this.heal > 0;
    }
    
}

