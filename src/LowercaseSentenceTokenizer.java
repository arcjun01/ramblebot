import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A tokenizer that converts text input to lowercase and splits it 
 * into a list of tokens, where each token is either a word or a period.
 */
public class LowercaseSentenceTokenizer implements Tokenizer {
  /**
   * Tokenizes the text from the given Scanner. The method should 
   * convert the text to lowercase and split it into words and periods.
   * Words are separated by spaces, and periods are treated as separate tokens.
   * 
   * For example:
   * If the input text is: "Hello world. This is an example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "an", "example", "."]
   * 
   * Notice that the text is converted to lowercase, and each period is treated as a separate token.
   * 
   * However, a period should only be considered a separate token if it occurs at the end
   * of a word. For example:
   * 
   * If the input text is: "Hello world. This is Dr.Smith's example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "dr.smith's", "example", "."]
   * 
   * The internal period in Dr.Smith's is not treated as its own token because it does not occur at the end of the word.
   * 
   * @param scanner the Scanner to read the input text from
   * @return a list of tokens, where each token is a word or a period
   */
  public List<String> tokenize(Scanner scanner) {
    
    // TODO: Implement this function to convert the scanner's input to a list of words and periods

    // THIS IS FOR WAVE 1 AND WAVE!

    // ArrayList stores the token
    List<String> tokens = new ArrayList<>();

    // The loop will continuously reads the token in the Scanner along with hasNext() to check if there's more to read
    while (scanner.hasNext()) {
      // tokens.add(scanner.next().toLowerCase()); <- used in Wave 1
      // Reads the input and converts it to lowercase
      String token = scanner.next().toLowerCase();

      // This condition checks if token is not empty AND checks if there's a period at the end
      // Resourse for using charAt() and substring():
      // https://www.geeksforgeeks.org/java-string-charat-method-example/
      if (token.length() > 0 && token.charAt(token.length() - 1) == '.') {

        // To create a new String that will have the original token
        // The add method separates the punctuations from words
        String periodNotFound = token.substring(0, token.length() - 1);
        tokens.add(periodNotFound);
        tokens.add(".");
      }
      // if token does not end with period and adds to the 'tokens' list
      else {
        tokens.add(token);
      }
    }
    // Returns all the words and periods
    return tokens;
  }

}

