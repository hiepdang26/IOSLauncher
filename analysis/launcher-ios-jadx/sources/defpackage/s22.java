package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.JsonReader;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzdyq;
import com.google.android.gms.internal.ads.zzful;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgcj;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s22 implements zzgbq {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ s22(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgbq
    public final do0 zza(Object obj) {
        switch (this.a) {
            case 0:
                final ArrayList arrayList = (ArrayList) obj;
                final y22 y22Var = (y22) this.b;
                return zzgcj.zzm(y22Var.p("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzful() { // from class: gd2
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj2) {
                        String str = (String) obj2;
                        y22 y22Var2 = y22Var;
                        y22Var2.getClass();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = arrayList;
                        int size = arrayList3.size();
                        int i = 0;
                        while (i < size) {
                            Object obj3 = arrayList3.get(i);
                            i++;
                            Uri uri = (Uri) obj3;
                            if (!y22.u(uri, y22Var2.E, y22Var2.F) || TextUtils.isEmpty(str)) {
                                arrayList2.add(uri);
                            } else {
                                arrayList2.add(y22.v(uri, "nas", str));
                            }
                        }
                        return arrayList2;
                    }
                }, y22Var.l);
            case 1:
                final Uri uri = (Uri) obj;
                y22 y22Var2 = (y22) this.b;
                return zzgcj.zzm(y22Var2.p("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzful() { // from class: ud2
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj2) {
                        String str = (String) obj2;
                        boolean zIsEmpty = TextUtils.isEmpty(str);
                        Uri uri2 = uri;
                        return !zIsEmpty ? y22.v(uri2, "nas", str) : uri2;
                    }
                }, y22Var2.l);
            default:
                zzdyq zzdyqVar = (zzdyq) obj;
                v32 v32Var = new v32(new JsonReader(new InputStreamReader(zzdyqVar.zzb())), zzdyqVar.zza());
                try {
                    v32Var.b = x32.f.a.g(((zzbvb) this.b).zza).toString();
                    break;
                } catch (JSONException unused) {
                    v32Var.b = "{}";
                }
                return zzgcj.zzh(v32Var);
        }
    }
}
