package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaun extends zzaum {
    public zzaun(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzaun zzt(String str, Context context, boolean z) {
        zzaum.zzr(context, false);
        return new zzaun(context, str, false);
    }

    @Deprecated
    public static zzaun zzu(String str, Context context, boolean z, int i) {
        zzaum.zzr(context, z);
        return new zzaun(context, str, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final List zzp(zzavp zzavpVar, Context context, zzaro zzaroVar, zzarh zzarhVar) {
        if (zzavpVar.zzk() == null || !((zzaum) this).zzu) {
            return super.zzp(zzavpVar, context, zzaroVar, null);
        }
        int iZza = zzavpVar.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzavpVar, context, zzaroVar, null));
        arrayList.add(new zzawh(zzavpVar, "FLgp79R6LGLnWDio6G1XBjsjORgKSjLkdakyn5bigQludVyQtVZMhDAlppvakfKf", "oPDFFWKd1EuWWR8iem/Fb2LK/5grpy+LhaDBlMcgIHs=", zzaroVar, iZza, 24));
        return arrayList;
    }
}
