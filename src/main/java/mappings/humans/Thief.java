package mappings.humans;

import mappings.base.Hero;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mresende on 05/11/16.
 */
public class Thief extends Hero {

    private static final Integer id = 2;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

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
    }
}
