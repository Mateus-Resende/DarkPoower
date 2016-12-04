package exceptions;

import mappings.base.Hero;
import mappings.base.Weapons;

/**
 * Created by mresende on 13/11/16.
 */
public class WeaponNotAvailableForClassException extends Exception {


    public WeaponNotAvailableForClassException(Weapons w, Hero h) {
        this("This class " + h.getClass().getName() + "is not allowed to use the weapon " + w.getClass().getName());
    }

    public WeaponNotAvailableForClassException(String message) {
        super(message);
    }
}
