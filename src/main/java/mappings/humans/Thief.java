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
public class Thief extends Hero {

    private static final Integer id = 2;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        attributesMap.put("life", 2800);
        attributesMap.put("mana", 50);
        attributesMap.put("strength", 50);
        attributesMap.put("abilityPower", 30);
        attributesMap.put("armor", 40);
        attributesMap.put("magicResist", 50);
        attributesMap.put("agility", 100);
    }

    public Thief() {
        super(id, name, attributesMap);

        this.availableWeapons.add(Weapons.CLUB);
        this.availableWeapons.add(Weapons.STAFF);
        this.availableWeapons.add(Weapons.CROSSBOW);
        this.availableWeapons.add(Weapons.ATTACK_SPHERE);

        this.availableSpells.add(Spells.POISONING);
        this.availableSpells.add(Spells.STORM);
    }
}
