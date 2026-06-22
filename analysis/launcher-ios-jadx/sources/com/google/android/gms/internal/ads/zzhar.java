package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhar extends RuntimeException {
    public zzhar(zzgzj zzgzjVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgyn zza() {
        return new zzgyn(getMessage());
    }
}
