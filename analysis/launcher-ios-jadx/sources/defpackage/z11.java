package defpackage;

import com.luutinhit.launcher6.leftpage.widgets.PhotoWidget_2x2;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z11 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ q11 h;

    public /* synthetic */ z11(q11 q11Var, int i) {
        this.g = i;
        this.h = q11Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                cw cwVar = ((PhotoWidget_2x2) this.h.i).n;
                if (cwVar != null) {
                    cwVar.b();
                }
                break;
            case 1:
                cw cwVar2 = ((PhotoWidget_2x2) this.h.i).n;
                if (cwVar2 != null) {
                    cwVar2.b();
                }
                break;
            case 2:
                cw cwVar3 = ((PhotoWidget_2x2) this.h.i).n;
                if (cwVar3 != null) {
                    cwVar3.b();
                }
                break;
            default:
                cw cwVar4 = ((PhotoWidget_2x2) this.h.i).n;
                if (cwVar4 != null) {
                    cwVar4.b();
                }
                break;
        }
    }
}
