package mappings.base;

public enum Weapons {

    ATTACK_SPHERE   (300), // Esfera de ataque
    BAROQUE_SWORD   (400), // Espada barroca
    CLUB            (280), // Porrete
    CROSSBOW        (320), // Besta
    LETHAL_CLAW     (200), // Garra Letal
    SACRED_TRIDENT  (320), // Tridente Sagrado
    STAFF           (100); // Cajado

    private Integer damage;

    Weapons(int damage) {
        this.damage = damage;
    }

    public Integer getDamage() {
        return this.damage;
    }
}
