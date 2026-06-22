package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class bm {
    public static final Object b = new Object();
    public static volatile bm c;
    public final ConcurrentHashMap a;

    public bm(int i) {
        switch (i) {
            case 1:
                this.a = new ConcurrentHashMap();
                new AtomicInteger(0);
                break;
            default:
                this.a = new ConcurrentHashMap();
                break;
        }
    }

    public static bm a() {
        if (c == null) {
            synchronized (b) {
                try {
                    if (c == null) {
                        c = new bm(0);
                    }
                } finally {
                }
            }
        }
        bm bmVar = c;
        hg0.i(bmVar);
        return bmVar;
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof oc2)) {
            ConcurrentHashMap concurrentHashMap = this.a;
            if (concurrentHashMap.containsKey(serviceConnection)) {
                try {
                    try {
                        context.unbindService((ServiceConnection) concurrentHashMap.get(serviceConnection));
                    } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
                    }
                    return;
                } finally {
                    concurrentHashMap.remove(serviceConnection);
                }
            }
        }
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
        }
    }

    public boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((j02.a(context).e(0, packageName).flags & 2097152) != 0) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (serviceConnection instanceof oc2) {
            if (executor == null) {
                executor = null;
            }
            return (Build.VERSION.SDK_INT < 29 || executor == null) ? context.bindService(intent, serviceConnection, i) : context.bindService(intent, i, executor, serviceConnection);
        }
        ConcurrentHashMap concurrentHashMap = this.a;
        ServiceConnection serviceConnection2 = (ServiceConnection) concurrentHashMap.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction());
        }
        if (executor == null) {
            executor = null;
        }
        try {
            boolean zBindService = (Build.VERSION.SDK_INT < 29 || executor == null) ? context.bindService(intent, serviceConnection, i) : context.bindService(intent, i, executor, serviceConnection);
            if (zBindService) {
                return zBindService;
            }
            return false;
        } finally {
            concurrentHashMap.remove(serviceConnection, serviceConnection);
        }
    }
}
