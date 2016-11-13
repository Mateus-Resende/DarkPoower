package mappings.humans;

import mappings.base.Hero;
import mappings.base.Race;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warrior extends Hero {

    private static final Integer id = 1;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        Warrior.attributesMap.put("life", 4000);
        Warrior.attributesMap.put("mana", 30);
        Warrior.attributesMap.put("strength", 100);
        Warrior.attributesMap.put("abilityPower", 20);
        Warrior.attributesMap.put("armor", 80);
        Warrior.attributesMap.put("magicResist", 20);
        Warrior.attributesMap.put("agility", 50);

        Warrior.availableWeapons.add(Weapons.BAROQUE_SWORD);
        Warrior.availableWeapons.add(Weapons.CLUB);

        Warrior.availableSpells.add(Spells.STORM);
    }

    public Warrior() {

        super(id, Warrior.attributesMap, Warrior.availableWeapons, Warrior.availableSpells, Race.HUMAN);
    }

}
