package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfvc extends zzfvf {
    public zzfvc(zzfvd zzfvdVar, zzfvh zzfvhVar, CharSequence charSequence) {
        super(zzfvhVar, charSequence);
    }

    @Override // com.google.android.gms.internal.ads.zzfvf
    public final int zzc(int i) {
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzfvf
    public final int zzd(int i) {
        int i2 = i + 4000;
        if (i2 < ((zzfvf) this).zzb.length()) {
            return i2;
        }
        return -1;
    }
}
