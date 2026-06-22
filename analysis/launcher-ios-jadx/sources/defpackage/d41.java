package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class d41 implements lu0 {
    public final Context a;
    public final lu0 b;
    public final lu0 c;
    public final Class d;

    public d41(Context context, lu0 lu0Var, lu0 lu0Var2, Class cls) {
        this.a = context.getApplicationContext();
        this.b = lu0Var;
        this.c = lu0Var2;
        this.d = cls;
    }

    @Override // defpackage.lu0
    public final boolean a(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && e42.i((Uri) obj);
    }

    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        Uri uri = (Uri) obj;
        return new ku0(new fy0(uri), new c41(this.a, this.b, this.c, uri, i, i2, g01Var, this.d));
    }
}
