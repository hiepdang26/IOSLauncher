package com.luutinhit.launcherios.notification;

import android.os.Handler;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import defpackage.ar1;
import defpackage.by0;
import defpackage.h8;
import defpackage.rl0;
import defpackage.tx0;

/* JADX INFO: loaded from: classes.dex */
public class NotificationListener extends NotificationListenerService {
    public static tx0 j;
    public final NotificationListenerService.Ranking g;
    public final Handler h;
    public final Handler i;

    public NotificationListener() {
        h8 h8Var = new h8(this, 3);
        by0 by0Var = new by0(0);
        if (ar1.m) {
            this.g = new NotificationListenerService.Ranking();
        }
        this.h = new Handler(rl0.w.getLooper(), h8Var);
        this.i = new Handler(Looper.getMainLooper(), by0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList a(com.luutinhit.launcherios.notification.NotificationListener r8, android.service.notification.StatusBarNotification[] r9) {
        /*
            if (r9 != 0) goto L4
            r8 = 0
            return r8
        L4:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r1 = 0
            r2 = 0
        Lb:
            int r3 = r9.length
            if (r2 >= r3) goto L8d
            r3 = r9[r2]
            boolean r4 = defpackage.ar1.m
            android.service.notification.NotificationListenerService$Ranking r5 = r8.g
            if (r4 == 0) goto L2c
            android.service.notification.NotificationListenerService$RankingMap r6 = r8.getCurrentRanking()
            java.lang.String r7 = r3.getKey()
            r6.getRanking(r7, r5)
            boolean r6 = defpackage.ar1.d
            if (r6 == 0) goto L2c
            boolean r6 = defpackage.kl0.y(r5)
            if (r6 != 0) goto L2c
            goto L82
        L2c:
            android.app.Notification r3 = r3.getNotification()
            boolean r6 = defpackage.ar1.d
            if (r6 == 0) goto L4b
            android.app.NotificationChannel r5 = defpackage.kl0.b(r5)
            java.lang.String r5 = defpackage.kl0.i(r5)
            java.lang.String r7 = "miscellaneous"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L4b
            int r5 = r3.flags
            r5 = r5 & 2
            if (r5 == 0) goto L54
            goto L82
        L4b:
            if (r6 != 0) goto L54
            int r5 = r3.flags
            r5 = r5 & 2
            if (r5 == 0) goto L54
            goto L82
        L54:
            if (r4 == 0) goto L89
            int r4 = r3.flags
            r4 = r4 & 512(0x200, float:7.17E-43)
            r5 = 1
            if (r4 == 0) goto L5f
            r4 = 1
            goto L60
        L5f:
            r4 = 0
        L60:
            android.os.Bundle r6 = r3.extras
            java.lang.String r7 = "android.title"
            java.lang.CharSequence r6 = r6.getCharSequence(r7)
            android.os.Bundle r3 = r3.extras
            java.lang.String r7 = "android.text"
            java.lang.CharSequence r3 = r3.getCharSequence(r7)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L7d
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L7d
            goto L7e
        L7d:
            r5 = 0
        L7e:
            if (r4 != 0) goto L82
            if (r5 == 0) goto L89
        L82:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.add(r3)
        L89:
            int r2 = r2 + 1
            goto Lb
        L8d:
            java.util.ArrayList r8 = new java.util.ArrayList
            int r2 = r9.length
            int r3 = r0.size()
            int r2 = r2 - r3
            r8.<init>(r2)
        L98:
            int r2 = r9.length
            if (r1 >= r2) goto Lad
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto Laa
            r2 = r9[r1]
            r8.add(r2)
        Laa:
            int r1 = r1 + 1
            goto L98
        Lad:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcherios.notification.NotificationListener.a(com.luutinhit.launcherios.notification.NotificationListener, android.service.notification.StatusBarNotification[]):java.util.ArrayList");
    }

    public final void b() {
        Handler handler = this.h;
        handler.removeCallbacksAndMessages(null);
        handler.sendEmptyMessageDelayed(3, 500L);
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerConnected() {
        b();
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerDisconnected() {
        this.i.obtainMessage(3).sendToTarget();
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationPosted(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            b();
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            b();
        }
    }
}
