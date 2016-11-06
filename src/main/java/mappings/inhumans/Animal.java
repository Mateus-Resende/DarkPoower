package mappings.inhumans;

/**
 * Created by mresende on 05/11/16.
 */
public class Animal {

    private final Integer id = 5;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;


    public Animal() {
        super();
        this.lifePoints = 3200;
        this.manaPoints = 30;
        this.strength = 80;
        this.abilityPower = 20;
        this.armor = 90;
        this.magicResist = 20;
        this.agility = 50;
    }

}
