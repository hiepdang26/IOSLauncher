package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbdz {
    public static final zzbdc zza = zzbdc.zzd("gads:separate_url_generation:enabled", true);
    public static final zzbdc zzb = zzbdc.zzc("gads:google_ad_request_domains", "googleads.g.doubleclick.net;pubads.g.doubleclick.net");
    public static final zzbdc zzc = zzbdc.zzb("gads:url_cache:max_size", 200);

    static {
        zzbdc.zzd("gads:use_request_id_as_url_cache_key:enabled", true);
    }
}
