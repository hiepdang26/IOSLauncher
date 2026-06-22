package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import defpackage.b22;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.hr;
import defpackage.j92;
import defpackage.n42;
import defpackage.tb2;
import defpackage.wd;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzdrp implements zzdbl, b22, zzcxk, zzcwu {
    private final Context zza;
    private final zzffy zzb;
    private final zzdsk zzc;
    private final zzfex zzd;
    private final zzfel zze;
    private final zzedh zzf;
    private final String zzg;
    private Boolean zzh;
    private final boolean zzi = ((Boolean) n42.d.c.zza(zzbbw.zzgg)).booleanValue();

    public zzdrp(Context context, zzffy zzffyVar, zzdsk zzdskVar, zzfex zzfexVar, zzfel zzfelVar, zzedh zzedhVar, String str) {
        this.zza = context;
        this.zzb = zzffyVar;
        this.zzc = zzdskVar;
        this.zzd = zzfexVar;
        this.zze = zzfelVar;
        this.zzf = zzedhVar;
        this.zzg = str;
    }

    private final zzdsj zzd(String str) {
        zzdsj zzdsjVarZza = this.zzc.zza();
        zzdsjVarZza.zzd(this.zzd.zzb.zzb);
        zzdsjVarZza.zzc(this.zze);
        zzdsjVarZza.zzb("action", str);
        zzdsjVarZza.zzb("ad_format", this.zzg.toUpperCase(Locale.ROOT));
        if (!this.zze.zzt.isEmpty()) {
            zzdsjVarZza.zzb("ancn", (String) this.zze.zzt.get(0));
        }
        if (this.zze.zzai) {
            Context context = this.zza;
            hd2 hd2Var = hd2.B;
            zzdsjVarZza.zzb("device_connectivity", true != hd2Var.g.zzA(context) ? "offline" : hr.ONLINE_EXTRAS_KEY);
            hd2Var.j.getClass();
            zzdsjVarZza.zzb("event_timestamp", String.valueOf(System.currentTimeMillis()));
            zzdsjVarZza.zzb("offline_ad", "1");
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzgo)).booleanValue()) {
            boolean z = wd.Q(this.zzd.zza.zza) != 1;
            zzdsjVarZza.zzb("scar", String.valueOf(z));
            if (z) {
                tb2 tb2Var = this.zzd.zza.zza.zzd;
                zzdsjVarZza.zzb("ragent", tb2Var.v);
                zzdsjVarZza.zzb("rtype", wd.M(wd.O(tb2Var)));
            }
        }
        return zzdsjVarZza;
    }

    private final void zze(zzdsj zzdsjVar) {
        if (!this.zze.zzai) {
            zzdsjVar.zzf();
            return;
        }
        String strZze = zzdsjVar.zze();
        hd2.B.j.getClass();
        this.zzf.zzd(new zzedj(System.currentTimeMillis(), this.zzd.zzb.zzb.zzb, strZze, 2));
    }

    private final boolean zzf() {
        String strE;
        if (this.zzh == null) {
            synchronized (this) {
                if (this.zzh == null) {
                    String str = (String) n42.d.c.zza(zzbbw.zzbj);
                    cd2 cd2Var = hd2.B.c;
                    try {
                        strE = cd2.E(this.zza);
                    } catch (RemoteException unused) {
                        strE = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strE != null) {
                        try {
                            zMatches = Pattern.matches(str, strE);
                        } catch (RuntimeException e) {
                            hd2.B.g.zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzh = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzh.booleanValue();
    }

    @Override // defpackage.b22
    public final void onAdClicked() {
        if (this.zze.zzai) {
            zze(zzd("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zza(j92 j92Var) {
        j92 j92Var2;
        if (this.zzi) {
            zzdsj zzdsjVarZzd = zzd("ifts");
            zzdsjVarZzd.zzb("reason", "adapter");
            int i = j92Var.g;
            if (j92Var.i.equals("com.google.android.gms.ads") && (j92Var2 = j92Var.j) != null && !j92Var2.i.equals("com.google.android.gms.ads")) {
                j92Var = j92Var.j;
                i = j92Var.g;
            }
            String str = j92Var.h;
            if (i >= 0) {
                zzdsjVarZzd.zzb("arec", String.valueOf(i));
            }
            String strZza = this.zzb.zza(str);
            if (strZza != null) {
                zzdsjVarZzd.zzb("areec", strZza);
            }
            zzdsjVarZzd.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzb() {
        if (this.zzi) {
            zzdsj zzdsjVarZzd = zzd("ifts");
            zzdsjVarZzd.zzb("reason", "blocked");
            zzdsjVarZzd.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzc(zzdgw zzdgwVar) {
        if (this.zzi) {
            zzdsj zzdsjVarZzd = zzd("ifts");
            zzdsjVarZzd.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdgwVar.getMessage())) {
                zzdsjVarZzd.zzb("msg", zzdgwVar.getMessage());
            }
            zzdsjVarZzd.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbl
    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbl
    public final void zzj() {
        if (zzf()) {
            zzd("adapter_impression").zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        if (zzf() || this.zze.zzai) {
            zze(zzd("impression"));
        }
    }
}
