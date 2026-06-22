package defpackage;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.room.MultiInstanceInvalidationService;

/* JADX INFO: loaded from: classes.dex */
public final class zu0 extends RemoteCallbackList {
    public final /* synthetic */ MultiInstanceInvalidationService a;

    public zu0(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.a = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface, Object obj) {
        qg0.l((yd0) iInterface, "callback");
        qg0.l(obj, "cookie");
        this.a.h.remove((Integer) obj);
    }
}
