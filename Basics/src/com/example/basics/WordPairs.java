package com.example.basics;

import java.util.Random;

public class WordPairs {
	String[] WordList = new String[]{
			"WINTER",
			"AUTUMN",
			"SUMMER",
			"COMBAT",
			"FATMAN",
			"DAMAGE",
			"BULLET",
			"ACCESS",
			"VISION",
			"ACUITY",
			"ADDICT",
			"CASUAL",
			"RANDOM",
			"BROKEN",
			"INVEST",
			"RECOIL",
			"ROTTEN",
			"SKULLS",
			"CORPSE",
			"SEASON",
			"LIZARD",
			"RETINA",
			"REASON",
			"EDITOR",
			"BUNKER",
			"FEEDER",
			"HACKER",
			"LEGION",
			"ARTIST",
			"ENLIST",
			"ASSIST",
			"PURIST",
			"SADIST",
			"BANISH",
			"CAESAR",
			"COSMIC",
			"DEDUCT",
			"HEROIC",
			"HEROIN",
			"INVENT",
			"KERNEL",
			"KEVLAR",
			"DEVILS",
			"LAPTOP",
			"COFFEE",
			"LUSTER",
			"MOHAWK",
			"PANDAS",
			"PHOTOS",
			"PILOTS",
			"RECALL",
			"RECITE",
			"SHEILD",
			"SWORDS",
			"SPEARS",
			"ARROWS",
			"SPIDER",
			"WRITER",
			"ZIPPER",
			"ZEALOT",
			"WHISKY",
			"TRAVEL",
			"TRAUMA",
			"TATTOO",
			"TEAPOT",
			"SOURCE",
			"SLEEVE",
			"SAVIOR",
			"PRISON",
			"WARDEN",
			"VERBUM",
			"RABIES",
			"CANNON",
			"PEANUT",
			"OLIVES",
			"LOOPER",
			"SAILOR",
			"TAILOR",
			"TINKER",
			"WIZARD",
			"BOXING",
			"WARGUN",
			"LAWYER",
			"JAGUAR",
			"HUMVEE",
			"HIDDEN",
			"GARLIC",
			"BOILER",
			"EXOTIC",
			"EASTER",
			"DECREE",
			"CLEVER",
			"SENSOR",
			"CANDLE",
			"ABUSER",
			"AURORA",
			"BISTRO",
			"BYGONE",
			"CARPET",
			"DECAYS",
			"DECEIT"
			};
	int stringLen=100;

	public String Getwords() {
		Random rand = new Random(); 
		int randomInt = rand.nextInt(stringLen);
		//randomInt = (int) Math.random()*18;
		return WordList[randomInt];
	}

	public int CheckPairs(String word,String wordcorrect){
		int num=0;
		String combine = word;

		for (int i = 0; i <= 5; i++) {
			if (wordcorrect.charAt(i) == combine.charAt(i)) {
				num++;
			}
		}
		
		return num;
	}
	
	public String Getcorrect(){
		String[] CorrectList = new String[]{
				"WINTER",
				"AUTUMN",
				"SUMMER",
				"COMBAT",
				"FATMAN",
				"DAMAGE",
				"BULLET",
				"ACCESS",
				"VISION",
				"ACUITY",
				"ADDICT",
				"CASUAL",
				"RANDOM",
				"BROKEN",
				"INVEST",
				"RECOIL",
				"ROTTEN",
				"SKULLS",
				"CORPSE",
				"SEASON",
				"LIZARD",
				"RETINA",
				"REASON",
				"EDITOR",
				"BUNKER",
				"FEEDER",
				"HACKER",
				"LEGION",
				"ARTIST",
				"ENLIST",
				"ASSIST",
				"PURIST",
				"SADIST",
				"BANISH",
				"CAESAR",
				"COSMIC",
				"DEDUCT",
				"HEROIC",
				"HEROIN",
				"INVENT",
				"KERNEL",
				"KEVLAR",
				"DEVILS",
				"LAPTOP",
				"COFFEE",
				"LUSTER",
				"MOHAWK",
				"PANDAS",
				"PHOTOS",
				"PILOTS",
				"RECALL",
				"RECITE",
				"SHEILD",
				"SWORDS",
				"SPEARS",
				"ARROWS",
				"SPIDER",
				"WRITER",
				"ZIPPER",
				"ZEALOT",
				"WHISKY",
				"TRAVEL",
				"TRAUMA",
				"TATTOO",
				"TEAPOT",
				"SOURCE",
				"SLEEVE",
				"SAVIOR",
				"PRISON",
				"WARDEN",
				"VERBUM",
				"RABIES",
				"CANNON",
				"PEANUT",
				"OLIVES",
				"LOOPER",
				"SAILOR",
				"TAILOR",
				"TINKER",
				"WIZARD",
				"BOXING",
				"WARGUN",
				"LAWYER",
				"JAGUAR",
				"HUMVEE",
				"HIDDEN",
				"GARLIC",
				"BOILER",
				"EXOTIC",
				"EASTER",
				"DECREE",
				"CLEVER",
				"SENSOR",
				"CANDLE",
				"ABUSER",
				"AURORA",
				"BISTRO",
				"BYGONE",
				"CARPET",
				"DECAYS",
				"DECEIT"
				};
		Random rand = new Random(); 
		int randomInt = rand.nextInt(stringLen);
		//int randomInt = (int) Math.random()*18;
	    return CorrectList[randomInt];
	}
	
	public boolean CheckRecursion(String word,String[] array){
		for(int a = 0;a<=8;a++)
		{
			if(word.equals(array[a]))
					{
				return true;
					}
		}
		return false;
	}
	
	public class LinkedList{
		
		}
}
