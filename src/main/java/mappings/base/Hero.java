package mappings.base;

import java.util.List;
import java.util.Map;

import exceptions.InvalidAttackTypeException;
import exceptions.SpecialAttackNotAvailableException;
import exceptions.SpellNotAvailableForClass;
import exceptions.WeaponNotAvailableForClassException;

public class Hero {

    private static final Integer SPECIAL_ATTACK_MULTIPLIER = 2;

    private final Integer id;
    private final Map<String, Integer> attributes;
    private final List<Weapons> availableWeapons;
    private final List<Spells> availableSpells;
    private final Race race;
    
    private Integer lifePoints;
    private Integer manaPoints;
    private Integer strength;
    private Integer abilityPower;
    private Integer armor;
    private Integer magicResist;
    private Integer agility;
    private Weapons equippedWeapon;

    /**
     * criação de herói com os atributos desejados, devem vir da classe que está extendendo herói
     * @param id
     * @param attributes
     * @param availableWeapons
     * @param availableSpells
     * @param race
     */
    public Hero(Integer id, Map<String, Integer> attributes, List<Weapons> availableWeapons, List<Spells> availableSpells, Race race) {
        this.id = id;
        this.attributes = attributes;
        this.availableSpells = availableSpells;
        this.availableWeapons = availableWeapons;
        this.equippedWeapon = this.getLowestDamageWeapon();
        this.race = race;
    }

    /**
     * herói sempre inicial com a arma de menor ataque
     * @return arma de menor ataque disponível
     */
    private Weapons getLowestDamageWeapon() {
        Weapons lowestDamage = this.availableWeapons.get(0);
        for (Weapons w : this.availableWeapons) {
            if (w.getDamage() < lowestDamage.getDamage()) {
                lowestDamage = w;
            }
        }
        return lowestDamage;
    }

    /**
     * Recebe o dano e diminui os valores de defesa
     * @param damage
     * @param type
     * @throws InvalidAttackTypeException
     */
    public void receiveDamage (Integer damage, Object type) throws InvalidAttackTypeException {
        if (type.getClass().equals(Spells.class)) {
            this.lifePoints -= damage - this.magicResist - this.agility;
        } else if (type.getClass().equals(Weapons.class)) {
            this.lifePoints -= damage - this.armor - this.agility;
        } else {
            throw new InvalidAttackTypeException();
        }
    }

    /**
     * Método para receber cura
     * @param healpoints
     */
    public void healLifePoints (Integer healpoints) {
        this.lifePoints += healpoints;
    }

    /**
     * Confere se o herói ainda está vivo
     * @return
     */
    public boolean isHeroDead(){
        return this.lifePoints <= 0;
    }

    /**
     * @return a arma equipada pelo herói
     */
    public Weapons getEquippedWeapon() {
        return this.equippedWeapon;
    }
    
    /**
     * Adiciona 10 de mana para o fim do turno
     */
    public void addEndTurnMana() {
        if (this.attributes.get("manapoints") > this.manaPoints) {
            this.manaPoints += 10;
        }
    }

    /**
     * Seta arma equipada
     * @param weapon
     * @throws WeaponNotAvailableForClassException - caso a arma não é disponível para esse hero
     */
    public void setEquippedWeapon(Weapons weapon) throws WeaponNotAvailableForClassException {
        if (this.availableWeapons.contains(weapon)) {
            this.equippedWeapon = weapon;
        } else {
            throw new WeaponNotAvailableForClassException(weapon, this);
        }
    }

    /**
     * Calcula valor de ataque usando arma
     * @return inteiro com o valor do ataque
     */
    public Integer attack() {
        return this.agility + this.equippedWeapon.getDamage() + this.strength;
    }

    /**
     * Usa ataque especial de inumanos
     * @return ataque multiplicado
     * @throws SpecialAttackNotAvailableException
     */
    public Integer specialAttack() throws SpecialAttackNotAvailableException {
        if (this.race.equals(Race.INHUMAN)) {
            return this.attack() * Hero.SPECIAL_ATTACK_MULTIPLIER;
        } else {
            throw new SpecialAttackNotAvailableException();
        }
    }

    /**
     * usa ataque especial de humanos
     * @param s - magia desejada
     * @return ataque multiplicado
     * @throws SpecialAttackNotAvailableException
     * @throws SpellNotAvailableForClass
     */
    public Integer specialAttack(Spells s) throws SpecialAttackNotAvailableException, SpellNotAvailableForClass {
        if (this.race.equals(Race.HUMAN) && !s.isHealingSpell()) {
            return this.useSpell(s) * Hero.SPECIAL_ATTACK_MULTIPLIER;
        } else {
            throw new SpecialAttackNotAvailableException();
        }
    }
    
	/**
	 * Usa magia especificada 
	 * @param s
	 * @return o valor do ataque
	 * @throws SpellNotAvailableForClass
	 */
    public Integer useSpell(Spells s) throws SpellNotAvailableForClass {
        if (this.availableSpells.contains(s)) {
            this.manaPoints -= s.getMana();
            return (s.isHealingSpell() ? s.getHeal() : s.getDamage()) + this.abilityPower;
        } else {
            throw new SpellNotAvailableForClass(s, this);
        }
    }

    /* ================================================
     * Getters e Setters para as variáveis do herói 
     * ================================================
     */
    
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
