package com.as.sl.entities;



import java.util.TreeMap;

import com.as.sl.constants.ExceptionConstants;
import com.as.sl.entities.dice.Dice;
import com.as.sl.entities.enums.DiceType;
import com.as.sl.entities.enums.GameType;
import com.as.sl.entities.factories.DiceFactory;
import com.as.sl.exception.SLException;

public class Game {
	String gameId;
	Board board;
	TreeMap<Player, Integer> players;
	Dice dice;
	GameType type;
	int numOfPlayer;
	int numOfTurns;
	
	public Game(String gameId, GameType gameType, DiceType type) {
		this.gameId = gameId;
		board = Board.getInstance();
		players = new TreeMap<Player, Integer>();
		this.type = gameType;
		dice = DiceFactory.getDice(type);
		numOfPlayer = 0;
		numOfTurns = 0;
	}
	
	public void addPlayer(String name, int sequence) {
		Player p = new Player(name, sequence);
		if(players.containsKey(p)) {
			throw new SLException(ExceptionConstants.PLAYER_EXIST, "");
		}
		players.put(p, 0);
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public TreeMap<Player, Integer> getPlayers() {
		return players;
	}

	public void setPlayers(TreeMap<Player, Integer> players) {
		this.players = players;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public GameType getType() {
		return type;
	}

	public void setType(GameType type) {
		this.type = type;
	}

	public int getNumOfPlayer() {
		return numOfPlayer;
	}

	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}

	public int getNumOfTurns() {
		return numOfTurns;
	}

	public void setNumOfTurns(int numOfTurns) {
		this.numOfTurns = numOfTurns;
	}
	
	
	
}
