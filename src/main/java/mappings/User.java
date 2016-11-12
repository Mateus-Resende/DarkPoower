package mappings;

import java.util.ArrayList;
import mappings.base.Hero;

/**
 * Created by mresende on 05/11/16.
 */
public class User {
    private final String name;
    private final ArrayList<Hero> Heros;

    public User(String name, ArrayList Heros) {
        this.name = name;
        this.Heros = Heros;
    }

    public String getName() {
        return name;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/
    
    
    
}
