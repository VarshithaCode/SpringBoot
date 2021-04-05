package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text    =
                "cmnsrv-1a|ass-fass/rs/fass|PONG|3.4.1" +
                        "cmnsrv-1a|ass-fass/rs/fass|PONG|3.4.1" +
                        "cmnsrv-1a|axxx-vvv/rs/fass|PONG|3.4.1";

        String regex = ".*ass-fass.*";

        String fact1= "xxxxx";
        String fact2 = "fact"+1;

        System.out.println(fact2.toString());

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.results());
        while(matcher.find()) {
            System.out.println(matcher.group());


        }
    }
}
