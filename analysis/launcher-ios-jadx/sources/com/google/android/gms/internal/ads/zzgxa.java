package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgxa extends IOException {
    public zzgxa() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzgxa(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    public zzgxa(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
