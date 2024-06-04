public class Main {
    public static void main(String[] args) {

    }
    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            else if (str.charAt(i) == ')') count--;
        }
        return (count == 0);     //each '(' should have a pairing ')', thus the final count = 0
    }

    // 2. reverseInteger
    public static String reverseInteger(int digits){
        String str = String.valueOf(digits);    //turning num into string
        String out = "";

        //starting from last digit and adding it to the final output
        for (int i = str.length()-1; i > -1; i--) out += str.charAt(i);

        return out;
    }

    // 3. encryptThis
    public static String encryptThis(String str){
        str += " ";
        String str2 = " " + str + " ";
        String out = "";
        int y = 0;

        for (int i = 1; i < str2.length()-2; i++) {
            if (str2.charAt(i - 1) == ' ') out += (int) str2.charAt(i);   //first char converting to int
            else if (str2.charAt(i - 2) == ' ') {           //second char
                y = i;
                for (int j = i; j < str2.length(); j++) {
                    if (str2.charAt(j) == ' ') {    //until the end of the word
                        out += str2.charAt(j-1);      //will get the last letter of that word
                        break;
                    }
                }
            }
            else if (str2.charAt(i + 1) == ' ') {             //last char
                out += str2.charAt(y);      //gets the noted second letter from the previous else-if
            }
            else out += str2.charAt(i);
        }

        return out;
    }


    // 4. decipherThis
    public static String decipherThis(String str) {
        String str2 = " " + str + " ";
        String out = "";
        int y = 0;
        int count = 0;

        for (int i = 1; i < str2.length()-1; i++) {
            if (str2.charAt(i-1) == ' ') {        // first char
                for (int j = i; j < str2.length(); j++) {
                    boolean ascii = Character.isDigit(str2.charAt(j));   // if char is a number
                    if (!ascii) {
                        out += (char) Integer.parseInt(str2.substring(i, j));    // convert int to char
                        break;
                    }
                    count++;   //num of ascii digits
                }
                i += count;
            }
            if (str2.charAt(i-count-1) == ' ') {
                y = i;
                for (int k = i; k < str2.length(); k++) {
                    if (str2.charAt(k+1) == ' ') {   // original second char
                        out += str2.charAt(k);
                        break;
                    }
                }
                count = 0;
            }
            else if (str2.charAt(i+1) == ' ') {             // last char
                out += str2.charAt(y);      // adds original last char which is at y
            }
            else out += str2.charAt(i);
        }
        return out;
    }
}