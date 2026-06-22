package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import defpackage.hs0;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzebl {
    public int zza = 0;
    public Map zzb = new HashMap();
    public String zzc = "";
    public long zzd = -1;

    public static zzebl zza(Reader reader) {
        try {
            try {
                JsonReader jsonReader = new JsonReader(reader);
                HashMap map = new HashMap();
                String strNextString = "";
                jsonReader.beginObject();
                long jNextLong = -1;
                int iNextInt = 0;
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    if ("response".equals(strNextName)) {
                        iNextInt = jsonReader.nextInt();
                    } else if ("body".equals(strNextName)) {
                        strNextString = jsonReader.nextString();
                    } else if ("latency".equals(strNextName)) {
                        jNextLong = jsonReader.nextLong();
                    } else if ("headers".equals(strNextName)) {
                        map = new HashMap();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            map.put(jsonReader.nextName(), hs0.v(jsonReader));
                        }
                        jsonReader.endObject();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                zzebl zzeblVar = new zzebl();
                zzeblVar.zza = iNextInt;
                if (strNextString != null) {
                    zzeblVar.zzc = strNextString;
                }
                zzeblVar.zzd = jNextLong;
                zzeblVar.zzb = map;
                hs0.h(reader);
                return zzeblVar;
            } catch (Throwable th) {
                hs0.h(reader);
                throw th;
            }
        } catch (IOException e) {
            e = e;
            throw new zzfep("Unable to parse Response", e);
        } catch (AssertionError e2) {
            e = e2;
            throw new zzfep("Unable to parse Response", e);
        } catch (IllegalStateException e3) {
            e = e3;
            throw new zzfep("Unable to parse Response", e);
        } catch (NumberFormatException e4) {
            e = e4;
            throw new zzfep("Unable to parse Response", e);
        }
    }
}
