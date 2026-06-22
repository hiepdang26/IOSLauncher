package defpackage;

import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class uj0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ t i;

    public /* synthetic */ uj0(t tVar, ArrayList arrayList, int i) {
        this.g = i;
        this.i = tVar;
        this.h = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.i.bindAppsUpdated(this.h);
                break;
            case 1:
                this.i.bindWidgetsRestored(this.h);
                break;
            default:
                this.i.bindAppInfosRemoved(this.h);
                break;
        }
    }
}
