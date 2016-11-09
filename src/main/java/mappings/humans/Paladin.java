package mappings.humans;

import mappings.base.Hero;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mresende on 05/11/16.
 */
public class Paladin extends Hero {

    private static final Integer id = 4;

    private static final String name = "Paladin";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

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
    }

}
