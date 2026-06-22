package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.yb2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbio implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        if (zzcejVar.zzJ() != null) {
            zzcejVar.zzJ().zza();
        }
        yb2 yb2VarZzL = zzcejVar.zzL();
        if (yb2VarZzL != null) {
            yb2VarZzL.zzb();
            return;
        }
        yb2 yb2VarZzM = zzcejVar.zzM();
        if (yb2VarZzM != null) {
            yb2VarZzM.zzb();
        } else {
            k92.h("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
