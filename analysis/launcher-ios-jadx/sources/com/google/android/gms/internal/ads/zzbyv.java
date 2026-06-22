package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.ea0;
import defpackage.ka2;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyv {
    public final do0 zza(Context context, int i) {
        zzbzt zzbztVar = new zzbzt();
        ka2 ka2Var = x32.f.a;
        int iC = ea0.b.c(context, 12451000);
        if (iC != 0 && iC != 2) {
            return zzbztVar;
        }
        zzbzo.zza.execute(new zzbyu(this, context, zzbztVar));
        return zzbztVar;
    }
}
