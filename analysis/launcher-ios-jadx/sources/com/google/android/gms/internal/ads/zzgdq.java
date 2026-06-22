package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzgdq {
    private final OutputStream zza;

    private zzgdq(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzgdq zzb(OutputStream outputStream) {
        return new zzgdq(outputStream);
    }

    public final void zza(zzgth zzgthVar) throws IOException {
        try {
            zzgthVar.zzaU(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
