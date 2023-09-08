public class CaesarCipher {
    public static void main(String[] args) {
        // if there are incorrect numbers of command-line arguments
        if (args.length != 2) {
            // state that the input was invalid
            System.err.println("Incorrect number of parameters. Please only enter two, separated by white space.");
            // exit with a code of 2
            System.exit(2);
        }

        // turn the string into a char array
        char[] charArr = args[1].toCharArray();

        // encode the string
        if (args[0].equals("encode")) {
            for (int m = 0; m < 26; m++) {
                encode(charArr, m);
            }
            // decode the string
        } else if (args[0].equals("decode")) {
            for (int m = 0; m < 26; m++) {
                decode(charArr, m);
            }
            // if the input was neither 'encode' nor 'decode'
        } else {
            // state that the input was invalid
            System.err.println("The input was invalid. Valid options are 'encode' or 'decode'");
            // exit with a code of 1
            System.exit(1);
        }
    } // main function

    /*
     * pre-condition: str is a string, n is an integer
     * post-condition: encode the str by adding n to each character in str
     */
    public static void encode(char[] str, int n) {
        // make a new char array with the same size as str
        char[] encodeCh = new char[str.length];
        for (int i = 0; i < encodeCh.length; i++) {
            // add n to each character in str
            encodeCh[i] = (char) modulo((int) str[i] + n);
        }
        // make a string from the char array
        String encodeStr = new String(encodeCh);
        // print the encoded string
        System.out.println("n = " + n + ": " + encodeStr);
    }

    /*
     * pre-condition: str is a string, n is an integer
     * post-condition: decode the str by subtracting n to each character in str
     */
    public static void decode(char[] str, int n) {
        // make a new char array with the same size as str
        char[] decodeCh = new char[str.length];
        for (int i = 0; i < decodeCh.length; i++) {
            // subtract n from each character in str
            decodeCh[i] = (char) modulo((int) str[i] - n);
        }
        // make a string from the char array
        String decodeStr = new String(decodeCh);
        // print the decoded string
        System.out.println("n = " + n + ": " + decodeStr);
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