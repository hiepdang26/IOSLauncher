package defpackage;

import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class tj0 implements Runnable {
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ t k;

    public tj0(t tVar, ArrayList arrayList, int i, int i2, boolean z) {
        this.k = tVar;
        this.g = arrayList;
        this.h = i;
        this.i = i2;
        this.j = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.bindItems(this.g, this.h, this.i, this.j);
    }
}
