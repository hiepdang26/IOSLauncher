package defpackage;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class jr implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Uri h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ Bundle j;
    public final /* synthetic */ kr k;

    public jr(kr krVar, int i, Uri uri, boolean z, Bundle bundle) {
        this.k = krVar;
        this.g = i;
        this.h = uri;
        this.i = z;
        this.j = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        kr krVar = this.k;
        krVar.h.onRelationshipValidationResult(this.g, this.h, this.i, this.j);
    }
}
