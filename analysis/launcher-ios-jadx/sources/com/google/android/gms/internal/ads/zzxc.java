package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
final class zzxc extends zzxp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzxi zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    /* JADX WARN: Multi-variable type inference failed */
    public zzxc(int i, zzcd zzcdVar, int i2, zzxi zzxiVar, int i3, boolean z, zzfuv zzfuvVar, int i4) {
        int i5;
        int iZzc;
        int iZzc2;
        boolean z2;
        super(i, zzcdVar, i2);
        this.zzh = zzxiVar;
        int i6 = 1;
        int i7 = true != zzxiVar.zzL ? 16 : 24;
        this.zzg = zzxt.zzh(this.zzd.zzd);
        this.zzi = zzlf.zza(i3, false);
        int i8 = 0;
        while (true) {
            int size = zzxiVar.zzn.size();
            i5 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (i8 >= size) {
                i8 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                iZzc = 0;
                break;
            } else {
                iZzc = zzxt.zzc(this.zzd, (String) zzxiVar.zzn.get(i8), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        this.zzk = i8;
        this.zzj = iZzc;
        this.zzl = zzxt.zzb(this.zzd.zzf, 0);
        zzaf zzafVar = this.zzd;
        int i9 = zzafVar.zzf;
        this.zzm = i9 == 0 || (i9 & 1) != 0;
        this.zzp = 1 == (zzafVar.zze & 1);
        this.zzq = zzafVar.zzz;
        this.zzr = zzafVar.zzA;
        this.zzs = zzafVar.zzi;
        this.zzf = zzfuvVar.zza(zzafVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = zzet.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            strArrSplit[i10] = zzet.zzD(strArrSplit[i10]);
        }
        int i11 = 0;
        while (true) {
            if (i11 >= strArrSplit.length) {
                i11 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                iZzc2 = 0;
                break;
            } else {
                iZzc2 = zzxt.zzc(this.zzd, strArrSplit[i11], false);
                if (iZzc2 > 0) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.zzn = i11;
        this.zzo = iZzc2;
        int i12 = 0;
        while (true) {
            if (i12 >= zzxiVar.zzr.size()) {
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzxiVar.zzr.get(i12))) {
                i5 = i12;
                break;
            }
            i12++;
        }
        this.zzt = i5;
        this.zzu = (i3 & 384) == 128;
        this.zzv = (i3 & 64) == 64;
        zzxi zzxiVar2 = this.zzh;
        if (!zzlf.zza(i3, zzxiVar2.zzN) || (!(z2 = this.zzf) && !zzxiVar2.zzG)) {
            i6 = 0;
        } else if (zzlf.zza(i3, false) && z2 && this.zzd.zzi != -1 && ((zzxiVar2.zzP || !z) && (i7 & i3) != 0)) {
            i6 = 2;
        }
        this.zze = i6;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxc zzxcVar) {
        zzfzc zzfzcVarZza = (this.zzf && this.zzi) ? zzxt.zzb : zzxt.zzb.zza();
        zzfxg zzfxgVarZzc = zzfxg.zzj().zzd(this.zzi, zzxcVar.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzxcVar.zzk), zzfzc.zzc().zza()).zzb(this.zzj, zzxcVar.zzj).zzb(this.zzl, zzxcVar.zzl).zzd(this.zzp, zzxcVar.zzp).zzd(this.zzm, zzxcVar.zzm).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzxcVar.zzn), zzfzc.zzc().zza()).zzb(this.zzo, zzxcVar.zzo).zzd(this.zzf, zzxcVar.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzxcVar.zzt), zzfzc.zzc().zza());
        boolean z = this.zzh.zzy;
        zzfxg zzfxgVarZzc2 = zzfxgVarZzc.zzd(this.zzu, zzxcVar.zzu).zzd(this.zzv, zzxcVar.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzxcVar.zzq), zzfzcVarZza).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzxcVar.zzr), zzfzcVarZza);
        if (zzet.zzG(this.zzg, zzxcVar.zzg)) {
            zzfxgVarZzc2 = zzfxgVarZzc2.zzc(Integer.valueOf(this.zzs), Integer.valueOf(zzxcVar.zzs), zzfzcVarZza);
        }
        return zzfxgVarZzc2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxpVar) {
        String str;
        zzxc zzxcVar = (zzxc) zzxpVar;
        boolean z = this.zzh.zzJ;
        zzaf zzafVar = this.zzd;
        int i = zzafVar.zzz;
        if (i == -1) {
            return false;
        }
        zzaf zzafVar2 = zzxcVar.zzd;
        if (i != zzafVar2.zzz || (str = zzafVar.zzm) == null || !TextUtils.equals(str, zzafVar2.zzm)) {
            return false;
        }
        boolean z2 = this.zzh.zzI;
        int i2 = this.zzd.zzA;
        return i2 != -1 && i2 == zzxcVar.zzd.zzA && this.zzu == zzxcVar.zzu && this.zzv == zzxcVar.zzv;
    }
}
