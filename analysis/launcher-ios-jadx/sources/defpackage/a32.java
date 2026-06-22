package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbcy;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzfgf;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;
import com.google.android.gms.internal.ads.zzhfl;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class a32 implements zzhfc {
    public final zzhfc a;
    public final zzcgp b;
    public final zzhfl c;
    public final zzhfl d;
    public final zzhfl e;
    public final zzhfl f;
    public final zzhfl g;
    public final zzchc h;
    public final zzbcy i;
    public final zzhfl j;
    public final zzhfl k;

    public a32(zzhfc zzhfcVar, zzcgp zzcgpVar, zzhfl zzhflVar, zzhfl zzhflVar2, zzhfl zzhflVar3, zzhfl zzhflVar4, zzhfl zzhflVar5, zzchc zzchcVar, zzbcy zzbcyVar, zzhfl zzhflVar6, zzhfl zzhflVar7) {
        this.a = zzhfcVar;
        this.b = zzcgpVar;
        this.c = zzhflVar;
        this.d = zzhflVar2;
        this.e = zzhflVar3;
        this.f = zzhflVar4;
        this.g = zzhflVar5;
        this.h = zzchcVar;
        this.i = zzbcyVar;
        this.j = zzhflVar6;
        this.k = zzhflVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcgj zzcgjVar = (zzcgj) this.a.zzb();
        Context contextZza = this.b.zza();
        zzauo zzauoVar = (zzauo) this.c.zzb();
        zzfgf zzfgfVar = (zzfgf) this.d.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new y22(zzcgjVar, contextZza, zzauoVar, zzfgfVar, zzgcuVar, (ScheduledExecutorService) this.e.zzb(), (zzdsp) this.f.zzb(), (zzfll) this.g.zzb(), this.h.zza(), this.i.zzb(), (zzffk) this.j.zzb(), (m92) this.k.zzb());
    }
}
