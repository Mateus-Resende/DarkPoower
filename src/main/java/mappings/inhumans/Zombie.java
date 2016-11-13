package mappings.inhumans;

import mappings.base.Hero;
import mappings.base.Race;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zombie extends Hero{

    private static final Integer id = 8;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        Zombie.attributesMap.put("life", 2500);
        Zombie.attributesMap.put("mana", 20);
        Zombie.attributesMap.put("strength", 40);
        Zombie.attributesMap.put("abilityPower", 20);
        Zombie.attributesMap.put("armor", 80);
        Zombie.attributesMap.put("magicResist", 90);
        Zombie.attributesMap.put("agility", 20);

        Zombie.availableWeapons.add(Weapons.LETHAL_CLAW);
        Zombie.availableWeapons.add(Weapons.CLUB);
        Zombie.availableWeapons.add(Weapons.STAFF);

        Zombie.availableSpells.add(Spells.POISONING);
    }

    public Zombie() {
        super(id, Zombie.attributesMap, Zombie.availableWeapons, Zombie.availableSpells, Race.INHUMAN);
    }

}
