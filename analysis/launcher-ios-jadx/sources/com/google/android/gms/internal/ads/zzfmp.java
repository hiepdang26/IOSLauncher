package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmp {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, zzflx zzflxVar, String str) {
        zzfmo zzfmoVar;
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (!zza.matcher("Ad overlay").matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
        Iterator it = this.zzb.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzfmoVar = null;
                break;
            } else {
                zzfmoVar = (zzfmo) it.next();
                if (zzfmoVar.zzb().get() == view) {
                    break;
                }
            }
        }
        if (zzfmoVar == null) {
            this.zzb.add(new zzfmo(view, zzflxVar, "Ad overlay"));
        }
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
