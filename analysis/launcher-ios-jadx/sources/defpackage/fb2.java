package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;
import com.google.android.gms.internal.ads.zzhfl;

/* JADX INFO: loaded from: classes.dex */
public final class fb2 implements zzhfc {
    public final zzcgp a;
    public final zzhfl b;

    public fb2(zzcgp zzcgpVar, zzhfl zzhflVar) {
        this.a = zzcgpVar;
        this.b = zzhflVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = this.a.zza();
        zzdsp zzdspVar = (zzdsp) this.b.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new m92(contextZza, zzdspVar, zzgcuVar);
    }
}
