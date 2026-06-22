package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.ib2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesa implements zzevo {
    private final zzgcu zza;

    public zzesa(Context context, zzgcu zzgcuVar) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 19;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzerz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String strY;
                String strZ;
                String strZze;
                hd2 hd2Var = hd2.B;
                cd2 cd2Var = hd2Var.c;
                zzayv zzayvVarW = ((ib2) hd2Var.g.zzi()).w();
                Bundle bundle = null;
                if (zzayvVarW != null && (!((ib2) hd2Var.g.zzi()).n() || !((ib2) hd2Var.g.zzi()).o())) {
                    if (zzayvVarW.zzh()) {
                        zzayvVarW.zzg();
                    }
                    zzayl zzaylVarZza = zzayvVarW.zza();
                    if (zzaylVarZza != null) {
                        strY = zzaylVarZza.zzd();
                        strZze = zzaylVarZza.zze();
                        strZ = zzaylVarZza.zzf();
                        if (strY != null) {
                            ib2 ib2Var = (ib2) hd2Var.g.zzi();
                            ib2Var.r();
                            synchronized (ib2Var.a) {
                                try {
                                    if (!strY.equals(ib2Var.i)) {
                                        ib2Var.i = strY;
                                        SharedPreferences.Editor editor = ib2Var.g;
                                        if (editor != null) {
                                            editor.putString("content_url_hashes", strY);
                                            ib2Var.g.apply();
                                        }
                                        ib2Var.s();
                                    }
                                } finally {
                                }
                            }
                        }
                        if (strZ != null) {
                            ((ib2) hd2Var.g.zzi()).G(strZ);
                        }
                    } else {
                        strY = ((ib2) hd2Var.g.zzi()).y();
                        strZ = ((ib2) hd2Var.g.zzi()).z();
                        strZze = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!((ib2) hd2Var.g.zzi()).o()) {
                        if (strZ == null || TextUtils.isEmpty(strZ)) {
                            bundle2.putString("v_fp_vertical", "no_hash");
                        } else {
                            bundle2.putString("v_fp_vertical", strZ);
                        }
                    }
                    if (strY != null && !((ib2) hd2Var.g.zzi()).n()) {
                        bundle2.putString("fingerprint", strY);
                        if (!strY.equals(strZze)) {
                            bundle2.putString("v_fp", strZze);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzesb(bundle);
            }
        });
    }
}
