package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzaza {
    private final int zza;
    private final zzayx zzb = new zzazc();

    public zzaza(int i) {
        this.zza = i;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(((String) arrayList.get(i)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] strArrSplit = sb.toString().split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zzayz zzayzVar = new zzayz();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzayy(this));
        for (String str : strArrSplit) {
            String[] strArrZzb = zzazb.zzb(str, false);
            if (strArrZzb.length != 0) {
                zzazf.zzc(strArrZzb, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzayzVar.zzb.write(this.zzb.zzb(((zzaze) it.next()).zzb));
            } catch (IOException unused) {
                k92.f();
            }
        }
        return zzayzVar.toString();
    }
}
