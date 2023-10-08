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
 * This class encodes and decodes string using a keyword
 * 
 * @author Audrey Trinh
 */

public class VigenereCipher {
  public static void main(String[] args) {
      // if there are incorrect numbers of command-line arguments
      if (args.length != 3) {
          // state that the input was invalid
          System.err.println("Incorrect number of parameters. Please only enter 3, separated by white space.");
          // exit with a code of 2
          System.exit(2);
      }

      if (!args[0].equals("encode") && !args[0].equals("decode")) {
        // state that the input was invalid
        System.err.println("The input was invalid. Valid options are 'encode' or 'decode'");
        // exit with a code of 1
        System.exit(1);
      }

      // if keyword is an empty string
      if (args[2].equals("")) {
              // print the original string
              System.out.println(args[1]);
              return;
          }
      // turn the string into a char array
      char[] message = args[1].toCharArray();

      // turn the keyword into a char array
      char[] keyWord = args[2].toCharArray();

      char[] keyRepl = new char[message.length];
      // replicate the keyword so that it has the same size as the string
      for (int i = 0; i < keyRepl.length; i++) {
          keyRepl[i] = keyWord[i % keyWord.length];
      }

      encodeOrDecode(args[0], message, keyRepl);
  }

  /*
   * pre-condition: str and keyRepl are strings with same size, n is an integer
   * post-condition: encode/decode the str by adding/subtracting each character in keyRepl to
   * each character in str
   */

   // change for redo 1, make 2 methods encode and decode into 1 method to remove repeated code
  public static void encodeOrDecode(String request, char[] message, char[] keyRepl) {
    // make a new char array with the same size as str
    char[] result = new char[message.length];
    for (int i = 0; i < result.length; i++) {
      if (request.equals("encode")) {
        // add each character in keyEepl to each character in str
        result[i] = (char) modulo((int) message[i] + (int) keyRepl[i] - 'a');
      } else {
        result[i] = (char) modulo((int) message[i] - (int) keyRepl[i] + 'a');
      }
    }
    // make a string from the char array
    String resultStr = new String(result);
    // print the encoded string
    System.out.println(resultStr);
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
