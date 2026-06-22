package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzawc extends zzaxd {
    private static final zzaxe zzh = new zzaxe();
    private final Context zzi;

    public zzawc(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, Context context) {
        super(zzavpVar, "LYoHKR17UvbUNibqKPKJklawQJNaw1zk7CnhZAC68YBTzC7x4MYQVXp9Sihs98Ok", "ngqbGKXcQCvq0ft27xRzOzNoEVN+ei+Vq2+CNx9QQMc=", zzaroVar, i, 29);
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        this.zzd.zzn("E");
        AtomicReference atomicReferenceZza = zzh.zza(this.zzi.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                try {
                    if (atomicReferenceZza.get() == null) {
                        atomicReferenceZza.set((String) this.zze.invoke(null, this.zzi));
                    }
                } finally {
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        synchronized (this.zzd) {
            this.zzd.zzn(zzasz.zza(str.getBytes(), true));
        }
    }
}
