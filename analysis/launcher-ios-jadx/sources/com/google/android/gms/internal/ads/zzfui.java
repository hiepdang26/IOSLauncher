package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfui implements zzfuv {
    public static zzfui zzc(char c) {
        return new zzfuh(c);
    }

    @Override // com.google.android.gms.internal.ads.zzfuv
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
