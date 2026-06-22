package defpackage;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class iq extends ContentObserver {
    public final /* synthetic */ kq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iq(kq kqVar) {
        super(new Handler());
        this.a = kqVar;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.onContentChanged();
    }
}
