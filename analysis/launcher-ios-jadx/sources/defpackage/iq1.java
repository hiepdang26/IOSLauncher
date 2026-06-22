package defpackage;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class iq1 implements lu0 {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final lu0 a;

    public iq1(lu0 lu0Var) {
        this.a = lu0Var;
    }

    @Override // defpackage.lu0
    public final boolean a(Object obj) {
        return b.contains(((Uri) obj).getScheme());
    }

    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        return this.a.b(new x90(((Uri) obj).toString()), i, i2, g01Var);
    }
}
