package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
public class zzci {
    public final zzfxu zzA;
    public final zzfxw zzB;
    public final int zzi;
    public final int zzj;
    public final boolean zzk;
    public final zzfxr zzl;
    public final zzfxr zzn;
    public final zzfxr zzr;
    public final zzcg zzs;
    public final zzfxr zzt;
    public final int zzu;
    public final int zza = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public final int zzb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public final int zzc = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public final int zzd = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public final int zze = 0;
    public final int zzf = 0;
    public final int zzg = 0;
    public final int zzh = 0;
    public final int zzm = 0;
    public final int zzo = 0;
    public final int zzp = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public final int zzq = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public final int zzv = 0;
    public final boolean zzw = false;
    public final boolean zzx = false;
    public final boolean zzy = false;
    public final boolean zzz = false;

    static {
        new zzci(new zzch());
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
    }

    public zzci(zzch zzchVar) {
        this.zzi = zzchVar.zze;
        this.zzj = zzchVar.zzf;
        this.zzk = zzchVar.zzg;
        this.zzl = zzchVar.zzh;
        this.zzn = zzchVar.zzi;
        this.zzr = zzchVar.zzl;
        this.zzs = zzchVar.zzm;
        this.zzt = zzchVar.zzn;
        this.zzu = zzchVar.zzo;
        this.zzA = zzfxu.zzc(zzchVar.zzp);
        this.zzB = zzfxw.zzl(zzchVar.zzq);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzci zzciVar = (zzci) obj;
            if (this.zzk == zzciVar.zzk && this.zzi == zzciVar.zzi && this.zzj == zzciVar.zzj && this.zzl.equals(zzciVar.zzl) && this.zzn.equals(zzciVar.zzn) && this.zzr.equals(zzciVar.zzr) && this.zzs.equals(zzciVar.zzs) && this.zzt.equals(zzciVar.zzt) && this.zzu == zzciVar.zzu && this.zzA.equals(zzciVar.zzA) && this.zzB.equals(zzciVar.zzB)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.zzk ? 1 : 0) - 1048002209;
        int iHashCode = (this.zzn.hashCode() + ((this.zzl.hashCode() + (((((i * 31) + this.zzi) * 31) + this.zzj) * 31)) * 961)) * 961;
        return this.zzB.hashCode() + ((this.zzA.hashCode() + ((((this.zzt.hashCode() + ((((this.zzr.hashCode() + ((((iHashCode + ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) * 31) + ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) * 31)) * 31) + 29791) * 31)) * 31) + this.zzu) * 887503681)) * 31);
    }
}
