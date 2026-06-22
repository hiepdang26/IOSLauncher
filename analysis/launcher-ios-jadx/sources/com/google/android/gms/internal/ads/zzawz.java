package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawz extends zzaxd {
    public zzawz(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2) {
        super(zzavpVar, "5HcA415u1KU8m2yVlDZBhQQK+0IFNRmmWPxuAq0DnfPzSdJ/uWlnYMD1kKfkH6cZ", "u7Ufq5yuXkEXg69T8jpWuOOX55Q9g2DSVI1gtbNUvY8=", zzaroVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        this.zzd.zzag(3);
        boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
        synchronized (this.zzd) {
            try {
                if (zBooleanValue) {
                    this.zzd.zzag(2);
                } else {
                    this.zzd.zzag(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
