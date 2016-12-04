package mappings.inhumans;

import mappings.base.Hero;
import mappings.base.Race;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Troll extends Hero{

    private static final Integer id = 6;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        Troll.attributesMap.put("life", 2800);
        Troll.attributesMap.put("mana", 20);
        Troll.attributesMap.put("strength", 100);
        Troll.attributesMap.put("abilityPower", 20);
        Troll.attributesMap.put("armor", 100);
        Troll.attributesMap.put("magicResist", 20);
        Troll.attributesMap.put("agility", 20);

        Troll.availableWeapons.add(Weapons.LETHAL_CLAW);

        Troll.availableSpells.add(Spells.POISONING);
    }

    public Troll() {
        super(id, Troll.attributesMap, Troll.availableWeapons, Troll.availableSpells, Race.INHUMAN);
    }
}
