package com.examples.java.java12;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormattingDemo {
    public static void main(String[] args) {
        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println(likesShort.format(3500.97)); // 3.5K

        likesShort.setMaximumFractionDigits(3);
        System.out.println(likesShort.format(3500.97)); //3.501K
    }
}
