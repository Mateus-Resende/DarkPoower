package mappings.base;

import java.util.List;
import java.util.Map;

public class Hero {

    private final Integer id;
    private final Map<String, Integer> attributes;

    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;
    private List<Weapons> availableWeapons;
    private List<Spells> availableSpells;
    private Weapons equippedWeapon;


    public Hero(Integer id, Map<String, Integer> attributes, List<Weapons> availableWeapons, List<Spells> availableSpells) {
        this.id = id;
        this.attributes = attributes;
        this.availableSpells = availableSpells;
        this.availableWeapons = availableWeapons;
        this.equippedWeapon = this.getLowestDamageWeapon();
    }

    private Weapons getLowestDamageWeapon() {
        Weapons weapon = this.availableWeapons.get(0);

        for (Weapons w : this.availableWeapons) {
            if (w.getDamage() < weapon.getDamage()) {
                weapon = w;
            }
        }

        return weapon;
    }

    public Weapons getEquippedWeapon() {
        return this.equippedWeapon;
    }

    public void setEquippedWeapon(Weapons weapon) {
        this.equippedWeapon = weapon;
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
