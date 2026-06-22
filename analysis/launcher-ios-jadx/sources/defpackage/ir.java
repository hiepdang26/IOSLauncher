package defpackage;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class ir implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ Bundle i;
    public final /* synthetic */ kr j;

    public /* synthetic */ ir(kr krVar, String str, Bundle bundle, int i) {
        this.g = i;
        this.j = krVar;
        this.h = str;
        this.i = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                kr krVar = this.j;
                krVar.h.extraCallback(this.h, this.i);
                break;
            default:
                kr krVar2 = this.j;
                krVar2.h.onPostMessage(this.h, this.i);
                break;
        }
    }
}
