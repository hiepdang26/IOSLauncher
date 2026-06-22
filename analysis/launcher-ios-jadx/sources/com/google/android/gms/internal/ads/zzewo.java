package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import defpackage.do0;
import defpackage.e3;
import defpackage.ka2;
import defpackage.n42;
import defpackage.x32;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzewo implements zzevo {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzbyv zzg;

    public zzewo(zzbyv zzbyvVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzbyvVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 40;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        zzbbn zzbbnVar = zzbbw.zzaL;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            return zzgcj.zzg(new Exception("Did not ad Ad ID into query param."));
        }
        return zzgcj.zze((zzgca) zzgcj.zzo(zzgcj.zzm(zzgca.zzu(this.zzg.zza(this.zza, this.zzd)), new zzful() { // from class: com.google.android.gms.internal.ads.zzewm
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zzc((e3) obj);
            }
        }, this.zzc), ((Long) n42Var.c.zza(zzbbw.zzaM)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzewn
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zzd((Throwable) obj);
            }
        }, this.zzc);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzewp zzc(defpackage.e3 r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfry r0 = new com.google.android.gms.internal.ads.zzfry
            r0.<init>()
            boolean r1 = r7.zze
            if (r1 != 0) goto L1b
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzcL
            n42 r2 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r2 = r2.c
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L31
        L1b:
            boolean r1 = r7.zze
            if (r1 == 0) goto L6d
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzcM
            n42 r2 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r2 = r2.c
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L6d
        L31:
            android.content.Context r0 = r7.zza     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            com.google.android.gms.internal.ads.zzfsb r1 = com.google.android.gms.internal.ads.zzfsb.zzj(r0)     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            java.util.Objects.requireNonNull(r8)     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            java.lang.String r2 = r8.a     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            java.util.Objects.requireNonNull(r2)     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            android.content.Context r0 = r7.zza     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            java.lang.String r3 = r0.getPackageName()     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzcR     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            n42 r4 = defpackage.n42.d     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            com.google.android.gms.internal.ads.zzbbu r4 = r4.c     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            java.lang.Object r0 = r4.zza(r0)     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            long r4 = r0.longValue()     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            boolean r6 = r7.zzf     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            com.google.android.gms.internal.ads.zzfry r0 = r1.zzi(r2, r3, r4, r6)     // Catch: java.lang.IllegalArgumentException -> L5c java.io.IOException -> L5e
            goto L6d
        L5c:
            r0 = move-exception
            goto L5f
        L5e:
            r0 = move-exception
        L5f:
            hd2 r1 = defpackage.hd2.B
            com.google.android.gms.internal.ads.zzbze r1 = r1.g
            java.lang.String r2 = "AdIdInfoSignalSource.getPaidV1"
            r1.zzw(r0, r2)
            com.google.android.gms.internal.ads.zzfry r0 = new com.google.android.gms.internal.ads.zzfry
            r0.<init>()
        L6d:
            com.google.android.gms.internal.ads.zzewp r1 = new com.google.android.gms.internal.ads.zzewp
            r2 = 0
            r1.<init>(r8, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewo.zzc(e3):com.google.android.gms.internal.ads.zzewp");
    }

    public final zzewp zzd(Throwable th) {
        ka2 ka2Var = x32.f.a;
        ContentResolver contentResolver = this.zza.getContentResolver();
        return new zzewp(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfry());
    }
}
