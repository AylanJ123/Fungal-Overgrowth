package com.aylanj123.fungalovergrowth.helper;

public class ColorHelper {

    /**
     * Minecraft reads colors according to the bits, red takes the first 8,
     * green takes from 9th to 16th and blue takes from 17th to 24th.
     * The operator << displaces the bits the correct amount of spaces,
     * making a list of bits that looks like this [rrrrrrrrggggggggbbbbbbbb]
     * each letter representing the bits it consumes according to the value.
     * @return the displaced 8 bits combined, making a 24 bits integer
     */
    public static int colorFromRGB(int r, int g, int b) {
        return  (r << 16) | (g << 8) | b;
    }

}
