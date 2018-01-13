// Alex Montague 2018
// class that will hold information for each watering session
// Consists of date, water names, initial start time, and waterLap classes that hold actual data

import java.util.*;

public class waterSession {
	
	public String splitDayName;	// D
	public String splitDay;		// D#
	public String splitMonth;	// M
	public String splitYear;		// Y
	public String waterNames;	// Name of Hand Waterers
	public String initialStart;	// Time session started
	public ArrayList<waterLap> lapList = new ArrayList<waterLap>();
	
	public waterSession() {  	// Default constructor
		this.splitDayName = "NULL";
		this.splitDay = "NULL";
		this.splitMonth = "NULL"; 
		this.splitYear = "NULL";
		waterNames = "NULL";
		initialStart = "NULL";
	}
	
	public waterSession(String startDate, String waterNames, String initialStart, String rawWaterData) { 	// Valid Constructor
		String dateSplit[] = startDate.split(" ");
		this.splitDayName = dateSplit[0];
		this.splitDay = dateSplit[2];		// Will contain suffix and , - get rid of
		this.splitMonth = dateSplit[1];
		this.splitYear = dateSplit[3];
		this.waterNames = waterNames;
		this.initialStart = initialStart;
		
		String split2[] = rawWaterData.split("<>");
		for(String j : split2) {								// each lap
			String split3[] = j.split("\\+");
			int count = 0;
			
			// Passed into Constructor Vars
			String waterLapNum = "";
			String actualStartTime = "";
			ArrayList<String> greenNumArray = new ArrayList<String>();
			ArrayList<String> wateredArray = new ArrayList<String>();
			ArrayList<String> tempsArray = new ArrayList<String>();		// All 3 will be contained ex. F = [0] M = [1] B = [2] ... 
			ArrayList<String> moisArray = new ArrayList<String>();	// Same goes for moistures ^
			ArrayList<String> notesArray = new ArrayList<String>();
			
			for(String k : split3) {							// each green
				if(count == 0) {								// If Green 1
					String split4[] = k.split("\\^");
					waterLapNum = split4[0];
					actualStartTime = split4[1];
					greenNumArray.add(split4[2]);
					wateredArray.add(split4[3]);
					tempsArray.add(split4[4]); 				// FRONT temp
					tempsArray.add(split4[5]);				// MID temp
					tempsArray.add(split4[6]);				// BACK temp
					moisArray.add(split4[7]);				// FRONT mois
					moisArray.add(split4[8]);				// MID mois
					moisArray.add(split4[9]);				// BACK mois
					notesArray.add(split4[10]);
					
					count++;
				}
				else {										// If not Green 1
					String split4[] = k.split("\\^");
					greenNumArray.add(split4[0]);
					wateredArray.add(split4[1]);
					tempsArray.add(split4[2]); 				// FRONT temp
					tempsArray.add(split4[3]);				// MID temp
					tempsArray.add(split4[4]);				// BACK temp
					moisArray.add(split4[5]);				// FRONT mois
					moisArray.add(split4[6]);				// MID mois
					moisArray.add(split4[7]);				// BACK mois
					notesArray.add(split4[8]);
				}
			}
			waterLap tempLap = new waterLap(waterLapNum, actualStartTime, greenNumArray, wateredArray, tempsArray, moisArray, notesArray);
			lapList.add(tempLap);
		}
		
	}
	
}
