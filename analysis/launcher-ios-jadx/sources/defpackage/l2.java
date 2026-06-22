package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzboi;

/* JADX INFO: loaded from: classes.dex */
public final class l2 {
    public final Context a;
    public final q52 b;

    public l2(Context context, String str) {
        hg0.j(context, "context cannot be null");
        s32 s32Var = x32.f.b;
        zzboi zzboiVar = new zzboi();
        s32Var.getClass();
        q52 q52Var = (q52) new f32(s32Var, context, str, zzboiVar).d(context, false);
        this.a = context;
        this.b = q52Var;
    }
}
