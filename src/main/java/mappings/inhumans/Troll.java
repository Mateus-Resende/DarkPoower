package mappings.inhumans;

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
public class Troll extends Hero{

    private static final Integer id = 6;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        attributesMap.put("life", 2800);
        attributesMap.put("mana", 20);
        attributesMap.put("strength", 100);
        attributesMap.put("abilityPower", 20);
        attributesMap.put("armor", 100);
        attributesMap.put("magicResist", 20);
        attributesMap.put("agility", 20);
    }

    public Troll() {
        super(id, name, attributesMap);
        this.availableWeapons.add(Weapons.LETHAL_CLAW);

        this.availableSpells.add(Spells.POISONING);
    }
}
