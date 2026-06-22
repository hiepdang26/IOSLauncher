package defpackage;

import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzdxl;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;

/* JADX INFO: loaded from: classes.dex */
public final class t32 implements zzhfc {
    public final /* synthetic */ int a;
    public final zzhfc b;

    public /* synthetic */ t32(zzhfc zzhfcVar, int i) {
        this.a = i;
        this.b = zzhfcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        switch (this.a) {
            case 0:
                zzgcu zzgcuVar = zzbzo.zza;
                zzhfk.zzb(zzgcuVar);
                return new r32(zzgcuVar, ((zzdxl) this.b).zzb());
            default:
                return new s62(((zzcgp) this.b).zza());
        }
    }
}
