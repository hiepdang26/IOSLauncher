package defpackage;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class yj extends xj {
    public static int w(Iterable iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
