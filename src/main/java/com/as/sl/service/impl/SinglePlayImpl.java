package com.as.sl.service.impl;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.as.sl.constants.CommonConstants;
import com.as.sl.entities.Game;
import com.as.sl.entities.Player;
import com.as.sl.service.PlayService;
import com.as.sl.utils.CommonUtils;
import com.as.sl.utils.DiceUtils;

public class SinglePlayImpl implements PlayService {

	CommonUtils utils;
	
	public SinglePlayImpl(){
		utils = CommonUtils.getInstance();
	}
	
	@Override
	public void play(Game game) {
		TreeSet<Player> players = game.getPlayers();
		int turns = game.getNumOfTurns();
		for(int i=0; i< turns; i++) {
			System.out.println(CommonConstants.PLUS_SIGN_LINE);
			System.out.println("Turn: " + (i + 1));
			for(Player player : players) {
				System.out.println(player.getPlayerId() +CommonConstants.TURN);
				if(!player.getPlayerId().equalsIgnoreCase(CommonConstants.SYSTEM)) {
					System.out.println(CommonConstants.PRESS_ENTER);
					try {
						utils.readLine();
					}
					catch(Exception e) {
					}
				}
				int pos = DiceUtils.getValueAfterDiceThrow(game, player.getPosition());
				player.setPosition(pos);
				System.out.println(CommonConstants.UPDATE_POSITION + player.getPlayerId() + ": " + pos);
			}
		}
		
	}
}
