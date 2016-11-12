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
public class Animal extends Hero {

    private static final Integer id = 5;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        attributesMap.put("life", 3200);
        attributesMap.put("mana", 30);
        attributesMap.put("strength", 80);
        attributesMap.put("abilityPower", 20);
        attributesMap.put("armor", 90);
        attributesMap.put("magicResist", 20);
        attributesMap.put("agility", 50);
    }

    public Animal() {
        super(id, name, attributesMap);
        this.availableWeapons.add(Weapons.LETHAL_CLAW);

        this.availableSpells.add(Spells.BIO_ANTRAX);
    }



}
