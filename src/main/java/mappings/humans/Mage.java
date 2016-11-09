package mappings.humans;

import mappings.base.Hero;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mresende on 05/11/16.
 */
public class Mage extends Hero{

    private static final Integer id = 3;

    private static final String name = "Mage";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    static {
        attributesMap.put("life", 2500);
        attributesMap.put("mana", 100);
        attributesMap.put("strength", 40);
        attributesMap.put("abilityPower", 100);
        attributesMap.put("armor", 30);
        attributesMap.put("magicResist", 100);
        attributesMap.put("agility", 40);
    }

    public Mage() {
        super(id, name, attributesMap);
    }

}
