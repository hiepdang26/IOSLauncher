package defpackage;

import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcvu;
import com.google.android.gms.internal.ads.zzcvv;
import com.google.android.gms.internal.ads.zzdff;
import com.google.android.gms.internal.ads.zzdxl;
import com.google.android.gms.internal.ads.zzfiq;
import com.google.android.gms.internal.ads.zzfjf;
import com.google.android.gms.internal.ads.zzfjl;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;
import com.google.android.gms.internal.ads.zzhfl;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class n32 implements zzhfc {
    public final zzhfl a;
    public final t32 b;
    public final zzcvv c;
    public final zzhfl d;

    public n32(zzhfl zzhflVar, t32 t32Var, zzcvv zzcvvVar, zzhfl zzhflVar2) {
        this.a = zzhflVar;
        this.b = t32Var;
        this.c = zzcvvVar;
        this.d = zzhflVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzfjl zzfjlVar = (zzfjl) this.a.zzb();
        t32 t32Var = this.b;
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        r32 r32Var = new r32(zzgcuVar, ((zzdxl) t32Var.b).zzb());
        zzcvu zzcvuVarZzb = this.c.zzb();
        zzdff zzdffVar = (zzdff) this.d.zzb();
        zzfiq zzfiqVarZza = zzfjlVar.zzb(zzfjf.GENERATE_SIGNALS, zzcvuVarZzb.zzc()).zzf(r32Var).zzi(((Integer) n42.d.c.zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS).zza();
        zzgcj.zzr(zzfiqVarZza, new ew1(zzdffVar, 4), zzgcuVar);
        return zzfiqVarZza;
    }
}
