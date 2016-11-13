package mappings.humans;

import mappings.base.Hero;
import mappings.base.Race;
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
        Mage.attributesMap.put("life", 2500);
        Mage.attributesMap.put("mana", 100);
        Mage.attributesMap.put("strength", 40);
        Mage.attributesMap.put("abilityPower", 100);
        Mage.attributesMap.put("armor", 30);
        Mage.attributesMap.put("magicResist", 100);
        Mage.attributesMap.put("agility", 40);

        Mage.availableWeapons.add(Weapons.SACRED_TRIDENT);
        Mage.availableWeapons.add(Weapons.STAFF);

        Mage.availableSpells.add(Spells.HEALTH_POTION);
        Mage.availableSpells.add(Spells.BIO_ANTRAX);
        Mage.availableSpells.add(Spells.HEALING);
        Mage.availableSpells.add(Spells.ICE_FLAME);
        Mage.availableSpells.add(Spells.POISONING);
        Mage.availableSpells.add(Spells.STORM);
    }

    public Mage() {
        super(id, Mage.attributesMap, Mage.availableWeapons, Mage.availableSpells, Race.HUMAN);
    }

}
