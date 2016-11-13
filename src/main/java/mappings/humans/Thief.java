package mappings.humans;

import mappings.base.Hero;
import mappings.base.Race;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thief extends Hero {

    private static final Integer id = 2;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        Thief.attributesMap.put("life", 2800);
        Thief.attributesMap.put("mana", 50);
        Thief.attributesMap.put("strength", 50);
        Thief.attributesMap.put("abilityPower", 30);
        Thief.attributesMap.put("armor", 40);
        Thief.attributesMap.put("magicResist", 50);
        Thief.attributesMap.put("agility", 100);

        Thief.availableWeapons.add(Weapons.CLUB);
        Thief.availableWeapons.add(Weapons.STAFF);
        Thief.availableWeapons.add(Weapons.CROSSBOW);
        Thief.availableWeapons.add(Weapons.ATTACK_SPHERE);

        Thief.availableSpells.add(Spells.POISONING);
        Thief.availableSpells.add(Spells.STORM);
    }

    public Thief() {
        super(id, Thief.attributesMap, Thief.availableWeapons, Thief.availableSpells, Race.HUMAN);


    }
}
