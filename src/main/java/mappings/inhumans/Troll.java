package mappings.inhumans;

/**
 * Created by mresende on 05/11/16.
 */
public class Troll {

    private final Integer id = 6;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;


    public Troll() {
        super();
        this.lifePoints = 2800;
        this.manaPoints = 20;
        this.strength = 100;
        this.abilityPower = 20;
        this.armor = 100;
        this.magicResist = 20;
        this.agility = 20;
    }
}
