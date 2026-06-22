package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzaph;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbku;
import com.google.android.gms.internal.ads.zzfqt;
import com.google.android.gms.internal.ads.zzfqu;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class z32 extends zzapw {
    public final Context a;

    public z32(Context context, zzaqi zzaqiVar) {
        super(zzaqiVar);
        this.a = context;
    }

    public static zzapk a(Context context) {
        zzapk zzapkVar = new zzapk(new zzaqd(new File(zzfqu.zza(zzfqt.zza(), context.getCacheDir(), "admob_volley")), 20971520), new z32(context, new zzaqi(null, null)), 4);
        zzapkVar.zzd();
        return zzapkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapw, com.google.android.gms.internal.ads.zzapa
    public final zzapd zza(zzaph zzaphVar) throws zzapq {
        if (zzaphVar.zza() == 0) {
            if (Pattern.matches((String) n42.d.c.zza(zzbbw.zzdX), zzaphVar.zzk())) {
                ka2 ka2Var = x32.f.a;
                ea0 ea0Var = ea0.b;
                Context context = this.a;
                if (ea0Var.c(context, 13400000) == 0) {
                    zzapd zzapdVarZza = new zzbku(context).zza(zzaphVar);
                    if (zzapdVarZza != null) {
                        k92.a("Got gmscore asset response: ".concat(String.valueOf(zzaphVar.zzk())));
                        return zzapdVarZza;
                    }
                    k92.a("Failed to get gmscore asset response: ".concat(String.valueOf(zzaphVar.zzk())));
                }
            }
        }
        return super.zza(zzaphVar);
    }
}
