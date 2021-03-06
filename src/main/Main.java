package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ini4j.InvalidFileFormatException;

import config.Config;
import config.ConfigReader;
import data.Ability;
import data.Game;
import data.Nature;
import data.Species;
import data_struct.IVs;
import data_struct.PlayerPokemon;
import data_struct.Pokemon;
import player.Constants;
import player.Party;
import player.Player;
import route_file.GameActionPerformable;
import route_file.RouteParser;
import utility.RouteThreeStringBuffer;

public class Main {
	public static Config config;
	
	// Initialise player from config
	public static Player generatePlayerFromConfig(Config config) {
		Player player;
		
		// Init player
		String gameStr = config.getGame();
		Game game = Game.getGameFromString(gameStr);
		
		player = new Player(game);
		
		// Init party
		Party party = player.getParty();
		
		String[] speciesArr = config.getSpeciesArr();
		String[] natures = config.getNatures();
		String[] abilities = config.getAbilities();
		int[] levels = config.getLevels(); 
		int[] hpIVs = config.getHpIVs();
		int[] atkIVs = config.getAtkIVs();
		int[] defIVs = config.getDefIVs();
		int[] speIVs = config.getSpeIVs();
		int[] spaIVs = config.getSpaIVs();
		int[] spdIVs = config.getSpdIVs();
		
		try {
			for(int i = 0; i < speciesArr.length; i++) { // TODO : better checking for unequal array lengths ?
				Species species = Species.getSpeciesFromString(speciesArr[i]);
				Nature nature = Nature.getNatureFromString(natures[i]);
				Ability ability = Ability.getAbilityFromString(abilities[i]);
				int abilitySlot = species.getSlotFromAbility(ability);
				int level = levels[i];
				int hpIV = hpIVs[i];
				int atkIV = atkIVs[i];
				int defIV = defIVs[i];
				int speIV = speIVs[i];
				int spaIV = spaIVs[i];
				int spdIV = spdIVs[i];
				IVs ivs = new IVs(hpIV, atkIV, defIV, speIV, spaIV, spdIV);

				Pokemon pokemon = new Pokemon(game, species, nature, abilitySlot, level, ivs);
				PlayerPokemon playerPokemon = new PlayerPokemon(player, pokemon);
				
				party.add(playerPokemon);
			}
			
			player.setParty(party);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

		return player;
	}
	
	public static void main(String[] args) {
		try {
			Config config = ConfigReader.readConfigFile();
			Player player = generatePlayerFromConfig(config);
			
			List<GameActionPerformable> actionList = RouteParser.parseRouteFile(config.getRouteFilename());
			System.out.println(actionList); //TODO remove

			RouteThreeStringBuffer outputBuffer = new RouteThreeStringBuffer();
			for(GameActionPerformable action : actionList) {
				action.performAction(player, outputBuffer);
			}
			
			System.out.println(outputBuffer);
			
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
