package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbib implements zzbix {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        WindowManager windowManager = (WindowManager) zzcejVar.getContext().getSystemService("window");
        cd2 cd2Var = hd2.B.c;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int[] iArr = new int[2];
        HashMap map2 = new HashMap();
        ((View) zzcejVar).getLocationInWindow(iArr);
        map2.put("xInPixels", Integer.valueOf(iArr[0]));
        map2.put("yInPixels", Integer.valueOf(iArr[1]));
        map2.put("windowWidthInPixels", Integer.valueOf(i));
        map2.put("windowHeightInPixels", Integer.valueOf(i2));
        zzcejVar.zzd("locationReady", map2);
        k92.h("GET LOCATION COMPILED");
    }
}
