package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class cp0 implements dp0 {
    public static final Locale[] b = new Locale[0];
    public final Locale[] a;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        int i = bp0.b;
        String[] strArrSplit = "en-Latn".split("-", -1);
        if (strArrSplit.length > 2) {
            new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        } else if (strArrSplit.length > 1) {
            new Locale(strArrSplit[0], strArrSplit[1]);
        } else {
            if (strArrSplit.length != 1) {
                throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
            }
            new Locale(strArrSplit[0]);
        }
    }

    public cp0(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.a = b;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException(uo.d(i, "list[", "] is null"));
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                locale2.getLanguage();
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    locale2.getCountry();
                }
                hashSet.add(locale2);
            }
        }
        this.a = (Locale[]) arrayList.toArray(new Locale[0]);
    }

    @Override // defpackage.dp0
    public final Object a() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cp0)) {
            return false;
        }
        Locale[] localeArr = ((cp0) obj).a;
        Locale[] localeArr2 = this.a;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i = 0; i < localeArr2.length; i++) {
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.dp0
    public final Locale get() {
        Locale[] localeArr = this.a;
        if (localeArr.length > 0) {
            return localeArr[0];
        }
        return null;
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.a;
            if (i >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i]);
            if (i < localeArr.length - 1) {
                sb.append(',');
            }
            i++;
        }
    }
}
