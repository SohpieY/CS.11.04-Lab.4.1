public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char checkCurrent = str.charAt(i);
            if(checkCurrent == '('){
                count++;
            } else if(checkCurrent == ')'){
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;

    }

    // 2. reverseInteger
    public static String reverseInteger(int num){
        String numString = Integer.toString(num);
        String result = "";
        for(int i = numString.length()- 1; i >= 0; i--){
            result += numString.charAt(i);
        }
        return result;
    }

    // 3. encryptThis
    public class MessageEncryptor {
        public static String encryptMessage(String message) {
            StringBuilder encryptedMessage = new StringBuilder();
            StringBuilder word = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);

                if (c == ' ') {
                    String encryptedWord = encryptWord(word.toString());
                    encryptedMessage.append(encryptedWord).append(' ');

                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }


            if (!word.isEmpty()) {
                String encryptedWord = encryptWord(word.toString());
                encryptedMessage.append(encryptedWord);
            }

            return encryptedMessage.toString();
        }

        private static String encryptWord(String word) {
            int firstLetterCode = (int) word.charAt(0);
            String switchedLetters = word.charAt(word.length() - 1) + word.substring(1, word.length() - 1) + word.charAt(0);
            return firstLetterCode + switchedLetters;
        }

        public static void main(String[] args) {
            String message = "Hello world";
            String encryptedMessage = encryptMessage(message);
            System.out.println(encryptedMessage);
        }
    }

    // 4. decipherThis
    // got some help
    public class MessageDecipher {
        public static String decipherMessage(String message) {
            String[] words = message.split(" ");
            StringBuilder decipheredMessage = new StringBuilder();

            for (String word : words) {
                StringBuilder decipheredWord = new StringBuilder();

                if (word.length() > 0) {
                    int firstLetterCode = 0;

                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);

                        if (Character.isDigit(c)) {
                            firstLetterCode = firstLetterCode * 10 + Character.getNumericValue(c);
                        } else if (i == 0) {
                            decipheredWord.append((char) firstLetterCode);
                        } else if (i == 1) {
                            decipheredWord.append(word.charAt(word.length() - 1));
                        } else if (i == word.length() - 1) {
                            decipheredWord.append(word.charAt(1));
                        } else {
                            decipheredWord.append(c);
                        }
                    }
                }

                decipheredMessage.append(decipheredWord).append(" ");
            }

            return decipheredMessage.toString().trim();
        }

        public static void main(String[] args) {
            String message1 = "72olle 103doo 100ya";
            String decipheredMessage1 = decipherMessage(message1);
            System.out.println(decipheredMessage1);

            String message2 = "82yade 115te 103o";
            String decipheredMessage2 = decipherMessage(message2);
            System.out.println(decipheredMessage2);
        }
    }
}