package mappings.inhumans;

import mappings.base.Hero;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mresende on 05/11/16.
 */
public class Zombie extends Hero{

    private static final Integer id = 8;

    private static final String name = "Thief";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    static {
        attributesMap.put("life", 2500);
        attributesMap.put("mana", 20);
        attributesMap.put("strength", 40);
        attributesMap.put("abilityPower", 20);
        attributesMap.put("armor", 80);
        attributesMap.put("magicResist", 90);
        attributesMap.put("agility", 20);
    }

    public Zombie() {
        super(id, name, attributesMap);
    }

}
