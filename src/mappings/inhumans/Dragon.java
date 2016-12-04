package mappings.inhumans;

import mappings.base.Hero;
import mappings.base.Race;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dragon extends Hero{

    private static final Integer id = 7;

    private static final String name = "Dragon";

    private static Map<String, Integer> attributesMap = new HashMap<String, Integer>();

    private static final List<Weapons> availableWeapons = new ArrayList<Weapons>();

    private static final List<Spells> availableSpells = new ArrayList<Spells>();

    static {
        Dragon.attributesMap.put("life", 3000);
        Dragon.attributesMap.put("mana", 40);
        Dragon.attributesMap.put("strength", 100);
        Dragon.attributesMap.put("abilityPower", 20);
        Dragon.attributesMap.put("armor", 100);
        Dragon.attributesMap.put("magicResist", 50);
        Dragon.attributesMap.put("agility", 80);

        Dragon.availableWeapons.add(Weapons.CLUB);
        Dragon.availableWeapons.add(Weapons.STAFF);

        Dragon.availableSpells.add(Spells.FIRE_BREATH);
    }

    public Dragon() {
        super(id, Dragon.attributesMap, Dragon.availableWeapons, Dragon.availableSpells, Race.INHUMAN);

    }
    
    @Override
    public String toString() {
        return "Dragao";
    }
}
