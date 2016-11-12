package mappings.humans;

import mappings.base.Hero;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paladin extends Hero {

    private static final Integer id = 4;

    private static final String name = "Paladin";
    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();
    private static final List<Spells> availableSpells = new ArrayList<Spells>();
    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    static {
        attributesMap.put("life", 3200);
        attributesMap.put("mana", 80);
        attributesMap.put("strength", 60);
        attributesMap.put("abilityPower", 60);
        attributesMap.put("armor", 60);
        attributesMap.put("magicResist", 60);
        attributesMap.put("agility", 60);

        Paladin.availableWeapons.add(Weapons.SACRED_TRIDENT);
        Paladin.availableWeapons.add(Weapons.CROSSBOW);

        Paladin.availableSpells.add(Spells.HEALTH_POTION);
        Paladin.availableSpells.add(Spells.ICE_FLAME);
        Paladin.availableSpells.add(Spells.STORM);
    }

    public Paladin() {
        super(id, Paladin.attributesMap, Paladin.availableWeapons, Paladin.availableSpells);
    }

}
