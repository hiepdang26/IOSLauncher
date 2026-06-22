package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e82 extends w50 implements bn0 {
    public static final WeakHashMap c0 = new WeakHashMap();
    public final Map Z = Collections.synchronizedMap(new e9(0));
    public int a0 = 0;
    public Bundle b0;

    @Override // defpackage.w50
    public final void A() {
        this.J = true;
        this.a0 = 5;
        Iterator it = this.Z.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).getClass();
        }
    }

    @Override // defpackage.w50
    public final void F() {
        this.J = true;
        this.a0 = 3;
        Iterator it = this.Z.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e();
        }
    }

    @Override // defpackage.w50
    public final void G(Bundle bundle) {
        for (Map.Entry entry : this.Z.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).f(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // defpackage.w50
    public final void H() {
        this.J = true;
        this.a0 = 2;
        Iterator it = this.Z.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // defpackage.w50
    public final void I() {
        this.J = true;
        this.a0 = 4;
        Iterator it = this.Z.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // defpackage.bn0
    public final void b(String str, LifecycleCallback lifecycleCallback) {
        Map map = this.Z;
        if (map.containsKey(str)) {
            throw new IllegalArgumentException(uo.t("LifecycleCallback with tag ", str, " already added to this fragment."));
        }
        map.put(str, lifecycleCallback);
        if (this.a0 > 0) {
            new t12(Looper.getMainLooper()).post(new xm(this, lifecycleCallback, str, 16, false));
        }
    }

    @Override // defpackage.bn0
    public final LifecycleCallback c(Class cls, String str) {
        return (LifecycleCallback) cls.cast(this.Z.get(str));
    }

    @Override // defpackage.w50
    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.f(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.Z.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).getClass();
        }
    }

    @Override // defpackage.w50
    public final void w(int i, int i2, Intent intent) {
        super.w(i, i2, intent);
        Iterator it = this.Z.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).c(i, i2, intent);
        }
    }

    @Override // defpackage.w50
    public final void y(Bundle bundle) {
        super.y(bundle);
        this.a0 = 1;
        this.b0 = bundle;
        for (Map.Entry entry : this.Z.entrySet()) {
            ((LifecycleCallback) entry.getValue()).d(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }
}
