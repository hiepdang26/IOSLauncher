package defpackage;

import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdei;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;
import com.google.android.gms.internal.ads.zzhfl;

/* JADX INFO: loaded from: classes.dex */
public final class m32 implements zzhfc {
    public final /* synthetic */ int a;
    public final zzhfl b;

    public /* synthetic */ m32(zzhfl zzhflVar, int i) {
        this.a = i;
        this.b = zzhflVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        switch (this.a) {
            case 0:
                ac2 ac2Var = (ac2) this.b.zzb();
                zzgcu zzgcuVar = zzbzo.zza;
                zzhfk.zzb(zzgcuVar);
                return new zzdei(ac2Var, zzgcuVar);
            default:
                return new vb2((zzdsp) this.b.zzb());
        }
    }
}
