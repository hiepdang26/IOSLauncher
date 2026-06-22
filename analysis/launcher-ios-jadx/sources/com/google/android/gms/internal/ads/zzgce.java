package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgce extends zzgcc implements do0 {
    @Override // defpackage.do0
    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzgcc
    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    public abstract do0 zzc();
}
