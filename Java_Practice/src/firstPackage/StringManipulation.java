import java.util.HashMap;

public class StringManipulation {
    public static void main(String[] args) {
        String str = "Rohit Shukla";
        printReverseOfString(str);
        System.out.println("  ");
        printReverseSentence(str);
        System.out.println("  ");
        countOfCharacters(str);
    }

    private static void printReverseOfString(String str){
        for(int i = str.length()-1; i>=0; i--)
        {
            System.out.print(str.charAt(i));
        }

    }

    private static void printReverseSentence(String str)
    {
        String [] strSplit = str.split("\\s");

        for(int i=strSplit.length-1; i>=0; i--)
        {
            System.out.print(strSplit[i]+" ");
        }
    }

    private static void countOfCharacters(String str) {
        HashMap<Character, Integer> charCountmap = new HashMap<>();
        for(int i =0; i<str.length();i++){
            char ch = str.charAt(i);
            if(charCountmap.containsKey(ch)){
               int count = charCountmap.get(ch);
               charCountmap.put(ch, count + 1);
            }
            else {
                charCountmap.put(ch, 1);
            }
        }

        for (char ch : charCountmap.keySet()){
            System.out.println(ch + ":" + charCountmap.get(ch));
        }

    }
}
