package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: loaded from: classes.dex */
public interface bn0 {
    void b(String str, LifecycleCallback lifecycleCallback);

    LifecycleCallback c(Class cls, String str);

    Activity d();

    void startActivityForResult(Intent intent, int i);
}
