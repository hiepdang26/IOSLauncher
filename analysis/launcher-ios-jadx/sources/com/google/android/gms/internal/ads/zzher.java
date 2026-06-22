package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class zzher extends zzheu {
    final Logger zza;

    public zzher(String str) {
        this.zza = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zzheu
    public final void zza(String str) {
        this.zza.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
