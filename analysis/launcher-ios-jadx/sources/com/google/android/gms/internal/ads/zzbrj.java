package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class zzbrj implements View.OnClickListener {
    final /* synthetic */ zzbrk zza;

    public zzbrj(zzbrk zzbrkVar) {
        this.zza = zzbrkVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zza(true);
    }
}
