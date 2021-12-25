public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {


        return lengthOfString(name) && spaceOfString(name);
    }

    private boolean lengthOfString(String initialString) {
        return initialString.length() >= 3 && initialString.length() <= 19;
    }

    private boolean spaceOfString(String initialString) {
        if (numberOfSubstrings(initialString) == 1) {
            return !initialString.startsWith(" ") && !initialString.endsWith(" ");
        }

        return false;
    }

    private int numberOfSubstrings(String initialString) {
        int i = initialString.indexOf(" ");
        int count = 0;
        while (i != -1) {
            i = initialString.indexOf(" ", i + 1);
            count += 1;
        }
        return count;
    }
}