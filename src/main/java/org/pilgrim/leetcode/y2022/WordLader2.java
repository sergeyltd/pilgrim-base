package org.pilgrim.leetcode.y2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLader2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordLader2 wordLader2 = new WordLader2();

		String b = "cet";
		String e = "ism";
		List<String> words = new ArrayList<>(Arrays.asList(new String[] { "kid", "tag", "pup", "ail", "tun", "woo",
				"erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar",
				"die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay",
				"col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip",
				"fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box",
				"ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe",
				"pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac",
				"nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow",
				"fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara",
				"dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far",
				"mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin",
				"don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub",
				"bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad",
				"pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie",
				"nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum",
				"pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom",
				"vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe",
				"art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj",
				"hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you",
				"its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe",
				"ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir",
				"nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who",
				"bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin",
				"nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad",
				"rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen",
				"iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym",
				"dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit",
				"hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur",
				"sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug",
				"pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig",
				"hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov",
				"jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad",
				"nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan",
				"mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac",
				"baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran",
				"lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee",
				"ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl",
				"lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo",
				"win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot",
				"are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp",
				"ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob" }));
//		
//		List<List<String>> res = wordLader2.findLadders(b, e, words);
//		System.out.println(res.size());

		b = "hit";
		e = "cog";
		words = new ArrayList<>(Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" }));
		List<List<String>> res = wordLader2.findLadders(b, e, words);
		System.out.println(res.size());
	}

	// pattern to list of words
	Map<String, Set<String>> patToWordMap = new HashMap<>();

	// word to list of patterns
	Map<String, Set<String>> wordToPat = new HashMap<>();

	List<List<String>> result = new ArrayList<>();
	List<Set<String>> result2 = new ArrayList<>();
	Set<String> visited = new HashSet<>();
	Set<String> globalVisited = new HashSet<>();
	Set<String> allData = new HashSet<>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// Validate input
		if (beginWord == null || endWord == null || wordList == null) {
			return null;
		}

		wordList.add(beginWord);

		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
				patToWordMap.putIfAbsent(pattern, new HashSet<String>());
				patToWordMap.get(pattern).add(word);

				wordToPat.putIfAbsent(word, new HashSet<String>());
				wordToPat.get(word).add(pattern);
			}
		}

		LinkedList<String> path = new LinkedList<>();

//		visited.add(beginWord);
		int count = 1;
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		boolean found = false;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String node = q.poll();
				path.add(node);
				if (visited.contains(node)) {
					continue;
				}

				visited.add(node);

				if (node.equals(endWord)) {
					found = true;

//					visited.clear();
//					visited.add(beginWord);
//					path.add(beginWord);
//					dfs(beginWord, endWord, count - 1, path);
//					return result;
				}

				Set<String> patterns = wordToPat.get(node);
				for (String patt : patterns) {
					Set<String> wds = patToWordMap.get(patt);

					for (String wd : wds) {
						// if (!visited.contains(wd)) {
						q.add(wd);
						// visited.add(wd);
						// }
					}
				}
//				size--;
			}

			System.out.println(Arrays.toString(new HashSet<String>(path).toArray()));
			result.add(new ArrayList<String>(new HashSet<String>(path)));
			result2.add(new HashSet<String>(path));
			allData.addAll(path);
			path.clear();

			if (found) {
				break;
			}

			count++;
		}

		if (found) {
			wordToPat.clear();
			patToWordMap.clear();
			for (String word : allData) {
				for (int i = 0; i < word.length(); i++) {
					String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
					patToWordMap.putIfAbsent(pattern, new HashSet<String>());
					patToWordMap.get(pattern).add(word);

					wordToPat.putIfAbsent(word, new HashSet<String>());
					wordToPat.get(word).add(pattern);
				}
			}

			visited.clear();
			System.out.println("////////////////////////////////////////////////////////////");
			result.clear();
			path.clear();
			path.add(beginWord);
			dfs(beginWord, endWord, count - 1, path);

			for (List<String> lst : result) {
				System.out.println(Arrays.toString(lst.toArray()));
			}
		}
		else {
			result.clear();
		}

		return result;
	}

	Map<String, Set<Integer>> positMap = new HashMap<String, Set<Integer>>();

	private void dfs(String root, String end, int deep, LinkedList<String> path) {
		if (root.equals(end)) {
			result.add(new ArrayList<String>(path));
			return;
		}

		if (deep <= 0) {
			// System.out.println(Arrays.toString(path.toArray()));
			return;
		}

		int n = result2.size() - deep - 1;
		if (!result2.get(n).contains(root)) {
			return;
		}

		Set<String> patterns = wordToPat.get(root);
		for (String patt : patterns) {
			Set<String> wds = patToWordMap.get(patt);

			for (String wd : wds) {
				if (!visited.contains(wd)) {
					visited.add(wd);
					path.add(wd);
					dfs(wd, end, deep - 1, path);
					path.removeLast();
					visited.remove(wd);
				}
			}
		}

	}

}
