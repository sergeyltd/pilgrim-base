package org.pilgrim.base.strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {

    class Solution {

        public int numUniqueEmails(String[] emails) {
            Set<String> seen = new HashSet();

            for (String email : emails) {
                email = getUniqueEmail(email);
                seen.add(email);
            }

            return seen.size();
        }

        public String getUniqueEmail(String email) {
            StringBuilder stringBuilder = new StringBuilder();
            boolean atFound = false;
            boolean plusFound = false;
            for (char character : email.toCharArray()) {
                if (atFound) {
                    stringBuilder.append(character);
                } else if (character == '@') {
                    atFound = true;
                    plusFound = false;
                    stringBuilder.append(character);
                } else if (character == '.' || (plusFound && !atFound)) {
                    continue;
                } else if (character == '+') {
                    plusFound = true;
                    continue;
                } else {
                    stringBuilder.append(character);
                }
            }
            return stringBuilder.toString();
        }

        public int numUniqueEmails_leetcode(String[] emails) {
            Set<String> seen = new HashSet();
            for (String email : emails) {
                email = email.toLowerCase();
                int i = email.indexOf('@');
                String local = email.substring(0, i);
                String rest = email.substring(i);
                if (local.contains("+")) {
                    local = local.substring(0, local.indexOf('+'));
                }
                local = local.replaceAll("\\.", "");
                seen.add(local + rest);
            }

            return seen.size();
        }

        public int numUniqueEmails_my(String[] emails) {
            if (null == emails || emails.length <= 0) {
                return 0;
            }

            Set<String> uniqueEmails = new HashSet<>();
            for (String email : emails) {
                StringBuilder sb = new StringBuilder();
                boolean skipTillAt = false;
                for (int i = 0; i < email.length(); i++) {
                    char ch = email.charAt(i);
                    if (skipTillAt && ch != '@') {
                        continue;
                    } else if (ch == '@') {
                        skipTillAt = false;
                        sb.append(email.substring(i));
                        break;
                    } else if (ch == '+') {
                        skipTillAt = true;
                    } else if (ch == '.') {
                        continue;
                    } else {
                        sb.append(ch);
                    }
                }
                uniqueEmails.add(sb.toString().toLowerCase());
            }

            return uniqueEmails.size();
        }
    }

    public static void main(String[] args) {

    }
}
