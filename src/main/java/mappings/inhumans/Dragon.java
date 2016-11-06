package mappings.inhumans;

/**
 * Created by mresende on 05/11/16.
 */
public class Dragon {

    private final Integer id = 7;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;


    public Dragon() {
        super();
        this.lifePoints = 3000;
        this.manaPoints = 40;
        this.strength = 100;
        this.abilityPower = 20;
        this.armor = 100;
        this.magicResist = 50;
        this.agility = 80;
    }
}
