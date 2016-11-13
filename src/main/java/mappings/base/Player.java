package mappings.base;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import mappings.base.Hero;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Player {

    @JsonProperty("name")
    private String name;

    @JsonProperty("heroes")
    private List<Hero> heroes;

    @JsonProperty("activeHero")
    private Hero activeHero;

    public Player(){}

    public Player(String name) {
        this.name = name;
        this.heroes = new ArrayList<Hero>(2);
    }

    public Player(String name, List heroes) {
        this.name = name;
        this.heroes = heroes;
    }

    public String getName() {
        return name;
    }

    public void addHero(Hero h) {
        if (this.heroes.size() < 2) {
            this.heroes.add(h);
        }
    }

    public Hero getActiveHero() {
        return activeHero;
    }

    public void setActiveHero(Hero h) {

        if (this.heroes.contains(h)) {
            this.activeHero = h;
        }
    }

}
