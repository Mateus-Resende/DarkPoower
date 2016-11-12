package mappings.humans;

import mappings.base.Hero;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mage extends Hero {

    private static final Integer id = 3;

    private static final String name = "Mage";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        attributesMap.put("life", 2500);
        attributesMap.put("mana", 100);
        attributesMap.put("strength", 40);
        attributesMap.put("abilityPower", 100);
        attributesMap.put("armor", 30);
        attributesMap.put("magicResist", 100);
        attributesMap.put("agility", 40);
    }

    public Mage() {
        super(id, name, attributesMap);
        availableWeapons.add(Weapons.SACRED_TRIDENT);
        availableWeapons.add(Weapons.STAFF);

        availableSpells.add(Spells.HEALTH_POTION);
        availableSpells.add(Spells.BIO_ANTRAX);
        availableSpells.add(Spells.HEALING);
        availableSpells.add(Spells.ICE_FLAME);
        availableSpells.add(Spells.POISONING);
        availableSpells.add(Spells.STORM);
    }

}
