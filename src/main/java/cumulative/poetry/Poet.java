/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cumulative.poetry;

import java.util.HashMap;
import java.util.Map;

public class Poet {
	private final static int RECITE_FOR_DAY = 0;
	private final static int RECITE_POEM = 1;
	private final static String FLAG_RECITE_FOR_DAY_STR = "--reveal-for-day";
	private final static String FLAG_RECITE_POEM_STR = "--recite";
	private final static String FLAG_ECHO_STR = "--echo";
	
	private static final String POEM_START = "This is ";
	private static final String POEM_END = ".";

	private static int reciteOption;
	private static int day;
	private static boolean echo=false;
	private static int echoCount = 0;
	
	private Map<Integer,String> poetryBook;

	public  Poet() {
		poetryBook = new HashMap<Integer,String>();
		poetryBook.put(new Integer(1), "the house that Jack built");
		poetryBook.put(new Integer(2), "the malth that lay in");
		poetryBook.put(new Integer(3), "the rat that ate");
		poetryBook.put(new Integer(4), "the cat that killed");
		poetryBook.put(new Integer(5), "the dog that worried");
		poetryBook.put(new Integer(6), "that cow with the crumpled horn that tossed");
		poetryBook.put(new Integer(7), "the maiden all forlorn that milked");
		poetryBook.put(new Integer(8), "the man all tattered and torn that kissed");
		poetryBook.put(new Integer(9), "the priest all shaven and shorn that married");
		poetryBook.put(new Integer(10), "the rooster that crowed in the morn that woke");
		poetryBook.put(new Integer(11), "the farmer sowing his corn that kept");
		poetryBook.put(new Integer(12), "the horse and the hound and the horn that belonged to");
	}

	public static void main(String[] args) {
		Poet p = new Poet();

		RuntimeArgs.parse(args);

		if(RuntimeArgs.flagPresent(FLAG_RECITE_FOR_DAY_STR)){
				reciteOption = RECITE_FOR_DAY;
				day = RuntimeArgs.getFlagValue(FLAG_RECITE_FOR_DAY_STR); 
		}
		else if(RuntimeArgs.flagPresent(FLAG_RECITE_POEM_STR)) {
				reciteOption = RECITE_POEM;		
		}
		if(RuntimeArgs.flagPresent(FLAG_ECHO_STR)) {
			echo = true;
			echoCount = 1;
		}
		String poem = p.recite();
		System.out.println(poem);		
	}
	public String recite() {
		String result = "";
		if (reciteOption == RECITE_FOR_DAY) {
			result = readPoem(day);
		} else if (reciteOption == RECITE_POEM) {
			StringBuilder builder = new StringBuilder();
			for (int i = 1; i <= 12; i++) {
				  builder.append("Day ").append(i).append("\n");
				  builder.append(readPoem(i)).append("\n");
			}
			result = builder.toString();
		}

		return result;
	}

	private String readPoem(int vForTheDay) {
		StringBuilder poem = new StringBuilder();
		poem.append(POEM_START);
		for (int i = vForTheDay; i > 0; i--) {
			for(int j = 0; j < (echoCount+1); j++) {
				poem.append(poetryBook.get(i)).append("\n").append("\t");
			}
		}
		poem.deleteCharAt(poem.length()-1);
		poem.deleteCharAt(poem.length()-1);

		poem.append(POEM_END);
		return poem.toString();
	}
	/**
	 * read runtime arguments for main
	 * @author hp
	 *
	 */
	static class RuntimeArgs {
		  private static HashMap<String, Integer> flags = new HashMap<String, Integer>();

		public static void  parse(String[] arguments) {
			for (int i = 0; i < arguments.length; i++) {
				if (arguments[i].startsWith("-")) {
					String flag = arguments[i];
					if ((i+1) < arguments.length && !arguments[i+1].startsWith("-")) 
						flags.put(flag, new Integer(arguments[++i]));
					else
						flags.put(flag,null);
				}
			}
		  }
		
		  private static boolean flagPresent(String flag) {
			    return flags.containsKey(flag);			  
		  }

		private static Integer getFlagValue(String flag) {
			return flags.get(flag);
		}
	}

}
