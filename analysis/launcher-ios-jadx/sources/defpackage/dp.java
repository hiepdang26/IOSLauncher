package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes.dex */
public abstract class dp {
    public static final Collection a;

    static {
        try {
            Iterator it = Arrays.asList(new q4()).iterator();
            qg0.l(it, "<this>");
            a = gf1.V(new fm(new if1(it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
