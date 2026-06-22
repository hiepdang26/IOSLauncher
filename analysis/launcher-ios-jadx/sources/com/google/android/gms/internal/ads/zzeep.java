package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.InputEvent;
import defpackage.as0;
import defpackage.do0;
import defpackage.es0;
import defpackage.fs0;
import defpackage.qg0;
import defpackage.t2;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzeep {
    private fs0 zza;
    private final Context zzb;

    public zzeep(Context context) {
        this.zzb = context;
    }

    public final do0 zza() {
        try {
            Context context = this.zzb;
            qg0.l(context, "context");
            int i = Build.VERSION.SDK_INT;
            t2 t2Var = t2.a;
            if (i >= 30) {
                t2Var.a();
            }
            as0 as0Var = (i >= 30 ? t2Var.a() : 0) >= 5 ? new as0(context) : null;
            es0 es0Var = as0Var != null ? new es0(as0Var) : null;
            this.zza = es0Var;
            return es0Var == null ? zzgcj.zzg(new IllegalStateException("MeasurementManagerFutures is null")) : es0Var.c();
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }

    public final do0 zzb(Uri uri, InputEvent inputEvent) {
        try {
            fs0 fs0Var = this.zza;
            Objects.requireNonNull(fs0Var);
            return fs0Var.a(uri, inputEvent);
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }
}
