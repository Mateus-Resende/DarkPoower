package mappings.humans;

/**
 * Created by mresende on 05/11/16.
 */
public class Warrior {

    private final Integer id = 1;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;


    public Warrior() {
        super();
        this.lifePoints = 4000;
        this.manaPoints = 30;
        this.strength = 100;
        this.abilityPower = 20;
        this.armor = 80;
        this.magicResist = 20;
        this.agility = 50;
    }

}
