package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzhez {
    public static HashSet zza(int i) {
        return new HashSet(zzd(i));
    }

    public static LinkedHashMap zzb(int i) {
        return new LinkedHashMap(zzd(i));
    }

    public static List zzc(int i) {
        return i == 0 ? Collections.EMPTY_LIST : new ArrayList(i);
    }

    private static int zzd(int i) {
        return i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }
}
