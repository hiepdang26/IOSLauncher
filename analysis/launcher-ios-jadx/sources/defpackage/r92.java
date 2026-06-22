package defpackage;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class r92 {
    public static volatile r92 i;
    public final String a;
    public final us b;
    public final ExecutorService c;
    public final x6 d;
    public int e;
    public boolean f;
    public final String g;
    public volatile v62 h;

    /* JADX WARN: Removed duplicated region for block: B:40:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r92(android.content.Context r12, java.lang.String r13, android.os.Bundle r14) {
        /*
            r11 = this;
            r0 = 1
            r11.<init>()
            java.lang.String r1 = "com.google.firebase.analytics.FirebaseAnalytics"
            if (r13 == 0) goto L11
            java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> Lc
            goto L11
        Lc:
            java.lang.String r2 = "FA-Ads"
            r11.a = r2
            goto L15
        L11:
            java.lang.String r2 = "FA"
            r11.a = r2
        L15:
            us r2 = defpackage.us.a
            r11.b = r2
            du r10 = new du
            r10.<init>(r0)
            java.util.concurrent.ThreadPoolExecutor r3 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r9 = new java.util.concurrent.LinkedBlockingQueue
            r9.<init>()
            r6 = 60
            r4 = 1
            r5 = 1
            r3.<init>(r4, r5, r6, r8, r9, r10)
            r3.allowCoreThreadTimeOut(r0)
            java.util.concurrent.ExecutorService r2 = java.util.concurrent.Executors.unconfigurableExecutorService(r3)
            r11.c = r2
            x6 r2 = new x6
            r2.<init>(r11)
            r11.d = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r2 = defpackage.az1.M(r12)     // Catch: java.lang.IllegalStateException -> L67
            android.content.res.Resources r3 = r12.getResources()     // Catch: java.lang.IllegalStateException -> L67
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.IllegalStateException -> L67
            if (r4 != 0) goto L52
            goto L56
        L52:
            java.lang.String r2 = defpackage.az1.M(r12)     // Catch: java.lang.IllegalStateException -> L67
        L56:
            java.lang.String r4 = "string"
            java.lang.String r5 = "google_app_id"
            int r2 = r3.getIdentifier(r5, r4, r2)     // Catch: java.lang.IllegalStateException -> L67
            r4 = 0
            if (r2 != 0) goto L62
            goto L6a
        L62:
            java.lang.String r2 = r3.getString(r2)     // Catch: java.lang.IllegalStateException -> L67 android.content.res.Resources.NotFoundException -> L69
            goto L6b
        L67:
            goto L76
        L69:
        L6a:
            r2 = r4
        L6b:
            if (r2 == 0) goto L76
            java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L71
            goto L76
        L71:
            r11.g = r4
            r11.f = r0
            return
        L76:
            if (r13 == 0) goto L81
            java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L7c
            goto L81
        L7c:
            java.lang.String r0 = "am"
            r11.g = r0
            goto L85
        L81:
            java.lang.String r0 = "fa"
            r11.g = r0
        L85:
            m72 r1 = new m72
            r6 = 2
            r2 = r11
            r4 = r12
            r3 = r13
            r5 = r14
            r1.<init>(r2, r3, r4, r5, r6)
            r11.b(r1)
            android.content.Context r12 = r4.getApplicationContext()
            android.app.Application r12 = (android.app.Application) r12
            if (r12 != 0) goto L9b
            return
        L9b:
            q92 r13 = new q92
            r13.<init>(r11)
            r12.registerActivityLifecycleCallbacks(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r92.<init>(android.content.Context, java.lang.String, android.os.Bundle):void");
    }

    public final void a(Exception exc, boolean z, boolean z2) {
        this.f |= z;
        if (!z && z2) {
            b(new i72(this, exc));
        }
    }

    public final void b(z82 z82Var) {
        this.c.execute(z82Var);
    }
}
