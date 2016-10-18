package org.pilgrim.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Crypto {

	static Map<String, String> mapEn = new HashMap<>();
	static Map<String, String> mapDe = new HashMap<>();
	static {
		mapEn.put("a", "s");
		mapEn.put("b", "p");
		mapEn.put("c", "n");
		mapEn.put("d", "w");
		mapEn.put("e", "t");
		mapEn.put("f", "g");
		mapEn.put("g", "f");
		mapEn.put("h", "e");
		mapEn.put("i", "c");
		mapEn.put("j", "d");
		mapEn.put("k", "j");
		mapEn.put("l", "v");
		mapEn.put("m", "x");
		mapEn.put("n", "a");
		mapEn.put("o", "b");
		mapEn.put("p", "l");
		mapEn.put("q", "z");
		mapEn.put("r", "k");
		mapEn.put("s", "m");
		mapEn.put("t", "q");
		mapEn.put("u", "y");
		mapEn.put("v", "o");
		mapEn.put("w", "u");
		mapEn.put("x", "i");
		mapEn.put("y", "r");
		mapEn.put("z", "h");

		Set<Entry<String, String>> entrySet = mapEn.entrySet();
		for (Entry<String, String> entry : entrySet) {
			mapDe.put(entry.getValue(), entry.getKey());
		}
	}

	public static String crypt(String str, Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			String ch = "" + str.charAt(i);
			String dch = map.getOrDefault(ch, ch);
			sb.append(dch);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String str = scan.nextLine();
			if (!str.isEmpty()) {
				if(str.charAt(0)=='1')
				{
					String encrypted = crypt(str, mapEn);
					System.out.println("encrypted: " + encrypted);
				}
				if(str.charAt(0)=='2')
				{
					String decrypted = crypt(str, mapDe);
					System.out.println("decrypted: " + decrypted);
				}
			}
		}
	}

}
