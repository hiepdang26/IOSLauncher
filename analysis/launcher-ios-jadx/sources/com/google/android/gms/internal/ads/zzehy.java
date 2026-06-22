package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzehy {
    private final zzgdc zzc;
    private zzeio zzf;
    private final String zzh;
    private final int zzi;
    private final zzein zzj;
    private zzfel zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private boolean zzl = false;

    public zzehy(zzfex zzfexVar, zzein zzeinVar, zzgdc zzgdcVar) {
        this.zzi = zzfexVar.zzb.zzb.zzr;
        this.zzj = zzeinVar;
        this.zzc = zzgdcVar;
        this.zzh = zzeiu.zzc(zzfexVar);
        List list = zzfexVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfel) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzeio zzeioVar = this.zzf;
        if (zzeioVar != null) {
            this.zzc.zzc(zzeioVar);
        } else {
            this.zzc.zzd(new zzeir(3, this.zzh));
        }
    }

    private final synchronized boolean zzf(boolean z) {
        try {
            for (zzfel zzfelVar : this.zzb) {
                Integer num = (Integer) this.zza.get(zzfelVar);
                int iIntValue = num != null ? num.intValue() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (z || !this.zze.contains(zzfelVar.zzat)) {
                    int i = this.zzg;
                    if (iIntValue < i) {
                        return true;
                    }
                    if (iIntValue > i) {
                        break;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzg() {
        try {
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) this.zza.get((zzfel) it.next());
                if ((num != null ? num.intValue() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) < this.zzg) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzh() {
        if (!zzf(true)) {
            if (!zzg()) {
                return false;
            }
        }
        return true;
    }

    private final synchronized boolean zzi() {
        if (this.zzl) {
            return false;
        }
        if (!this.zzb.isEmpty() && ((zzfel) this.zzb.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list = this.zzd;
            if (list.size() < this.zzi) {
                if (zzf(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final synchronized zzfel zza() {
        try {
            if (zzi()) {
                for (int i = 0; i < this.zzb.size(); i++) {
                    zzfel zzfelVar = (zzfel) this.zzb.get(i);
                    String str = zzfelVar.zzat;
                    if (!this.zze.contains(str)) {
                        if (zzfelVar.zzav) {
                            this.zzl = true;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            this.zze.add(str);
                        }
                        this.zzd.add(zzfelVar);
                        return (zzfel) this.zzb.remove(i);
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(Throwable th, zzfel zzfelVar) {
        this.zzl = false;
        this.zzd.remove(zzfelVar);
        this.zze.remove(zzfelVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zze();
    }

    public final synchronized void zzc(zzeio zzeioVar, zzfel zzfelVar) {
        this.zzl = false;
        this.zzd.remove(zzfelVar);
        if (zzd()) {
            zzeioVar.zzr();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfelVar);
        int iIntValue = num != null ? num.intValue() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (iIntValue > this.zzg) {
            this.zzj.zzm(zzfelVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = iIntValue;
        this.zzf = zzeioVar;
        this.zzk = zzfelVar;
        if (zzh()) {
            return;
        }
        zze();
    }

    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
