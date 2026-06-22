package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import defpackage.hs0;
import defpackage.n42;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfeo {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final long zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzfen zzj;
    public final Bundle zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;
    public final JSONObject zzo;
    public final JSONObject zzp;
    public final String zzq;
    public final int zzr;

    public zzfeo(JsonReader jsonReader) throws JSONException, IOException {
        List listV = Collections.EMPTY_LIST;
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jsonReader.beginObject();
        String strNextString = "";
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        String strNextString6 = strNextString5;
        zzfen zzfenVar = null;
        int iNextInt = 0;
        int iNextInt2 = 0;
        boolean zNextBoolean = false;
        long jNextLong = 0;
        int iNextInt3 = -1;
        int iMax = 1;
        String strNextString7 = strNextString6;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (Objects.equals(strNextName, "nofill_urls")) {
                listV = hs0.v(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if (Objects.equals(strNextName, "refresh_load_delay_time_interval")) {
                iNextInt3 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString2 = jsonReader.nextString();
            } else if ("is_idless".equals(strNextName)) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if ("response_code".equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if ("latency".equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                zzbbn zzbbnVar = zzbbw.zzhw;
                String str = strNextString6;
                n42 n42Var = n42.d;
                JSONObject jSONObject3 = jSONObject2;
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && "public_error".equals(strNextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzfenVar = new zzfen(jsonReader);
                } else if ("bidding_data".equals(strNextName)) {
                    strNextString7 = jsonReader.nextString();
                } else {
                    zzbbn zzbbnVar2 = zzbbw.zzjz;
                    zzbbu zzbbuVar = n42Var.c;
                    if (((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue() && Objects.equals(strNextName, "topics_should_record_observation")) {
                        jsonReader.nextBoolean();
                    } else if ("adapter_response_replacement_key".equals(strNextName)) {
                        strNextString6 = jsonReader.nextString();
                        jSONObject2 = jSONObject3;
                    } else if ("response_info_extras".equals(strNextName)) {
                        if (((Boolean) zzbbuVar.zza(zzbbw.zzgf)).booleanValue()) {
                            try {
                                Bundle bundleT = hs0.t(hs0.y(jsonReader));
                                if (bundleT != null) {
                                    bundle = bundleT;
                                }
                            } catch (IOException | JSONException unused) {
                                strNextString6 = str;
                                jSONObject2 = jSONObject3;
                            } catch (IllegalStateException unused2) {
                                jsonReader.skipValue();
                                strNextString6 = str;
                                jSONObject2 = jSONObject3;
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestPostBody".equals(strNextName)) {
                        if (((Boolean) zzbbuVar.zza(zzbbw.zzit)).booleanValue()) {
                            strNextString4 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (!"adRequestUrl".equals(strNextName)) {
                        zzbbn zzbbnVar3 = zzbbw.zziu;
                        if (((Boolean) zzbbuVar.zza(zzbbnVar3)).booleanValue() && Objects.equals(strNextName, "adResponseBody")) {
                            strNextString5 = jsonReader.nextString();
                        } else if (((Boolean) zzbbuVar.zza(zzbbnVar3)).booleanValue() && Objects.equals(strNextName, "adResponseHeaders")) {
                            jSONObject = hs0.y(jsonReader);
                        } else {
                            if (Objects.equals(strNextName, "max_parallel_renderers")) {
                                iMax = Math.max(1, jsonReader.nextInt());
                            } else if (((Boolean) zzbbuVar.zza(zzbbw.zziB)).booleanValue() && Objects.equals(strNextName, "inspector_ad_transaction_extras")) {
                                jSONObject2 = hs0.y(jsonReader);
                                strNextString6 = str;
                            } else {
                                jsonReader.skipValue();
                            }
                            strNextString6 = str;
                            jSONObject2 = jSONObject3;
                        }
                    } else if (((Boolean) zzbbuVar.zza(zzbbw.zzit)).booleanValue()) {
                        strNextString3 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    strNextString6 = str;
                    jSONObject2 = jSONObject3;
                }
                strNextString6 = str;
                jSONObject2 = jSONObject3;
            }
        }
        JSONObject jSONObject4 = jSONObject2;
        String str2 = strNextString6;
        jsonReader.endObject();
        this.zza = listV;
        this.zzc = iNextInt;
        if (((Boolean) zzbdy.zzd.zze()).booleanValue()) {
            this.zzd = -1;
        } else {
            zzbdc zzbdcVar = zzbdg.zza;
            if (((Long) zzbdcVar.zze()).longValue() > -1) {
                this.zzd = ((Long) zzbdcVar.zze()).intValue();
            } else {
                this.zzd = iNextInt3;
            }
        }
        this.zzb = strNextString;
        this.zze = strNextString2;
        this.zzf = iNextInt2;
        this.zzg = jNextLong;
        this.zzj = zzfenVar;
        this.zzh = zNextBoolean;
        this.zzi = strNextString7;
        this.zzk = bundle;
        this.zzl = strNextString3;
        this.zzm = strNextString4;
        this.zzn = strNextString5;
        this.zzo = jSONObject;
        this.zzp = jSONObject4;
        this.zzq = str2;
        zzbdc zzbdcVar2 = zzbdw.zza;
        this.zzr = ((Long) zzbdcVar2.zze()).longValue() > 0 ? ((Long) zzbdcVar2.zze()).intValue() : iMax;
    }
}
