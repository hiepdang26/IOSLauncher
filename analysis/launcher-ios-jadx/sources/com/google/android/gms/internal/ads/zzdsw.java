package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import defpackage.k92;
import defpackage.nj;
import defpackage.us;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsw {
    private final nj zza;

    public zzdsw(nj njVar) {
        this.zza = njVar;
    }

    public final void zza(List list, String str, String str2, Object... objArr) {
        if (((Boolean) zzbdu.zza.zze()).booleanValue()) {
            ((us) this.zza).getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(jCurrentTimeMillis);
                jsonWriter.name("source").value(str);
                jsonWriter.name("event").value(str2);
                jsonWriter.name("components").beginArray();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonWriter.value(it.next().toString());
                }
                jsonWriter.endArray();
                jsonWriter.name("params").beginArray();
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    Object obj = objArr[i];
                    jsonWriter.value(obj != null ? obj.toString() : null);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException unused) {
                k92.f();
            }
            k92.g("AD-DBG ".concat(String.valueOf(stringWriter.toString())));
        }
    }
}
