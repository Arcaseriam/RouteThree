package config;

import java.io.File;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import utility.RouteThreeStringBuffer;

public class ConfigReader {
	public static RouteThreeStringBuffer output = new RouteThreeStringBuffer();
	
	public static Config readConfigFile() throws InvalidFileFormatException, IOException {
		return readConfigFile(null);
	}
	
	// Simply compiles config elements into a Config object
	public static Config readConfigFile(String filename) 
			throws InvalidFileFormatException, IOException {
		if (filename == null) {
			filename = Constants.DEFAULT_CONFIG_FILENAME;
		}
			
        Wini wini = null;
        org.ini4j.Config winiConfig = new org.ini4j.Config(); 
        winiConfig.setMultiOption(true);
        wini = new Wini();
        wini.setConfig(winiConfig);
        wini.load(new File(filename));
        
        // [game]
        String gameName = wini.get("game", "game");
           
        // [party]
        Wini.Section partySection = wini.get("party");
        String[] speciesArr = partySection.getAll("species", String[].class);
        String[] natures = partySection.getAll("nature", String[].class);
        String[] abilities = partySection.getAll("ability", String[].class);
        int[] levels = partySection.getAll("level", int[].class);
        int[] hpIVs = partySection.getAll("hpIV", int[].class);
        int[] atkIVs = partySection.getAll("atkIV", int[].class);
        int[] defIVs = partySection.getAll("defIV", int[].class);
        int[] speIVs = partySection.getAll("speIV", int[].class);
        int[] spaIVs = partySection.getAll("spaIV", int[].class);
        int[] spdIVs = partySection.getAll("spdIV", int[].class);       

        // [files]
        String routeFilename = wini.get("files", "routeFile");
        String outputFilename = wini.get("files", "outputFile");
        
        Config config = new Config(
        		gameName, speciesArr, natures, abilities, levels,
        		hpIVs, atkIVs, defIVs, speIVs, spaIVs, spdIVs,
        		routeFilename, outputFilename
        		);
        
        return config;		
	}
}
