package core;

import exceptions.InvalidAttackTypeException;
import exceptions.SpellNotAvailableForClass;
import exceptions.WeaponNotAvailableForClassException;
import mappings.base.Hero;
import mappings.base.Player;
import mappings.base.Spells;
import mappings.base.Weapons;

import java.util.List;

/**
 * responsável pela lógica de negócio dos turnos
 */
public class Game {

    private List<Player> players;
    private Player currentPlayer;
    private Boolean gameOver;

    public Game(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player p) {
        if (players.contains(p)) {
            this.currentPlayer = p;
        }
    }

    public boolean startGame() {
        if (!this.gameOver && this.players.size() > 2) {
            return true;
        } else {
            return false;
        }
    }

    public Player getWinner() {
        Player winner = null;
        if (this.gameOver) {
            for (Player p : players) {
                if (!p.hasLost()) {
                    if (winner == null) {
                        winner = p;
                    } else {
                        return null;
                    }
                }
            }
        }
        return winner;
    }

    public Boolean doAction(TurnAction action, Player source, Player target, Spells spell, Weapons weapon) {
        Boolean actionSuccessfull = true;

        if (currentPlayer.equals(source) && !source.hasLost() && players.contains(target) && !target.hasLost() && !source.equals(target)) {

            Hero sourceHero = source.getActiveHero();
            Hero targetHero = target.getActiveHero();

            switch (action) {
                case ATTACK:
                    try {
                        Integer damageDealt = sourceHero.attack();
                        sourceHero.receiveDamage(damageDealt, weapon);
                        this.endTurn();
                    } catch (InvalidAttackTypeException e) {
                        actionSuccessfull = false;
                        e.printStackTrace();
                    }
                    break;

                case HEAL:
                    try {
                        Integer lifeHealed = sourceHero.useSpell(spell);
                        sourceHero.healLifePoints(lifeHealed);
                        this.endTurn();
                    } catch (SpellNotAvailableForClass spellNotAvailableForClass) {
                        actionSuccessfull = false;
                        spellNotAvailableForClass.printStackTrace();
                    }
                    break;

                case PASS:
                    this.endTurn();
                    break;

                case SPELL:
                    try {
                        Integer damageDealt = sourceHero.useSpell(spell);
                        targetHero.receiveDamage(damageDealt, spell);
                        this.endTurn();
                    } catch (SpellNotAvailableForClass spellNotAvailableForClass) {
                        actionSuccessfull = false;
                        spellNotAvailableForClass.printStackTrace();

                    } catch (InvalidAttackTypeException invalidAttackTypeException) {
                        actionSuccessfull = false;
                        invalidAttackTypeException.printStackTrace();
                    }

                    break;

                case SWITCH_WEAPON:
                    try {
                        sourceHero.setEquippedWeapon(weapon);
                        this.endTurn();
                    } catch (WeaponNotAvailableForClassException weaponNotAvailableForClassException) {
                        actionSuccessfull = false;
                        weaponNotAvailableForClassException.printStackTrace();
                    }
                    break;
            }
        }

        return actionSuccessfull;
    }

    public void endTurn() {
        Integer nextPlayer = this.players.indexOf(this.currentPlayer) + 1;

        if (nextPlayer >= this.players.size()) {
            nextPlayer = 0;
        }

        this.currentPlayer = this.players.get(nextPlayer);
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }
}
