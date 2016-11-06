package mappings.inhumans;

/**
 * Created by mresende on 05/11/16.
 */
public class Zombie {

    private final Integer id = 8;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;


    public Zombie() {
        super();
        this.lifePoints = 2500;
        this.manaPoints = 20;
        this.strength = 40;
        this.abilityPower = 20;
        this.armor = 80;
        this.magicResist = 90;
        this.agility = 20;
    }
}
