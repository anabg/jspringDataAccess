package main.java;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {



    private static final Pattern CONTENT_PATTERN = Pattern.compile("\\:");

    private String replaceScripts(final String jsonString) throws IOException {
        Matcher contentMatcher = CONTENT_PATTERN.matcher(jsonString);
        String result = jsonString;
        while(contentMatcher.find()) {
            System.out.print("Start index: " + contentMatcher.start());
            System.out.print(" End index: " + contentMatcher.end() + " ");

    }
    return "";
    }


    public static void main (String [] ){

        Test t = new Test();

        t.replaceScripts("{ projections.collector.$id : '56969a35e4b02c7944a06e45'}");

    }
}


