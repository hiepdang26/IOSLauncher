package defpackage;

import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class cj0 {
    public final HashMap a = new HashMap();

    public final float a(String str, View view) {
        HashMap map;
        float[] fArr;
        HashMap map2 = this.a;
        if (map2.containsKey(view) && (map = (HashMap) map2.get(view)) != null && map.containsKey(str) && (fArr = (float[]) map.get(str)) != null && fArr.length > 0) {
            return fArr[0];
        }
        return Float.NaN;
    }
}
