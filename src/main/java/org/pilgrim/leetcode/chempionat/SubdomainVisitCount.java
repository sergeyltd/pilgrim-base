package org.pilgrim.leetcode.chempionat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 811. Subdomain Visit Count User Accepted: 0 User Tried: 0 Total Accepted: 0
 * Total Submissions: 0 Difficulty: Easy A website domain like
 * "discuss.leetcode.com" consists of various subdomains. At the top level, we
 * have "com", at the next level, we have "leetcode.com", and at the lowest
 * level, "discuss.leetcode.com". When we visit a domain like
 * "discuss.leetcode.com", we will also visit the parent domains "leetcode.com"
 * and "com" implicitly.
 * 
 * Now, call a "count-paired domain" to be a count (representing the number of
 * visits this domain received), followed by a space, followed by the address.
 * An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * 
 * We are given a list cpdomains of count-paired domains. We would like a list
 * of count-paired domains, (in the same format as the input, and in any order),
 * that explicitly counts the number of visits to each subdomain.
 * 
 * Example 1: Input: ["9001 discuss.leetcode.com"] Output: ["9001
 * discuss.leetcode.com", "9001 leetcode.com", "9001 com"] Explanation: We only
 * have one website domain: "discuss.leetcode.com". As discussed above, the
 * subdomain "leetcode.com" and "com" will also be visited. So they will all be
 * visited 9001 times.
 * 
 * Example 2: Input: ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com",
 * "5 wiki.org"] Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5
 * wiki.org","5 org","1 intel.mail.com","951 com"] Explanation: We will visit
 * "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and
 * "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 =
 * 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * 
 * Notes:
 * 
 * The length of cpdomains will not exceed 100. The length of each domain name
 * will not exceed 100. Each address will have either 1 or 2 "." characters. The
 * input count in any count-paired domain will not exceed 10000.
 * 
 * @author segoncha
 *
 */

public class SubdomainVisitCount {

	public List<String> subdomainVisits(String[] cpdomains) {
		List<String> res = new ArrayList<>();
		
		Map<String, Long> map = new HashMap<>();
		
		for (String item : cpdomains) {
			String[] splits = item.split(" ");
			long count = Long.valueOf(splits[0]);
			List<String> domains = parseDomain(splits[1]);
			
			for (String domain : domains) {
				Long storedCount = map.get(domain);
				if(null == storedCount){
					storedCount = count;
				}
				else{
					storedCount += count;
				}
				
				map.put(domain, storedCount);
			}
		}
		
		Set<Entry<String, Long>> entrySet = map.entrySet();
		for (Entry<String, Long> entry : entrySet) {
			res.add(entry.getValue() + " " + entry.getKey());
		}
		
		return res;
	}

	private List<String> parseDomain(String string) {
		List<String> list =  new ArrayList<>();
		list.add(string);
		
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (ch == '.'){
				list.add(string.substring(i+1));
			}
		}
		return list;
	}

	public static void main(String[] args) {
		SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();
		System.out.println(subdomainVisitCount.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
	}
}
