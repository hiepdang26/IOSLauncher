package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.pd2;
import defpackage.tb2;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzfgv implements zzfgu {
    private final ConcurrentHashMap zza;
    private final zzfhb zzb;
    private final zzfgx zzc = new zzfgx();

    public zzfgv(zzfhb zzfhbVar) {
        this.zza = new ConcurrentHashMap(zzfhbVar.zzd);
        this.zzb = zzfhbVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfhb> creator = zzfhb.CREATOR;
        if (((Boolean) n42.d.c.zza(zzbbw.zzfH)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfhe) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfgt) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int iZzb = ((zzfgt) entry.getValue()).zzb(); iZzb < this.zzb.zzd; iZzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfgt) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            k92.d(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final zzfhb zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final synchronized zzfhd zzb(zzfhe zzfheVar) {
        zzfhd zzfhdVarZze;
        try {
            zzfgt zzfgtVar = (zzfgt) this.zza.get(zzfheVar);
            if (zzfgtVar != null) {
                zzfhdVarZze = zzfgtVar.zze();
                if (zzfhdVarZze == null) {
                    this.zzc.zze();
                }
                zzfhr zzfhrVarZzf = zzfgtVar.zzf();
                if (zzfhdVarZze != null) {
                    zzbbc.zzb.zzc zzcVarZzd = zzbbc.zzb.zzd();
                    zzbbc.zzb.zza.C0003zza c0003zzaZza = zzbbc.zzb.zza.zza();
                    c0003zzaZza.zzf(zzbbc.zzb.zzd.IN_MEMORY);
                    zzbbc.zzb.zze.zza zzaVarZzc = zzbbc.zzb.zze.zzc();
                    zzaVarZzc.zzd(zzfhrVarZzf.zza);
                    zzaVarZzc.zze(zzfhrVarZzf.zzb);
                    c0003zzaZza.zzg(zzaVarZzc);
                    zzcVarZzd.zzd(c0003zzaZza);
                    zzfhdVarZze.zza.zzb().zzc().zzi(zzcVarZzd.zzbr());
                }
                zzf();
            } else {
                this.zzc.zzf();
                zzf();
                zzfhdVarZze = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzfhdVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    @Deprecated
    public final zzfhe zzc(tb2 tb2Var, String str, pd2 pd2Var) {
        return new zzfhf(tb2Var, str, new zzbve(this.zzb.zza).zza().zzj, this.zzb.zzf, pd2Var);
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final synchronized boolean zzd(zzfhe zzfheVar, zzfhd zzfhdVar) {
        boolean zZzh;
        try {
            zzfgt zzfgtVar = (zzfgt) this.zza.get(zzfheVar);
            hd2.B.j.getClass();
            zzfhdVar.zzd = System.currentTimeMillis();
            if (zzfgtVar == null) {
                zzfhb zzfhbVar = this.zzb;
                zzfgt zzfgtVar2 = new zzfgt(zzfhbVar.zzd, zzfhbVar.zze * zzbbc.zzq.zzf);
                if (this.zza.size() == this.zzb.zzc) {
                    int i = this.zzb.zzg;
                    int i2 = i - 1;
                    zzfhe zzfheVar2 = null;
                    if (i == 0) {
                        throw null;
                    }
                    long jZzc = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry entry : this.zza.entrySet()) {
                            if (((zzfgt) entry.getValue()).zzc() < jZzc) {
                                jZzc = ((zzfgt) entry.getValue()).zzc();
                                zzfheVar2 = (zzfhe) entry.getKey();
                            }
                        }
                        if (zzfheVar2 != null) {
                            this.zza.remove(zzfheVar2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry entry2 : this.zza.entrySet()) {
                            if (((zzfgt) entry2.getValue()).zzd() < jZzc) {
                                jZzc = ((zzfgt) entry2.getValue()).zzd();
                                zzfheVar2 = (zzfhe) entry2.getKey();
                            }
                        }
                        if (zzfheVar2 != null) {
                            this.zza.remove(zzfheVar2);
                        }
                    } else if (i2 == 2) {
                        int iZza = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        for (Map.Entry entry3 : this.zza.entrySet()) {
                            if (((zzfgt) entry3.getValue()).zza() < iZza) {
                                iZza = ((zzfgt) entry3.getValue()).zza();
                                zzfheVar2 = (zzfhe) entry3.getKey();
                            }
                        }
                        if (zzfheVar2 != null) {
                            this.zza.remove(zzfheVar2);
                        }
                    }
                    this.zzc.zzg();
                }
                this.zza.put(zzfheVar, zzfgtVar2);
                this.zzc.zzd();
                zzfgtVar = zzfgtVar2;
            }
            zZzh = zzfgtVar.zzh(zzfhdVar);
            this.zzc.zzc();
            zzfgw zzfgwVarZza = this.zzc.zza();
            zzfhr zzfhrVarZzf = zzfgtVar.zzf();
            zzbbc.zzb.zzc zzcVarZzd = zzbbc.zzb.zzd();
            zzbbc.zzb.zza.C0003zza c0003zzaZza = zzbbc.zzb.zza.zza();
            c0003zzaZza.zzf(zzbbc.zzb.zzd.IN_MEMORY);
            zzbbc.zzb.zzg.zza zzaVarZzc = zzbbc.zzb.zzg.zzc();
            zzaVarZzc.zze(zzfgwVarZza.zza);
            zzaVarZzc.zzf(zzfgwVarZza.zzb);
            zzaVarZzc.zzg(zzfhrVarZzf.zzb);
            c0003zzaZza.zzi(zzaVarZzc);
            zzcVarZzd.zzd(c0003zzaZza);
            zzfhdVar.zza.zzb().zzc().zzj(zzcVarZzd.zzbr());
            zzf();
        } catch (Throwable th) {
            throw th;
        }
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final synchronized boolean zze(zzfhe zzfheVar) {
        zzfgt zzfgtVar = (zzfgt) this.zza.get(zzfheVar);
        if (zzfgtVar == null) {
            return true;
        }
        return zzfgtVar.zzb() < this.zzb.zzd;
    }
}
