package mappings.humans;

import mappings.base.Hero;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mresende on 05/11/16.
 */
public class Warrior extends Hero {

    private static final Integer id = 1;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        attributesMap.put("life", 4000);
        attributesMap.put("mana", 30);
        attributesMap.put("strength", 100);
        attributesMap.put("abilityPower", 20);
        attributesMap.put("armor", 80);
        attributesMap.put("magicResist", 20);
        attributesMap.put("agility", 50);
    }

    public Warrior() {
        super(id, name, attributesMap);

        this.availableWeapons.add(Weapons.BAROQUE_SWORD);
        this.availableWeapons.add(Weapons.CLUB);

        this.availableSpells.add(Spells.STORM);
    }

}
