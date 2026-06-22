package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfnt implements zzfmu {
    private static final zzfnt zza = new zzfnt();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzfnp();
    private static final Runnable zze = new zzfnq();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfnm zzk = new zzfnm();
    private final zzfmw zzj = new zzfmw();
    private final zzfnn zzl = new zzfnn(new zzfnw());

    public static zzfnt zzd() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzfnt zzfntVar) {
        zzfnt zzfntVar2;
        zzfntVar.zzg = 0;
        zzfntVar.zzi.clear();
        zzfntVar.zzh = false;
        for (zzflu zzfluVar : zzfml.zza().zzb()) {
        }
        zzfntVar.zzm = System.nanoTime();
        zzfntVar.zzk.zzi();
        long jNanoTime = System.nanoTime();
        zzfmv zzfmvVarZza = zzfntVar.zzj.zza();
        if (zzfntVar.zzk.zze().size() > 0) {
            for (String str : zzfntVar.zzk.zze()) {
                JSONObject jSONObjectZza = zzfmvVarZza.zza(null);
                View viewZza = zzfntVar.zzk.zza(str);
                zzfmv zzfmvVarZzb = zzfntVar.zzj.zzb();
                String strZzc = zzfntVar.zzk.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfmvVarZzb.zza(viewZza);
                    zzfnf.zzb(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzfng.zza("Error with setting not visible reason", e);
                    }
                    zzfnf.zzc(jSONObjectZza, jSONObjectZza2);
                }
                zzfnf.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfntVar.zzl.zzc(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        if (zzfntVar.zzk.zzf().size() > 0) {
            JSONObject jSONObjectZza3 = zzfmvVarZza.zza(null);
            zzfntVar2 = zzfntVar;
            zzfntVar2.zzk(null, zzfmvVarZza, jSONObjectZza3, 1, false);
            zzfnf.zzf(jSONObjectZza3);
            zzfntVar2.zzl.zzd(jSONObjectZza3, zzfntVar2.zzk.zzf(), jNanoTime);
        } else {
            zzfntVar2 = zzfntVar;
            zzfntVar2.zzl.zzb();
        }
        zzfntVar2.zzk.zzg();
        long jNanoTime2 = System.nanoTime() - zzfntVar2.zzm;
        if (zzfntVar2.zzf.size() > 0) {
            for (zzfns zzfnsVar : zzfntVar2.zzf) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfnsVar.zzb();
                if (zzfnsVar instanceof zzfnr) {
                    ((zzfnr) zzfnsVar).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfmv zzfmvVar, JSONObject jSONObject, int i, boolean z) {
        zzfmvVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final void zza(View view, zzfmv zzfmvVar, JSONObject jSONObject, boolean z) {
        int iZzk;
        boolean z2;
        zzfnt zzfntVar;
        View view2;
        zzfmv zzfmvVar2;
        boolean z3;
        if (zzfnk.zza(view) != null || (iZzk = this.zzk.zzk(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfmvVar.zza(view);
        zzfnf.zzc(jSONObject, jSONObjectZza);
        String strZzd = this.zzk.zzd(view);
        if (strZzd != null) {
            zzfnf.zzb(jSONObjectZza, strZzd);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
            } catch (JSONException e) {
                zzfng.zza("Error with setting has window focus", e);
            }
            this.zzk.zzh();
            zzfntVar = this;
        } else {
            zzfnl zzfnlVarZzb = this.zzk.zzb(view);
            if (zzfnlVarZzb != null) {
                zzfmo zzfmoVarZza = zzfnlVarZzb.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzb = zzfnlVarZzb.zzb();
                int size = arrayListZzb.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) arrayListZzb.get(i));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfmoVarZza.zzd());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfmoVarZza.zza());
                    jSONObjectZza.put("friendlyObstructionReason", zzfmoVarZza.zzc());
                } catch (JSONException e2) {
                    zzfng.zza("Error with setting friendly obstruction", e2);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || z2) {
                zzfntVar = this;
                view2 = view;
                zzfmvVar2 = zzfmvVar;
                z3 = true;
            } else {
                zzfntVar = this;
                view2 = view;
                zzfmvVar2 = zzfmvVar;
                z3 = false;
            }
            zzfntVar.zzk(view2, zzfmvVar2, jSONObjectZza, iZzk, z3);
        }
        zzfntVar.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfno(this));
    }
}
