package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public final class xg0 {
    public final float a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final int h;
    public final int i;
    public final float j;
    public final int k;
    public final int l;
    public final String m;
    public final int n;
    public final float o;
    public final int p;
    public final xu q;
    public final xu r;
    public final float s;
    public final float t;
    public final WindowManager u;
    public final Context v;
    public final boolean w;
    public final boolean x;
    public final int y;
    public final bo1 z;

    public xg0(String str, float f, float f2, int i, int i2, int i3, int i4, int i5, float f3, float f4, int i6, float f5, int i7) {
        this.a = 0.62f;
        boolean z = xl0.b;
        this.b = z;
        this.w = false;
        this.x = false;
        this.y = 0;
        if (!z && i6 % 2 == 0) {
            throw new RuntimeException("All Device Profiles must have an odd number of hotseat spaces");
        }
        this.m = str;
        this.s = f;
        this.t = f2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.n = i5;
        this.g = f3;
        this.j = f4;
        this.k = i6;
        this.o = f5;
        this.p = i7;
    }

    public static boolean a() {
        try {
            return Build.MANUFACTURER.toLowerCase().contains("samsung");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xg0(android.content.Context r51) {
        /*
            Method dump skipped, instruction units count: 1252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xg0.<init>(android.content.Context):void");
    }
}
