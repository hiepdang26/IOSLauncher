package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class x52 extends j42 {
    public final tc2 a;
    public final String b;

    public x52(Context context, String str, String str2) {
        this.a = new tc2(hd2.B.c.w(context, str));
        this.b = str2;
    }

    @Override // defpackage.j42
    public final void zza() {
        this.a.zza(this.b);
    }
}
