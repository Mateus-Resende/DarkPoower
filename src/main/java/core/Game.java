package core;

import exceptions.InvalidAttackTypeException;
import exceptions.SpecialAttackNotAvailableException;
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
	private Boolean gameRunning;

	public Game(List<Player> players) {
		this.players = players;
		this.gameRunning = false;
	}

	/**
	 * Player que está jogando na rodada atual
	 * 
	 * @return Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	/**
	 * Somente pode ser setado um jogador que está registrado no jogo
	 * 
	 * @param p
	 */
	public void setCurrentPlayer(Player p) {
		if (players.contains(p)) {
			this.currentPlayer = p;
		}
	}

	/**
	 * Começar o jogo case já existam mais de dois usuários
	 * 
	 * @return
	 */
	public boolean startGame() {
		if (!this.gameRunning && !this.gameOver && this.players.size() > 2 && this.playersHaveEnoughHeroes()) {
			this.gameRunning = true;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Confere se os jogadores possuem pelo menos um herói selecionado
	 * 
	 * @return
	 */
	public Boolean playersHaveEnoughHeroes() {
		for (Player p : this.players) {
			if (p.getActiveHero().equals(null)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Informa o vencedor do jogo
	 * 
	 * @return um player ou nulo caso exista mais de um jogador vivo
	 */
	public Player getWinner() {
		Player winner = null;
		if (this.gameOver && !this.gameRunning) {
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

	/**
	 * Realiza acao do usuario. Parametrs podem ser nulos, caso nao sejam
	 * necessarios.
	 * 
	 * @param action
	 *            - Ação de turno que o usuário deseja realizar, continda em
	 *            {@link TurnAction}
	 * @param source
	 *            - Personagem do qual está vindo a ação (necessário que seja o
	 *            jogador atual)
	 * @param target
	 *            - Personagem ṕara o qual a ação está sendo direcionada, pode
	 *            ser nulo em caso a ação seja no mesmo usuário (e.g. healing)
	 * @param spell
	 *            - Magia que o usuário deseja utilizar na rodada, pode ser nula
	 * @param weapon
	 *            - Arma utilizada na roadada, pode ser nula
	 * @throws SpecialAttackNotAvailableException
	 *             - Ataque especial não disponível
	 * @throws InvalidAttackTypeException
	 *             - Tipo de ataque inválido para aquele hero
	 * @throws SpellNotAvailableForClass
	 *             - Magia indisponível para aquele hero
	 * @throws WeaponNotAvailableForClassException
	 *             - Arma indisponível para aquele hero
	 * @return true se ação foi feita com sucesso, se não false
	 */
	public Boolean doAction(TurnAction action, Player source, Player target, Spells spell, Weapons weapon,
			Boolean specialAttack) throws SpecialAttackNotAvailableException, InvalidAttackTypeException,
			SpellNotAvailableForClass, WeaponNotAvailableForClassException {
		Boolean actionSuccessfull = true;

		if (this.gameRunning && !this.gameOver && currentPlayer.equals(source) && !source.hasLost()
				&& players.contains(target) && !target.hasLost() && !source.equals(target)) {

			Hero sourceHero = source.getActiveHero();
			Hero targetHero = target.getActiveHero();

			/*
			 * Possíveis ações do usuário: atacar, curar, usar magia, passar a
			 * vez ou trocar de arma Turno só é finalizado em caso de ação bem
			 * sucedida
			 */
			switch (action) {
			case ATTACK:
				// confere se o usuário quer atacar com a arma que está equipada
				// no momento
				if (sourceHero.getEquippedWeapon().equals(weapon)) {
					Integer damageDealt = 0;
					// calcula o dano
					if (specialAttack && source.isSpecialAttackAvailable()) {
						damageDealt = sourceHero.specialAttack();
					} else if (!specialAttack) {
						damageDealt = sourceHero.attack();
					} else {
						throw new SpecialAttackNotAvailableException();
					}
					// usuário alvo recebe o dano
					sourceHero.receiveDamage(damageDealt, weapon);
					// fim de turno
					this.endTurn();
				}
				break;

			case HEAL:
				// herói de origem usa uma magia de cura específico
				Integer lifeHealed = sourceHero.useSpell(spell);
				// usuário alvo recebe o dano
				sourceHero.healLifePoints(lifeHealed);
				// fim de turno
				this.endTurn();
				break;

			case PASS:
				// passar a vez, somente termina o turno
				this.endTurn();
				break;

			case SPELL:
				try {
					// usa uma magia
					Integer damageDealt = sourceHero.useSpell(spell);
					// usuário alvo recebe o dano
					targetHero.receiveDamage(damageDealt, spell);
					// fim de turno
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
				// troca de arma
				sourceHero.setEquippedWeapon(weapon);
				// fim de turno
				this.endTurn();
				break;
			}
		}
		// retorna sucesso ou insucesso da ação do usuário
		return actionSuccessfull;
	}

	/**
	 * Termina o turno e seta o próximo player
	 */
	public void endTurn() {
		// se não existem vencedores, continua para o próximo turno
		if (this.getWinner() == null) {
			Integer nextPlayer = this.players.indexOf(this.currentPlayer) + 1;

			if (nextPlayer >= this.players.size()) {
				nextPlayer = 0;
			}
			// fim do turno adiciona 10 de mana
			this.currentPlayer.getActiveHero().addEndTurnMana();
			this.currentPlayer = this.players.get(nextPlayer);
			// início do turno adiciona à contagem de rodadas para ataques
			// especiais
			this.currentPlayer.addSpecialAttackCount();
		} else {
			// se existem vencedores, jogo termina
			this.gameOver = true;
			this.gameRunning = false;
		}
	}

	/**
	 * Retorna se o jogo terminou
	 * 
	 * @return true/false
	 */
	public Boolean getGameOver() {
		return gameOver;
	}

	/**
	 * Seta o fim do jogo
	 * 
	 * @param gameOver
	 */
	public void setGameOver(Boolean gameOver) {
		this.gameOver = gameOver;
		this.gameRunning = !gameOver;
	}
}