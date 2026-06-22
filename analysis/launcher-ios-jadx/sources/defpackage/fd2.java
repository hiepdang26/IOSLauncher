package defpackage;

import android.os.Process;
import android.webkit.CookieManager;

/* JADX INFO: loaded from: classes.dex */
public class fd2 extends i22 {
    public final CookieManager i() {
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        int iMyUid = Process.myUid();
        if (iMyUid == 0 || iMyUid == 1000) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            k92.f();
            hd2Var.g.zzv(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }
}
