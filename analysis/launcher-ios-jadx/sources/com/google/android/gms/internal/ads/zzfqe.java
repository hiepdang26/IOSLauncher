package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqe extends Exception {
    private final int zza;

    public zzfqe(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzfqe(int i, Throwable th) {
        super(th);
        this.zza = i;
    }
}
