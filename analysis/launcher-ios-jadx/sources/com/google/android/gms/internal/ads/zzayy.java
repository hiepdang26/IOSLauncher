package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzayy implements Comparator {
    public zzayy(zzaza zzazaVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzaze zzazeVar = (zzaze) obj;
        zzaze zzazeVar2 = (zzaze) obj2;
        int i = zzazeVar.zzc - zzazeVar2.zzc;
        return i != 0 ? i : Long.compare(zzazeVar.zza, zzazeVar2.zza);
    }
}
