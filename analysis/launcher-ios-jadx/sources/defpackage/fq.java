package defpackage;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbdm;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class fq {
    public final String a = (String) zzbdm.zza.zze();

    public final String a(Map map) {
        Uri.Builder builderBuildUpon = Uri.parse(this.a).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }
}
