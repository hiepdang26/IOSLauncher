package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfva extends zzfvf {
    final /* synthetic */ zzfvb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfva(zzfvb zzfvbVar, zzfvh zzfvhVar, CharSequence charSequence) {
        super(zzfvhVar, charSequence);
        this.zza = zzfvbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvf
    public final int zzc(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfvf
    public final int zzd(int i) {
        CharSequence charSequence = ((zzfvf) this).zzb;
        int length = charSequence.length();
        zzfuu.zzb(i, length, "index");
        while (i < length) {
            zzfvb zzfvbVar = this.zza;
            if (zzfvbVar.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
