package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfnv extends AsyncTask {
    private zzfnw zza;
    protected final zzfnn zzd;

    public zzfnv(zzfnn zzfnnVar) {
        this.zzd = zzfnnVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfnw zzfnwVar = this.zza;
        if (zzfnwVar != null) {
            zzfnwVar.zza(this);
        }
    }

    public final void zzb(zzfnw zzfnwVar) {
        this.zza = zzfnwVar;
    }
}
