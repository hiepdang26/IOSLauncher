package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpp {
    private Context zza;
    private PopupWindow zzb;

    public final void zza(Context context, View view) {
    }

    public final void zzb() {
        Context context = this.zza;
        if (context == null || this.zzb == null) {
            return;
        }
        if ((!(context instanceof Activity) || !((Activity) context).isDestroyed()) && this.zzb.isShowing()) {
            this.zzb.dismiss();
        }
        this.zza = null;
        this.zzb = null;
    }
}
