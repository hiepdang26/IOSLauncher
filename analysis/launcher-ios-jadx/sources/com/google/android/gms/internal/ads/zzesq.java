package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import defpackage.do0;
import defpackage.n42;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesq implements zzevo {
    private final zzgcu zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzesq(zzgcu zzgcuVar, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgcuVar;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 22;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzesr zzc() {
        zzbbn zzbbnVar = zzbbw.zzfl;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzesr(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        boolean zBooleanValue = ((Boolean) n42Var.c.zza(zzbbw.zzfm)).booleanValue();
        Boolean boolValueOf = null;
        if (zBooleanValue && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        boolValueOf = Boolean.valueOf((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    boolValueOf = Boolean.TRUE;
                }
                return new zzesr(boolValueOf);
            }
        }
        return new zzesr(null);
    }
}
