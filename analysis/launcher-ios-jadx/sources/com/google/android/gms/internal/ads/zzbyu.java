package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.f3;
import defpackage.ia0;
import defpackage.k92;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzbyu implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbzt zzb;

    public zzbyu(zzbyv zzbyvVar, Context context, zzbzt zzbztVar) {
        this.zza = context;
        this.zzb = zzbztVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc(f3.a(this.zza));
        } catch (ia0 | IOException | IllegalStateException e) {
            this.zzb.zzd(e);
            k92.f();
        }
    }
}
