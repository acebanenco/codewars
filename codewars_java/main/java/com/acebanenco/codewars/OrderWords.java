package com.acebanenco.codewars;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OrderWords {

    public static String orderWords(String words) {
        TreeMap<BigInteger, String> orderedMap = Arrays.stream(words.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toMap(
                        OrderWords::getDigits,
                        Function.identity(),
                        (lastWord, newWord) -> newWord,
                        TreeMap::new
                ));
        return String.join(" ", orderedMap.values());
    }

    private static BigInteger getDigits(String word) {
        Pattern digitsPattern = Pattern.compile("\\d+");
        Matcher matcher = digitsPattern.matcher(word);
        if (matcher.find()) {
            return new BigInteger(matcher.group());
        }
        return null;
    }

}
