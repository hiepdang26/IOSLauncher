package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzzm implements zzcm {
    public static final /* synthetic */ int zza = 0;

    static {
        zzfvo.zza(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzzk
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                int i = zzzm.zza;
                try {
                    Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    Object objInvoke = cls.getMethod("build", null).invoke(cls.getConstructor(null).newInstance(null), null);
                    if (objInvoke != null) {
                        return (zzcm) objInvoke;
                    }
                    throw null;
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        });
    }

    private zzzm() {
        throw null;
    }

    public /* synthetic */ zzzm(zzzl zzzlVar) {
    }
}
