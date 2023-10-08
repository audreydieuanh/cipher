/* Change for first redo
1. Change variable names:
   1.1 m -> key
   1.2 charArr -> message (main method)
   1.3 str -> message (encodeOrdecode method)

2. Change method implementation:
Since encode and decode is mostly similar. 
The only difference is to add/subtract, I group it into 1 method to remove repeated code.
 */


/**
 * This class encodes and decodes string using a number
 * 
 * @author Audrey Trinh
 */

public class CaesarCipher {
  public static void main(String[] args) {
      // if there are incorrect numbers of command-line arguments
      if (args.length != 2) {
          // state that the input was invalid
          System.err.println("Incorrect number of parameters. Please only enter two, separated by white space.");
          // exit with a code of 2
          System.exit(2);
      }

      if (!args[0].equals("encode") && !args[0].equals("decode")) {
        // state that the input was invalid
        System.err.println("The input was invalid. Valid options are 'encode' or 'decode'");
        // exit with a code of 1
        System.exit(1);
      }

      // turn the string into a char array
      char[] message = args[1].toCharArray();

      // change for redo 1, change variable name
      for (int key = 0; key < 26; key++) {
        encodeOrdecode(args[0], message, key);
      }

  } // main function

  /*
   * pre-condition: str is a string, n is an integer
   * post-condition: encode/decode he str by adding/subtracting n to each character in str
   */

   // change for redo 1, make 2 methods encode and decode into 1 method to remove repeated code
  public static void encodeOrdecode(String request, char[] message, int key) {
    char[] result = new char[message.length];
    for (int i = 0; i < result.length; i++) {
      if (request.equals("encode")) {
        result[i] = (char) modulo((int) message[i] + key);
      } else {
        result[i] = (char) modulo((int) message[i] - key);
      }
    }

    String resultStr = new String(result);
    System.out.println("n = " + key + ": " + resultStr);
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