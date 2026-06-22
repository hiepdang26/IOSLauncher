package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
public final class zzepl implements zzevo {
    private static final Object zzb = new Object();
    final Context zza;
    private final String zzc;
    private final String zzd;
    private final long zze;
    private final zzcto zzf;
    private final zzfgo zzg;
    private final zzffg zzh;
    private final za2 zzi = hd2.B.g.zzi();
    private final zzdsf zzj;
    private final zzcub zzk;

    public zzepl(Context context, String str, String str2, zzcto zzctoVar, zzfgo zzfgoVar, zzffg zzffgVar, zzdsf zzdsfVar, zzcub zzcubVar, long j) {
        this.zza = context;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = zzctoVar;
        this.zzg = zzfgoVar;
        this.zzh = zzffgVar;
        this.zzj = zzdsfVar;
        this.zzk = zzcubVar;
        this.zze = j;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        final Bundle bundle = new Bundle();
        this.zzj.zzb().put("seq_num", this.zzc);
        zzbbn zzbbnVar = zzbbw.zzbS;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            zzdsf zzdsfVar = this.zzj;
            hd2.B.j.getClass();
            zzdsfVar.zzc("tsacc", String.valueOf(System.currentTimeMillis() - this.zze));
            this.zzj.zzc("foreground", true != cd2.e(this.zza) ? "1" : "0");
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzeX)).booleanValue()) {
            this.zzf.zzk(this.zzh.zzd);
            bundle.putAll(this.zzg.zzb());
        }
        return zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzepk
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                this.zza.zzc(bundle, (Bundle) obj);
            }
        });
    }

    public final void zzc(Bundle bundle, Bundle bundle2) {
        zzbbn zzbbnVar = zzbbw.zzeX;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) n42Var.c.zza(zzbbw.zzeW)).booleanValue()) {
                synchronized (zzb) {
                    this.zzf.zzk(this.zzh.zzd);
                    bundle2.putBundle("quality_signals", this.zzg.zzb());
                }
            } else {
                this.zzf.zzk(this.zzh.zzd);
                bundle2.putBundle("quality_signals", this.zzg.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzc);
        if (!((ib2) this.zzi).q()) {
            bundle2.putString("session_id", this.zzd);
        }
        bundle2.putBoolean("client_purpose_one", !((ib2) this.zzi).q());
        if (((Boolean) n42Var.c.zza(zzbbw.zzeY)).booleanValue()) {
            try {
                cd2 cd2Var = hd2.B.c;
                bundle2.putString("_app_id", cd2.E(this.zza));
            } catch (RemoteException | RuntimeException e) {
                hd2.B.g.zzw(e, "AppStatsSignal_AppId");
            }
        }
        zzbbn zzbbnVar2 = zzbbw.zzeZ;
        n42 n42Var2 = n42.d;
        if (((Boolean) n42Var2.c.zza(zzbbnVar2)).booleanValue() && this.zzh.zzf != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("dload", this.zzk.zzb(this.zzh.zzf));
            bundle3.putInt("pcc", this.zzk.zza(this.zzh.zzf));
            bundle2.putBundle("ad_unit_quality_signals", bundle3);
        }
        if (((Boolean) n42Var2.c.zza(zzbbw.zziQ)).booleanValue()) {
            hd2 hd2Var = hd2.B;
            if (hd2Var.g.zza() > 0) {
                bundle2.putInt("nrwv", hd2Var.g.zza());
            }
        }
    }
}
