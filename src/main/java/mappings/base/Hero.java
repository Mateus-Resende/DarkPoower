package mappings.base;

import java.util.Map;

public class Hero {

    private final Integer id;
    private final String className;
    private final Map<String, Integer> attributes;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;

    public Hero(Integer id, String className, Map<String, Integer> attributes) {
        this.id = id;
        this.className = className;
        this.attributes = attributes;
    }


    public Integer getLifePoints() {
        return this.attributes.get("life");
    }

    public void setLifePoints(Integer lifePoints) {
        this.attributes.put("life", lifePoints);
    }

    public Integer getManaPoints() {
        return this.attributes.get("mana");
    }

    public void setManaPoints(Integer manaPoints) {
        this.attributes.put("mana", manaPoints);
    }

    public Integer getStrength() {
        return this.attributes.get("strength");
    }

    public Integer getAbilityPower() {
        return this.attributes.get("abilityPower");
    }

    public Integer getArmor() {
        return this.attributes.get("armor");
    }

    public Integer getMagicResist() {
        return this.attributes.get("magicResist");
    }

    public Integer getAgility() {
        return this.attributes.get("agility");
    }

}
