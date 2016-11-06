package mappings.humans;

import mappings.base.Hero;

/**
 * Created by mresende on 05/11/16.
 */
public class Mage extends Hero{

    private final Integer id = 3;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;


    public Mage() {
        super();
        this.lifePoints = 2500;
        this.manaPoints = 100;
        this.strength = 40;
        this.abilityPower = 100;
        this.armor = 30;
        this.magicResist = 100;
        this.agility = 40;
    }

}
