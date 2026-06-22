package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import defpackage.k92;
import defpackage.n42;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbo {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            String str = (String) n42.d.c.zza((zzbbn) it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbbx.zza());
        return arrayList;
    }

    public final List zzb() {
        List listZza = zza();
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            String str = (String) n42.d.c.zza((zzbbn) it.next());
            if (!TextUtils.isEmpty(str)) {
                listZza.add(str);
            }
        }
        listZza.addAll(zzbbx.zzb());
        return listZza;
    }

    public final void zzc(zzbbn zzbbnVar) {
        this.zzb.add(zzbbnVar);
    }

    public final void zzd(zzbbn zzbbnVar) {
        this.zza.add(zzbbnVar);
    }

    public final void zze(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbbn zzbbnVar : this.zza) {
            if (zzbbnVar.zze() == 1) {
                zzbbnVar.zzd(editor, zzbbnVar.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            k92.e("Flag Json is null.");
        }
    }
}
