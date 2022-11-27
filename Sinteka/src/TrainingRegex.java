import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainingRegex {
    public static void main(String[] args) {
        System.out.println(wheresWally("It's Wally's."));
    }

    public static int wheresWally(String str) {
        Pattern pattern = Pattern.compile("(^|\\s)(?<ans>Wally)(\\W|$)");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
//            return matcher.regionEnd();
            String s = matcher.group("ans");
            return matcher.start(s);
        } else     return -1;
    }
}
