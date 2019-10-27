import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String words = "abcde";
        ans = permute(words);

        System.out.println("Done");
    }

    public static List<String> permute(String words) {
        List<String> ans = new ArrayList<>();
        List<Character> set = new ArrayList<>();
        doPermute(ans, set, words, 0, words.length());
        return ans;
    }

    public static void doPermute(List<String> ans, List<Character> set, String words, int index, int length) {
       if(set.size() == length) {
           String setString = getStringRepresentation(set);
           if(ans.contains(setString) == false) {
               ans.add(setString);
           }
           return;
       }

       char[] wordArr = words.toCharArray();


       for(int i=0; i<words.length(); i++) {
           List<Character> newSet = new ArrayList<>(set);

           newSet.add(wordArr[i]);
           // convert words
           String newWords = words.substring(0, i) + words.substring(i+1);
           doPermute(ans, newSet, newWords, index+1, length);
       }
    }

    public static String getStringRepresentation(List<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}

