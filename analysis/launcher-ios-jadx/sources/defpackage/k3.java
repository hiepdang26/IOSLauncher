package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class k3 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ View h;
    public final /* synthetic */ View i;
    public final /* synthetic */ s3 j;

    public /* synthetic */ k3(s3 s3Var, View view, View view2, int i) {
        this.g = i;
        this.j = s3Var;
        this.h = view;
        this.i = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                s3.b(this.j.r, this.h, this.i);
                break;
            default:
                s3.b(this.j.f, this.h, this.i);
                break;
        }
    }
}
