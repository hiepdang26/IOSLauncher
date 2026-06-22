package defpackage;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class ks0 {
    public static final Pattern d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final String a;
    public final String b;
    public final String c;

    public ks0(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static ks0 a(String str) {
        Matcher matcher = d.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = e.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup3 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup3;
            }
        }
        return new ks0(str, lowerCase, str2);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ks0) && ((ks0) obj).a.equals(this.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
