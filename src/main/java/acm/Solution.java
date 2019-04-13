package acm;

import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, String> capMap = new HashMap<>();
        Map<String, String> vowMap = new HashMap<>();
        String[] ans = new String[queries.length];

        for (String word : wordlist) {
            set.add(word);

            String lowerCase = word.toLowerCase();
            capMap.putIfAbsent(lowerCase, word);

            String vowelWord = devowel(lowerCase);
            vowMap.putIfAbsent(vowelWord, word);
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (set.contains(query))
                ans[i] = query;
            else {
                String lowerCase = query.toLowerCase();
                if (capMap.containsKey(lowerCase))
                    ans[i] = capMap.get(lowerCase);
                else {
                    String vowelWord = devowel(lowerCase);
                    if (vowMap.containsKey(vowelWord))
                        ans[i] = vowMap.get(vowelWord);
                    else
                        ans[i] = "";
                }
            }
        }
        return ans;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                sb.append('*');
            else
                sb.append(c);
        }
        return sb.toString();
    }
}