public class VigenereCipher {
    public static void main(String[] args) {
        // if there are incorrect numbers of command-line arguments
        if (args.length != 3) {
            // state that the input was invalid
            System.err.println("Incorrect number of parameters. Please only enter 3, separated by white space.");
            // exit with a code of 2
            System.exit(2);
        }

        // if keyword is an empty string
        if (args[2].equals("")) {
                // print the original string
                System.out.println(args[1]);
                return;
            }
        // turn the string into a char array
        char[] charArr = args[1].toCharArray();

        // turn the keyword into a char array
        char[] keyWord = args[2].toCharArray();

        char[] keyRepl = new char[charArr.length];
        // replicate the keyword so that it has the same size as the string
        for (int i = 0; i < charArr.length; i++) {
            keyRepl[i] = keyWord[i % keyWord.length];
        }

        // encode the string
        if (args[0].equals("encode")) {
            encode(charArr, keyRepl);
            // decode the string
        } else if (args[0].equals("decode")) {
            decode(charArr, keyRepl);
            // if the input was neither 'encode' nor 'decode'
        } else {
            // state that the input was invalid
            System.err.println("The input was invalid. Valid options are 'encode' or 'decode'");
            // exit with a code of 1
            System.exit(1);
        }
    }

    /*
     * pre-condition: str and keyRepl are strings with same size, n is an integer
     * post-condition: encode the str by adding each character in keyRepl to
     * each character in str
     */
    public static void encode(char[] str, char[] keyRepl) {
        // make a new char array with the same size as str
        char[] encodeCh = new char[str.length];
        for (int i = 0; i < encodeCh.length; i++) {
            // add each character in keyEepl to each character in str
            encodeCh[i] = (char) modulo((int) str[i] + (int) keyRepl[i] - 'a');
        }
        // make a string from the char array
        String encodeStr = new String(encodeCh);
        // print the encoded string
        System.out.println(encodeStr);
    }

    /*
     * pre-condition: str and keyRepl are strings with same size, n is an integer
     * post-condition: decode the str by subtracting each character in keyRepl from
     * each character in str
     */
    public static void decode(char[] str, char[] keyRepl) {
        // make a new char array with the same size as str
        char[] decodeCh = new char[str.length];
        for (int i = 0; i < decodeCh.length; i++) {
            // subtract each character in keyEepl from each character in str
            decodeCh[i] = (char) modulo((int) str[i] - (int) keyRepl[i] + 'a');
        }
        // make a string from the char array
        String decodeStr = new String(decodeCh);
        // print the decoded string
        System.out.println(decodeStr);
    }

    /*
     * pre-condition: ch is a lowercase character
     * post-condition: return the ch if it does not exceed the range of
     * 26 characters and wrap around if not
     */
    public static int modulo(int ch) {
        ch -= 'a';
        // if ch is in the range
        if (ch >= 0) {
            // return the original ch
            return ch % 26 + 'a';
            // if not
        } else {
            // wrap around the lowercase alphabet
            return ch % 26 + 26 + 'a';
        }
    }
}
