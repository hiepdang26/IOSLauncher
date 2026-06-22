package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.ed2;
import defpackage.hd2;
import defpackage.j92;
import defpackage.n42;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class zzeey {
    private final String zzc;
    private zzfeo zzd = null;
    private zzfel zze = null;
    private ed2 zzf = null;
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final List zza = Collections.synchronizedList(new ArrayList());

    public zzeey(String str) {
        this.zzc = str;
    }

    private static String zzj(zzfel zzfelVar) {
        return ((Boolean) n42.d.c.zza(zzbbw.zzdi)).booleanValue() ? zzfelVar.zzap : zzfelVar.zzw;
    }

    private final synchronized void zzk(zzfel zzfelVar, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        Map map = this.zzb;
        String strZzj = zzj(zzfelVar);
        if (map.containsKey(strZzj)) {
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = zzfelVar.zzv.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                bundle.putString(next, zzfelVar.zzv.getString(next));
            } catch (JSONException unused) {
            }
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzgd)).booleanValue()) {
            str = zzfelVar.zzF;
            str2 = zzfelVar.zzG;
            str3 = zzfelVar.zzH;
            str4 = zzfelVar.zzI;
        } else {
            str = "";
            str2 = "";
            str3 = "";
            str4 = "";
        }
        ed2 ed2Var = new ed2(zzfelVar.zzE, 0L, null, bundle, str, str2, str3, str4);
        try {
            this.zza.add(i, ed2Var);
        } catch (IndexOutOfBoundsException e) {
            hd2.B.g.zzw(e, "AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation");
        }
        this.zzb.put(strZzj, ed2Var);
    }

    private final void zzl(zzfel zzfelVar, long j, j92 j92Var, boolean z) {
        Map map = this.zzb;
        String strZzj = zzj(zzfelVar);
        if (map.containsKey(strZzj)) {
            if (this.zze == null) {
                this.zze = zzfelVar;
            }
            ed2 ed2Var = (ed2) this.zzb.get(strZzj);
            ed2Var.h = j;
            ed2Var.i = j92Var;
            if (((Boolean) n42.d.c.zza(zzbbw.zzge)).booleanValue() && z) {
                this.zzf = ed2Var;
            }
        }
    }

    public final ed2 zza() {
        return this.zzf;
    }

    public final zzcwj zzb() {
        return new zzcwj(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzfel zzfelVar) {
        zzk(zzfelVar, this.zza.size());
    }

    public final void zze(zzfel zzfelVar) {
        int iIndexOf = this.zza.indexOf(this.zzb.get(zzj(zzfelVar)));
        if (iIndexOf < 0 || iIndexOf >= this.zzb.size()) {
            iIndexOf = this.zza.indexOf(this.zzf);
        }
        if (iIndexOf < 0 || iIndexOf >= this.zzb.size()) {
            return;
        }
        this.zzf = (ed2) this.zza.get(iIndexOf);
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.zza.size()) {
                return;
            }
            ed2 ed2Var = (ed2) this.zza.get(iIndexOf);
            ed2Var.h = 0L;
            ed2Var.i = null;
        }
    }

    public final void zzf(zzfel zzfelVar, long j, j92 j92Var) {
        zzl(zzfelVar, j, j92Var, false);
    }

    public final void zzg(zzfel zzfelVar, long j, j92 j92Var) {
        zzl(zzfelVar, j, null, true);
    }

    public final synchronized void zzh(String str, List list) {
        if (this.zzb.containsKey(str)) {
            int iIndexOf = this.zza.indexOf((ed2) this.zzb.get(str));
            try {
                this.zza.remove(iIndexOf);
            } catch (IndexOutOfBoundsException e) {
                hd2.B.g.zzw(e, "AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry");
            }
            this.zzb.remove(str);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzk((zzfel) it.next(), iIndexOf);
                iIndexOf++;
            }
        }
    }

    public final void zzi(zzfeo zzfeoVar) {
        this.zzd = zzfeoVar;
    }
}
