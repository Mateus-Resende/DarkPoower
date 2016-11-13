package mappings.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;
import exceptions.InvalidAttackTypeException;
import exceptions.SpecialAttackNotAvailableException;
import exceptions.SpellNotAvailableForClass;
import exceptions.WeaponNotAvailableForClassException;

import java.util.List;
import java.util.Map;

public class Hero {

    private static final Double SPECIAL_ATTACK_MULTIPLIER = 1.5;

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
    private Race race;

    private Integer specialAttackCount;

    public Hero(Integer id, Map<String, Integer> attributes, List<Weapons> availableWeapons, List<Spells> availableSpells, Race race) {
        this.id = id;
        this.attributes = attributes;
        this.availableSpells = availableSpells;
        this.availableWeapons = availableWeapons;
        this.equippedWeapon = this.getLowestDamageWeapon();
        this.race = race;
        this.specialAttackCount = 0;
    }

    private Weapons getLowestDamageWeapon() {
        Weapons lowestDamage = this.availableWeapons.get(0);
        for (Weapons w : this.availableWeapons) {
            if (w.getDamage() < lowestDamage.getDamage()) {
                lowestDamage = w;
            }
        }
        return lowestDamage;
    }

    public void receiveAttack(Integer damage, Object type) throws InvalidAttackTypeException {
        if (type.getClass().equals(Spells.class)) {
            this.lifePoints -= damage - this.magicResist - this.agility;
        } else if (type.getClass().equals(Weapons.class)) {
            this.lifePoints -= damage - this.armor - this.agility;
        } else {
            throw new InvalidAttackTypeException();
        }
    }

    public boolean isSpecialAttackAvailable() {
        return this.specialAttackCount >= 10;
    }

    public boolean isHeroDead(){
        return this.lifePoints <= 0;
    }

    public Weapons getEquippedWeapon() {
        return this.equippedWeapon;
    }

    public void setEquippedWeapon(Weapons weapon) throws WeaponNotAvailableForClassException {
        if (this.availableWeapons.contains(weapon)) {
            this.equippedWeapon = weapon;
        } else {
            throw new WeaponNotAvailableForClassException(weapon, this);
        }
    }

    public Double attack() {
        return this.agility.doubleValue() + this.equippedWeapon.getDamage().doubleValue();
    }

    public Double specialAttack() throws SpecialAttackNotAvailableException {
        if (this.specialAttackCount >= 10 && this.race.equals(Race.INHUMAN)) {
            return this.attack() * this.SPECIAL_ATTACK_MULTIPLIER;
        } else {
            throw new SpecialAttackNotAvailableException();
        }
    }

    public Double specialAttack(Spells s) throws SpecialAttackNotAvailableException, SpellNotAvailableForClass {
        if (this.specialAttackCount >= 10 && this.race.equals(Race.HUMAN) && !s.isHealingSpell()) {
            return this.useSpell(s) * this.SPECIAL_ATTACK_MULTIPLIER;
        } else {
            throw new SpecialAttackNotAvailableException();
        }
    }

    public Integer useSpell(Spells s) throws SpellNotAvailableForClass {
        if (this.availableSpells.contains(s)) {
            this.manaPoints -= s.getMana();
            return (s.isHealingSpell() ? s.getHeal() : s.getDamage());
        } else {
            throw new SpellNotAvailableForClass(s, this);
        }
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

    public Integer getSpecialAttackCount() {
        return specialAttackCount;
    }

    public void setSpecialAttackCount(Integer specialAttackCount) {
        this.specialAttackCount = specialAttackCount;
    }

}
