package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import defpackage.do0;
import defpackage.n42;
import defpackage.nj;
import defpackage.us;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzein {
    private final nj zza;
    private final zzeip zzb;
    private final zzfll zzc;
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) n42.d.c.zza(zzbbw.zzgh)).booleanValue();
    private final zzeey zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzein(nj njVar, zzeip zzeipVar, zzeey zzeeyVar, zzfll zzfllVar) {
        this.zza = njVar;
        this.zzb = zzeipVar;
        this.zzf = zzeeyVar;
        this.zzc = zzfllVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean zzq(zzfel zzfelVar) {
        zzeim zzeimVar = (zzeim) this.zzd.get(zzfelVar);
        if (zzeimVar == null) {
            return false;
        }
        return zzeimVar.zzc == 8;
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    public final synchronized do0 zzf(zzfex zzfexVar, zzfel zzfelVar, do0 do0Var, zzflh zzflhVar) {
        zzfeo zzfeoVar = zzfexVar.zzb.zzb;
        ((us) this.zza).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str = zzfelVar.zzw;
        if (str != null) {
            this.zzd.put(zzfelVar, new zzeim(str, zzfelVar.zzaf, 9, 0L, null));
            zzgcj.zzr(do0Var, new zzeil(this, jElapsedRealtime, zzfeoVar, zzfelVar, str, zzflhVar, zzfexVar), zzbzo.zzf);
        }
        return do0Var;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.zzd.entrySet().iterator();
            while (it.hasNext()) {
                zzeim zzeimVar = (zzeim) ((Map.Entry) it.next()).getValue();
                if (zzeimVar.zzc != Integer.MAX_VALUE) {
                    arrayList.add(zzeimVar.toString());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(zzfel zzfelVar) {
        try {
            ((us) this.zza).getClass();
            this.zzh = SystemClock.elapsedRealtime() - this.zzi;
            if (zzfelVar != null) {
                this.zzf.zze(zzfelVar);
            }
            this.zzg = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzj() {
        ((us) this.zza).getClass();
        this.zzh = SystemClock.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        ((us) this.zza).getClass();
        this.zzi = SystemClock.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfel zzfelVar = (zzfel) it.next();
            if (!TextUtils.isEmpty(zzfelVar.zzw)) {
                this.zzd.put(zzfelVar, new zzeim(zzfelVar.zzw, zzfelVar.zzaf, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0L, null));
            }
        }
    }

    public final synchronized void zzl() {
        ((us) this.zza).getClass();
        this.zzi = SystemClock.elapsedRealtime();
    }

    public final synchronized void zzm(zzfel zzfelVar) {
        zzeim zzeimVar = (zzeim) this.zzd.get(zzfelVar);
        if (zzeimVar == null || this.zzg) {
            return;
        }
        zzeimVar.zzc = 8;
    }
}
