package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.j80;
import defpackage.jo1;

/* JADX INFO: loaded from: classes.dex */
public final class zzeer {
    private final Context zza;

    public zzeer(Context context) {
        this.zza = context;
    }

    public final do0 zza(boolean z) {
        try {
            j80 j80Var = new j80(z);
            jo1 jo1VarA = jo1.a(this.zza);
            return jo1VarA != null ? jo1VarA.b(j80Var) : zzgcj.zzg(new IllegalStateException());
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }
}
