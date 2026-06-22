package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzfyh {
    public static ArrayList zza(int i) {
        zzfwo.zza(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static List zzb(List list, zzful zzfulVar) {
        return list instanceof RandomAccess ? new zzfye(list, zzfulVar) : new zzfyg(list, zzfulVar);
    }
}
