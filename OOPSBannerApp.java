
public class OOPSBannerApp {

    /**
     * Inner static class to store character and its ASCII pattern
     */
    static class CharacterPatternMap {

        private char character;
        private String[] pattern;

        /**
         * Constructor
         * @param character the character to map
         * @param pattern ASCII art pattern
         */
        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        /**
         * @return mapped character
         */
        public char getCharacter() {
            return character;
        }

        /**
         * @return ASCII pattern
         */
        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Create and initialize pattern mappings
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        return new CharacterPatternMap[] {

            new CharacterPatternMap('O', new String[] {
                    "  *****  ",
                    " **   ** ",
                    " **   ** ",
                    " **   ** ",
                    " **   ** ",
                    " **   ** ",
                    "  *****  "
            }),

            new CharacterPatternMap('P', new String[] {
                    " ******  ",
                    " **   ** ",
                    " **   ** ",
                    " ******  ",
                    " **      ",
                    " **      ",
                    " **      "
            }),

            new CharacterPatternMap('S', new String[] {
                    "  ****** ",
                    " **      ",
                    " **      ",
                    "  *****  ",
                    "       **",
                    " **    **",
                    "  ****** "
            }),

            new CharacterPatternMap(' ', new String[] {
                    "          ",
                    "          ",
                    "          ",
                    "          ",
                    "          ",
                    "          ",
                    "          "
            })
        };
    }

    /**
     * Retrieve pattern for a given character
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {

        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }

        // fallback to space if not found
        return getCharacterPattern(' ', charMaps);
    }

    /**
     * Print message as banner
     */
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {

        for (int line = 0; line < 7; line++) {

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {

                String[] pattern = getCharacterPattern(message.charAt(i), charMaps);
                builder.append(pattern[line]).append(" ");
            }

            System.out.println(builder.toString());
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        CharacterPatternMap[] charMaps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, charMaps);
    }
}