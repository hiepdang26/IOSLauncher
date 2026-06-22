package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmk extends zzfmn {
    private static final zzfmk zzb = new zzfmk();

    private zzfmk() {
    }

    public static zzfmk zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final void zzb(boolean z) {
        Iterator it = zzfml.zza().zzc().iterator();
        while (it.hasNext()) {
            ((zzflu) it.next()).zzg().zzk(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final boolean zzc() {
        Iterator it = zzfml.zza().zzb().iterator();
        while (it.hasNext()) {
            View viewZzf = ((zzflu) it.next()).zzf();
            if (viewZzf != null && viewZzf.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
