package mappings.base;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Player {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("heroes")
    private List<Hero> heroes;

    @JsonProperty("activeHero")
    private Hero activeHero;
    
    private Integer specialAttackCount;

    public Player(String name){
        this.name = name;
    }

    public Boolean hasLost() {
        return this.hasAliveHeroes();
    }

    private Boolean hasAliveHeroes() {
        Boolean aliveHeroes = false;

        for (Hero h : heroes) {
            if (!h.isHeroDead()) {
                return true;
            }
        }

        return aliveHeroes;
    }
    
    public Integer getSpecialAttackCount() {
    	return this.specialAttackCount;
    }
    
    public void addSpecialAttackCount() {
    	this.specialAttackCount += 1;
    }
    
    public Boolean isSpecialAttackAvailable() {
    	return this.specialAttackCount >= 10;
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
