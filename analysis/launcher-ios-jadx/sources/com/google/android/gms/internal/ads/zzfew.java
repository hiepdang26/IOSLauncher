package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import defpackage.hd2;
import defpackage.hs0;
import defpackage.n42;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfew {
    public final List zza;
    public final zzfeo zzb;
    public final List zzc;
    public final zzbvb zzd;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    public zzfew(JsonReader jsonReader, zzbvb zzbvbVar) throws JSONException, IOException {
        Bundle bundle;
        this.zzd = zzbvbVar;
        if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue() && zzbvbVar != null && (bundle = zzbvbVar.zzm) != null) {
            String strZza = zzdrt.SERVER_RESPONSE_PARSE_START.zza();
            hd2.B.j.getClass();
            bundle.putLong(strZza, System.currentTimeMillis());
        }
        ?? arrayList = Collections.EMPTY_LIST;
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        zzfeo zzfeoVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("responses".equals(strNextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(strNextName2)) {
                        arrayList = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add(new zzfel(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (strNextName2.equals("common")) {
                        zzfeoVar = new zzfeo(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (strNextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String strNextString = null;
                    JSONObject jSONObjectY = null;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        if ("name".equals(strNextName3)) {
                            strNextString = jsonReader.nextString();
                        } else if ("info".equals(strNextName3)) {
                            jSONObjectY = hs0.y(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (strNextString != null) {
                        arrayList2.add(new zzfev(strNextString, jSONObjectY));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzc = arrayList2;
        this.zza = arrayList;
        this.zzb = zzfeoVar == null ? new zzfeo(new JsonReader(new StringReader("{}"))) : zzfeoVar;
    }

    public static zzfew zza(Reader reader, zzbvb zzbvbVar) {
        try {
            try {
                return new zzfew(new JsonReader(reader), zzbvbVar);
            } finally {
                hs0.h(reader);
            }
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzfep("unable to parse ServerResponse", e);
        }
    }
}
