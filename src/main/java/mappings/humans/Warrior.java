package mappings.humans;

import mappings.base.Hero;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mresende on 05/11/16.
 */
public class Warrior extends Hero {

    private static final Integer id = 1;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

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
    }

}
