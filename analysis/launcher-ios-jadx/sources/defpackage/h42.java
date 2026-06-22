package defpackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzbxl;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h42 {
    public final Context a;
    public boolean b;
    public final zzbxl c;
    public final zzbue d = new zzbue(false, Collections.EMPTY_LIST);

    public h42(Context context, zzbxl zzbxlVar) {
        this.a = context;
        this.c = zzbxlVar;
    }

    public final void a(String str) {
        List<String> list;
        zzbue zzbueVar = this.d;
        zzbxl zzbxlVar = this.c;
        if ((zzbxlVar == null || !zzbxlVar.zza().zzf) && !zzbueVar.zza) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (zzbxlVar != null) {
            zzbxlVar.zzd(str, null, 3);
            return;
        }
        if (!zzbueVar.zza || (list = zzbueVar.zzb) == null) {
            return;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                cd2 cd2Var = hd2.B.c;
                cd2.j(this.a, "", strReplace);
            }
        }
    }

    public final boolean b() {
        zzbxl zzbxlVar = this.c;
        return ((zzbxlVar == null || !zzbxlVar.zza().zzf) && !this.d.zza) || this.b;
    }
}
