package com.pigcanfly.leetcoding.s953;

/**
 * @author Tobby Quinn
 * @date 2019/08/22
 */
public class VerifyinganAlienDictionary {

    public static  boolean isAlienSorted(String[] words, String order) {
        int[] dicts = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dicts[order.charAt(i)-'a']=i;
        }
        for (int i = 0; i < words.length-1; i++) {
            String firstWord=words[i];
            String secondWord=words[i+1];
            String shortest;
            if(firstWord.length()>secondWord.length()){
                shortest=secondWord;
            }else{
                shortest=firstWord;
            }
            for (int j = 0; j < shortest.length(); j++) {
                char fChar = firstWord.charAt(j);
                char sChar = secondWord.charAt(j);
                if(dicts[fChar-'a']<dicts[sChar-'a']){
                    break;
                }
                if(dicts[fChar-'a']>dicts[sChar-'a']){
                    return false;
                }
                if(j==shortest.length()-1 && firstWord.length()>secondWord.length()){
                    return false;
                }
            }

        }
        return true;

    }
    public boolean isAlienSorted1(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = isAlienSorted(new String[]{"kuvp","q"},
                "ngxlkthsjuoqcpavbfdermiywz");
        System.out.println(res);
    }
}
