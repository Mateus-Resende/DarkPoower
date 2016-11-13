package exceptions;

import mappings.base.Hero;
import mappings.base.Spells;

/**
 * Created by mresende on 13/11/16.
 */
public class SpellNotAvailableForClass extends Exception {
    public SpellNotAvailableForClass(Spells s, Hero h) {
        this("This class " + h.getClass().getName() + "is not allowed to use the weapon " + s.getClass().getName());
    }

    public SpellNotAvailableForClass(String message) {
        super(message);
    }
}
