package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import defpackage.do0;
import defpackage.ib2;
import defpackage.n42;
import defpackage.or1;
import defpackage.za2;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvu {
    private final zzfjl zza;
    private final or1 zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhew zzg;
    private final String zzh;
    private final zzevr zzi;
    private final za2 zzj;
    private final zzffg zzk;
    private final zzdcc zzl;

    public zzcvu(zzfjl zzfjlVar, or1 or1Var, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhew zzhewVar, za2 za2Var, String str2, zzevr zzevrVar, zzffg zzffgVar, zzdcc zzdccVar) {
        this.zza = zzfjlVar;
        this.zzb = or1Var;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhewVar;
        this.zzh = str2;
        this.zzi = zzevrVar;
        this.zzj = za2Var;
        this.zzk = zzffgVar;
        this.zzl = zzdccVar;
    }

    public final zzbvb zza(do0 do0Var, Bundle bundle) {
        Bundle bundle2 = (Bundle) do0Var.get();
        String str = (String) ((do0) this.zzg.zzb()).get();
        boolean z = ((Boolean) n42.d.c.zza(zzbbw.zzgu)).booleanValue() && ((ib2) this.zzj).q();
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        return new zzbvb(bundle2, this.zzb, this.zzc, this.zzd, list, packageInfo, str, str2, null, null, z, this.zzk.zzb(), bundle);
    }

    public final do0 zzb(Bundle bundle) {
        this.zzl.zza();
        return zzfiv.zzc(this.zzi.zza(new Bundle(), bundle), zzfjf.SIGNALS, this.zza).zza();
    }

    public final do0 zzc() {
        final Bundle bundle = new Bundle();
        if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue()) {
            Bundle bundle2 = this.zzk.zzs;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        final do0 do0VarZzb = zzb(bundle);
        return this.zza.zza(zzfjf.REQUEST_PARCEL, do0VarZzb, (do0) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcvt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(do0VarZzb, bundle);
            }
        }).zza();
    }
}
