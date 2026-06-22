package defpackage;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class lh1 {
    public static final Bitmap.Config[] d;
    public static final Bitmap.Config[] e;
    public static final Bitmap.Config[] f;
    public static final Bitmap.Config[] g;
    public static final Bitmap.Config[] h;
    public final bq0 a = new bq0(1);
    public final oz1 b = new oz1(4);
    public final HashMap c = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        d = configArr;
        e = configArr;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapD.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapD.remove(num);
                return;
            } else {
                navigableMapD.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(vq1.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int i3 = 0;
        int iD = vq1.d(config) * i * i2;
        bq0 bq0Var = this.a;
        g21 g21VarD = (g21) ((ArrayDeque) bq0Var.g).poll();
        if (g21VarD == null) {
            g21VarD = bq0Var.d();
        }
        kh1 kh1Var = (kh1) g21VarD;
        kh1Var.b = iD;
        kh1Var.c = config;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i4 = jh1.a[config.ordinal()];
            configArr = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? new Bitmap.Config[]{config} : h : g : f : d;
        } else {
            configArr = e;
        }
        int length = configArr.length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i3];
            Integer num = (Integer) d(config2).ceilingKey(Integer.valueOf(iD));
            if (num == null || num.intValue() > iD * 8) {
                i3++;
            } else if (num.intValue() != iD || (config2 != null ? !config2.equals(config) : config != null)) {
                bq0Var.c(kh1Var);
                int iIntValue = num.intValue();
                g21 g21VarD2 = (g21) ((ArrayDeque) bq0Var.g).poll();
                if (g21VarD2 == null) {
                    g21VarD2 = bq0Var.d();
                }
                kh1Var = (kh1) g21VarD2;
                kh1Var.b = iIntValue;
                kh1Var.c = config2;
            }
        }
        Bitmap bitmap = (Bitmap) this.b.d(kh1Var);
        if (bitmap != null) {
            a(Integer.valueOf(kh1Var.b), bitmap);
            bitmap.reconfigure(i, i2, config);
        }
        return bitmap;
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap map = this.c;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final void e(Bitmap bitmap) {
        int iC = vq1.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        bq0 bq0Var = this.a;
        g21 g21VarD = (g21) ((ArrayDeque) bq0Var.g).poll();
        if (g21VarD == null) {
            g21VarD = bq0Var.d();
        }
        kh1 kh1Var = (kh1) g21VarD;
        kh1Var.b = iC;
        kh1Var.c = config;
        this.b.h(kh1Var, bitmap);
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num = (Integer) navigableMapD.get(Integer.valueOf(kh1Var.b));
        navigableMapD.put(Integer.valueOf(kh1Var.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sbM = uo.m("SizeConfigStrategy{groupedMap=");
        sbM.append(this.b);
        sbM.append(", sortedSizes=(");
        HashMap map = this.c;
        for (Map.Entry entry : map.entrySet()) {
            sbM.append(entry.getKey());
            sbM.append('[');
            sbM.append(entry.getValue());
            sbM.append("], ");
        }
        if (!map.isEmpty()) {
            sbM.replace(sbM.length() - 2, sbM.length(), "");
        }
        sbM.append(")}");
        return sbM.toString();
    }
}
