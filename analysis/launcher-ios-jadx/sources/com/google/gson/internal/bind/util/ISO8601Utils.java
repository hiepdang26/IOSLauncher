package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:23:0x0065, B:25:0x0075, B:26:0x0077, B:28:0x0083, B:29:0x0086, B:31:0x008c, B:35:0x0096, B:40:0x00a6, B:42:0x00ae, B:54:0x00e5, B:56:0x00eb, B:58:0x00f1, B:84:0x0182, B:64:0x0102, B:65:0x0118, B:66:0x0119, B:70:0x0129, B:72:0x0136, B:75:0x013f, B:77:0x0151, B:80:0x0160, B:81:0x017d, B:83:0x0180, B:69:0x0125, B:86:0x01b4, B:87:0x01bb, B:47:0x00c8, B:48:0x00cb), top: B:98:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b4 A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:23:0x0065, B:25:0x0075, B:26:0x0077, B:28:0x0083, B:29:0x0086, B:31:0x008c, B:35:0x0096, B:40:0x00a6, B:42:0x00ae, B:54:0x00e5, B:56:0x00eb, B:58:0x00f1, B:84:0x0182, B:64:0x0102, B:65:0x0118, B:66:0x0119, B:70:0x0129, B:72:0x0136, B:75:0x013f, B:77:0x0151, B:80:0x0160, B:81:0x017d, B:83:0x0180, B:69:0x0125, B:86:0x01b4, B:87:0x01bb, B:47:0x00c8, B:48:0x00cb), top: B:98:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i2) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int iAbs = Math.abs(i / 60);
            int iAbs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
