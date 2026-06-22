package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class zzaqi extends zzapv {
    public zzaqi() {
        throw null;
    }

    public static List zza(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzaoz((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public zzaqi(zzaqh zzaqhVar, SSLSocketFactory sSLSocketFactory) {
    }
}
