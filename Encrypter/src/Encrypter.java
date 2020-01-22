public class Encrypter {

    public static final int KEY = 5;

    public Encrypter() {

    }

    public String encrypt (String input) {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            char c = current;

            if(((int) current >= (int) 'a' && (int) current <= (int)'z') || ((int) current >= (int)'A' && (int) current <= (int)'Z')) {
                c = (char) ((int) current + KEY);
                if(c > 'Z') {
                    if(c > 'z' && (current >= 'a' && current <= 'z')) {
                        int difference = c - 'z';
                        c = (char) ((int) 'a' + difference - 1);
                    } else if(current >= 'A' && current <= 'Z') {
                        int difference = c - 'Z';
                        c = (char) ((int) 'A' + difference - 1);
                    }
                }
            }
            output += c;
        }

        return output;
    }

    public String decrypt(String input) {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            char c = current;

            if(((int) current >= (int) 'a' && (int) current <= (int)'z') || ((int) current >= (int)'A' && (int) current <= (int)'Z')) {
                c = (char) ((int) current - KEY);
                if(c < 'a') {
                    if(c < 'a' && (current >= 'a' && current <= 'z')) {
                        int difference = 'a'- c;
                        c = (char) ((int) 'z' - difference + 1);
                    } else if(c < 'A' && (current >= 'A' && current <= 'Z')) {
                        int difference = 'A' - c;
                        c = (char) ((int) 'Z' - difference + 1);
                    }
                }
            }
            output += c;
        }
        return output;
    }
}
