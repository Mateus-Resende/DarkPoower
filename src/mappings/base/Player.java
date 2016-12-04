package mappings.base;

import java.util.ArrayList;
import java.util.List;


public class Player {

    private final String name;

    private List<Hero> heroes;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    private Hero activeHero;
    
    private Integer specialAttackCount;

    public Player(String name){
        this.name = name;
        this.heroes = new ArrayList();
    }
    
    public Boolean isReady() {
        return this.heroes.size() == 2;
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
            if (this.activeHero == null) {
                this.activeHero = this.heroes.get(0);
            }
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
