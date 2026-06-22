package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import defpackage.ib2;
import defpackage.za2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmc implements zzcly {
    private final za2 zza;

    public zzcmc(za2 za2Var) {
        this.zza = za2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        boolean z = Boolean.parseBoolean((String) map.get("content_vertical_opted_out"));
        ib2 ib2Var = (ib2) this.zza;
        ib2Var.r();
        synchronized (ib2Var.a) {
            try {
                if (ib2Var.v == z) {
                    return;
                }
                ib2Var.v = z;
                SharedPreferences.Editor editor = ib2Var.g;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    ib2Var.g.apply();
                }
                ib2Var.s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
