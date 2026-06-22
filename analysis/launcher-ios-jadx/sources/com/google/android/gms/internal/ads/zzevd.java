package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import defpackage.cd2;
import defpackage.do0;
import defpackage.dy;
import defpackage.hd2;
import defpackage.j02;
import defpackage.or1;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzevd implements zzevo {
    private final zzgcu zza;
    private final Context zzb;
    private final or1 zzc;
    private final String zzd;

    public zzevd(zzgcu zzgcuVar, Context context, or1 or1Var, String str) {
        this.zza = zzgcuVar;
        this.zzb = context;
        this.zzc = or1Var;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 35;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzeve zzc() {
        boolean zI = j02.a(this.zzb).i();
        cd2 cd2Var = hd2.B.c;
        boolean zD = cd2.d(this.zzb);
        String str = this.zzc.g;
        int iMyUid = Process.myUid();
        boolean z = iMyUid == 0 || iMyUid == 1000;
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        int i = applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
        Context context = this.zzb;
        return new zzeve(zI, zD, str, z, i, dy.d(context, ModuleDescriptor.MODULE_ID, false), dy.a(context, ModuleDescriptor.MODULE_ID), this.zzd);
    }
}
