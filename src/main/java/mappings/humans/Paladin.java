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
public class Paladin extends Hero {

    private static final Integer id = 4;

    private static final String name = "Paladin";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        attributesMap.put("life", 3200);
        attributesMap.put("mana", 80);
        attributesMap.put("strength", 60);
        attributesMap.put("abilityPower", 60);
        attributesMap.put("armor", 60);
        attributesMap.put("magicResist", 60);
        attributesMap.put("agility", 60);
    }

    public Paladin() {
        super(id, name, attributesMap);

        this.availableWeapons.add(Weapons.SACRED_TRIDENT);
        this.availableWeapons.add(Weapons.CROSSBOW);

        this.availableSpells.add(Spells.HEALTH_POTION);
        this.availableSpells.add(Spells.ICE_FLAME);
        this.availableSpells.add(Spells.STORM);
    }

}
