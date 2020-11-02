package data;

import java.util.ArrayList;
import java.util.Arrays;

public class RegionsData {
	private final static ArrayList<String> REGIONS = new ArrayList<String>(Arrays.asList("Bordeaux", "Bourgogne", "Champagne", "Languedoc", "Loire", "Normandie"));
	
	public static ArrayList<String> getRegionsList() {
		return REGIONS;
	}
}
