package com.abanoub.CharReplacer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[][] replacementArray;
    static Gooey frame = new Gooey();

    public static void main(String[] args) {
        frame.run();
    }
    static void setReplacementArray() {
        int ii = 0;
        replacementArray = new char[frame.lib.getLineCount()][2];
        Scanner scan = new Scanner(frame.getLib());
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(str);
            String[] splitString = str.split("", 2);
            System.out.println(Arrays.toString(splitString));
            char[] chars = {splitString[0].charAt(0), splitString[1].charAt(0)};
            System.out.println(chars);
            replacementArray[ii] = chars;
            ii++;
        }
        System.out.println(Arrays.deepToString(replacementArray));
    }

    public static String replace(String input, String shift) {
        char[] chars = input.toCharArray();
        char[] shifts = shift.toCharArray();

        for (int jj = 1; jj < chars.length; jj++) {
            for (int kk = 0; kk < shifts.length; kk++) {
                if (chars[jj - 1] == shifts[kk]) {
                    char temp = chars[jj];
                    chars[jj] = chars[jj - 1];
                    chars[jj - 1] = temp;
                    jj++;
                }
            }
        }


        for (int ii = 0; ii < chars.length; ii++) {
            for (int jj = 0; jj < replacementArray.length; jj++) {
                if (chars[ii] == replacementArray[jj][0]) {
                    chars[ii] = replacementArray[jj][1];
                }
            }
            if ((input.charAt(ii) != ' ') && (input.charAt(ii) != '\n')) {
                if (input.charAt(ii) == chars[ii]) {
                    chars[ii] = '?';
                }
            }
        }
        String strOut = String.valueOf(chars);

        System.out.println(strOut);
        return strOut;
    }


}
