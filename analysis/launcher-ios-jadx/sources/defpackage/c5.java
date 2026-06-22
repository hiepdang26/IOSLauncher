package defpackage;

import android.graphics.drawable.Animatable;

/* JADX INFO: loaded from: classes.dex */
public final class c5 extends wd {
    public final /* synthetic */ int B;
    public final Animatable C;

    public /* synthetic */ c5(Animatable animatable, int i) {
        this.B = i;
        this.C = animatable;
    }

    @Override // defpackage.wd
    public final void I() {
        switch (this.B) {
            case 0:
                this.C.start();
                break;
            default:
                ((k5) this.C).start();
                break;
        }
    }

    @Override // defpackage.wd
    public final void J() {
        switch (this.B) {
            case 0:
                this.C.stop();
                break;
            default:
                ((k5) this.C).stop();
                break;
        }
    }
}
