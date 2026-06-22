package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfny extends zzfnu {
    public zzfny(zzfnn zzfnnVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnnVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfml zzfmlVarZza = zzfml.zza();
        if (zzfmlVarZza != null) {
            for (zzflu zzfluVar : zzfmlVarZza.zzc()) {
                if (((zzfnu) this).zza.contains(zzfluVar.zzh())) {
                    zzfluVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfnv, android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    @Override // com.google.android.gms.internal.ads.zzfnv
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
