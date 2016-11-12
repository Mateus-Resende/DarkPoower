package mappings.inhumans;

import mappings.base.Hero;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Animal extends Hero {

    private static final Integer id = 5;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        Animal.attributesMap.put("life", 3200);
        Animal.attributesMap.put("mana", 30);
        Animal.attributesMap.put("strength", 80);
        Animal.attributesMap.put("abilityPower", 20);
        Animal.attributesMap.put("armor", 90);
        Animal.attributesMap.put("magicResist", 20);
        Animal.attributesMap.put("agility", 50);

        Animal.availableWeapons.add(Weapons.LETHAL_CLAW);

        Animal.availableSpells.add(Spells.BIO_ANTRAX);
    }

    public Animal() {
        super(id, Animal.attributesMap, Animal.availableWeapons, Animal.availableSpells);
    }



}
