package defpackage;

import android.app.Activity;
import android.app.Fragment;
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
public final class b42 extends Fragment implements bn0 {
    public static final WeakHashMap j = new WeakHashMap();
    public final Map g = Collections.synchronizedMap(new e9(0));
    public int h = 0;
    public Bundle i;

    @Override // defpackage.bn0
    public final void b(String str, LifecycleCallback lifecycleCallback) {
        Map map = this.g;
        if (map.containsKey(str)) {
            throw new IllegalArgumentException(uo.t("LifecycleCallback with tag ", str, " already added to this fragment."));
        }
        map.put(str, lifecycleCallback);
        if (this.h > 0) {
            new t12(Looper.getMainLooper()).post(new xm(this, lifecycleCallback, str, 14, false));
        }
    }

    @Override // defpackage.bn0
    public final LifecycleCallback c(Class cls, String str) {
        return (LifecycleCallback) cls.cast(this.g.get(str));
    }

    @Override // defpackage.bn0
    public final Activity d() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).getClass();
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).c(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = 1;
        this.i = bundle;
        for (Map.Entry entry : this.g.entrySet()) {
            ((LifecycleCallback) entry.getValue()).d(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.h = 5;
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).getClass();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.h = 3;
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.g.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).f(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.h = 2;
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.h = 4;
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }
}
