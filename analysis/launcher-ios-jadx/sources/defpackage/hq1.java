package defpackage;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class hq1 implements lu0 {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));
    public final Object a;

    public hq1(gq1 gq1Var) {
        this.a = gq1Var;
    }

    @Override // defpackage.lu0
    public final boolean a(Object obj) {
        return b.contains(((Uri) obj).getScheme());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [gq1, java.lang.Object] */
    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        Uri uri = (Uri) obj;
        return new ku0(new fy0(uri), this.a.h(uri));
    }
}
