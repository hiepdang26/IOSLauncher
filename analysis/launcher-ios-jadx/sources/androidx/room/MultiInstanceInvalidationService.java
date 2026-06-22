package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.qg0;
import defpackage.yu0;
import defpackage.zu0;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {
    public int g;
    public final LinkedHashMap h = new LinkedHashMap();
    public final zu0 i = new zu0(this);
    public final yu0 j = new yu0(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        qg0.l(intent, "intent");
        return this.j;
    }
}
