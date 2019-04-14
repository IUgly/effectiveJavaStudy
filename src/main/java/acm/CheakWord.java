package acm;

import java.util.*;

/**
 * @author kuangjunlin
 * 方法：哈希映射 HashMap
 * 思路与算法
 *
 * 我们分析了算法需要考虑的3种情况: 当查询完全匹配时，当查询存在大小写不同的单词匹配时，当查询与出现元音错误的单词匹配时。
 *
 * 在所有 3 种情况下，我们都可以使用哈希表来查询答案。
 *
 * 对于第一种情况（完全匹配），我们使用集合存放单词以有效地测试查询单词是否在该组中。
 * 对于第二种情况（大小写不同），我们使用一个哈希表，该哈希表将单词从其小写形式转换为原始单词（大小写正确的形式）。
 * 对于第三种情况（元音错误），我们使用一个哈希表，将单词从其小写形式（忽略元音的情况下）转换为原始单词。
 */
public class CheakWord {
    private Set<String> perfectWord = new HashSet<>();
    private Map<String, String> capWord = new HashMap<>();
    private Map<String, String> vowelWord = new HashMap<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {

        for (String word: wordlist
             ) {
            perfectWord.add(word);

            String lowWord = word.toLowerCase();
            capWord.putIfAbsent(lowWord, word);

            String lowVowel = deVowel(lowWord);
            vowelWord.putIfAbsent(lowVowel, word);
        }

        String[] result = new String[queries.length];
        int i = 0;
        for (String query : queries
             ) {
            result[i++] = solve(query);
        }

        return result;
    }

    public String solve(String query){
        if (perfectWord.contains(query)){
            return query;
        }
        String lowWord = query.toLowerCase();
        if (capWord.containsKey(lowWord)){
            return capWord.get(lowWord);
        }
        String voWord = deVowel(lowWord);
        if (vowelWord.containsKey(voWord)){
            return vowelWord.get(voWord);
        }

        return "";
    }

    public String deVowel(String word){
        StringBuilder vowel = new StringBuilder();
        for (char c:word.toCharArray()
             ) {
            vowel.append(isVowel(c) ? '*' : c);
        }
        return vowel.toString();
    }

    public boolean isVowel(char c){
        return (c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u');
    }

    public static void main(String[] args) {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        CheakWord cheakWord = new CheakWord();
        System.out.println(Arrays.toString(cheakWord.spellchecker(wordlist, queries)));
    }
}
