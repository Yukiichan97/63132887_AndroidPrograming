import java.util.HashMap;

public class Morse {
    private static final HashMap<Character, String> morseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('.', ".-.-.-");
        morseCodeMap.put(',', "--..--");
        morseCodeMap.put('?', "..--..");
        morseCodeMap.put('\'', ".----.");
        morseCodeMap.put('!', "-.-.--");
        morseCodeMap.put('/', "-..-.");
        morseCodeMap.put('(', "-.--.");
        morseCodeMap.put(')', "-.--.-");
        morseCodeMap.put('&', ".-...");
        morseCodeMap.put(':', "---...");
        morseCodeMap.put(';', "-.-.-.");
        morseCodeMap.put('=', "-...-");
        morseCodeMap.put('+', ".-.-.");
        morseCodeMap.put('-', "-....-");
        morseCodeMap.put('_', "..--.-");
        morseCodeMap.put('\"', ".-..-.");
        morseCodeMap.put('$', "...-..-");
        morseCodeMap.put('@', ".--.-.");
    }

    public static String stringToMorseCode(String input) {
        StringBuilder morseCode = new StringBuilder();

        for (char character : input.toUpperCase().toCharArray()) {
            if (morseCodeMap.containsKey(character)) {
                morseCode.append(morseCodeMap.get(character)).append(" ");
            } else {
                morseCode.append(" ");
            }
        }
        return morseCode.toString().trim();
    }
    public static String morseCodeToString(String morseCode) {
        StringBuilder result = new StringBuilder();
        String[] words = morseCode.split("\\s+");
        for (String word : words) {
            String[] letters = word.split("\\s+");
            for (String letter : letters) {
                for (Character key : morseCodeMap.keySet()) {
                    if (morseCodeMap.get(key).equals(letter)) {
                        result.append(key);
                        break;
                    }
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
