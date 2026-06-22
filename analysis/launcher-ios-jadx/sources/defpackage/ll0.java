package defpackage;

import android.os.SystemClock;
import com.luutinhit.launcher6.u;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ll0 implements Runnable {
    public final /* synthetic */ int g = 1;
    public final /* synthetic */ hl0 h;
    public final /* synthetic */ u i;

    public ll0(u uVar, hl0 hl0Var) {
        this.i = uVar;
        this.h = hl0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                hl0 hl0VarL = this.i.l(this.h);
                if (hl0VarL != null) {
                    hl0VarL.finishBindingItems();
                }
                this.i.k.getClass();
                int i = 0;
                this.i.h = false;
                ArrayList arrayList = rl0.z;
                if (!arrayList.isEmpty()) {
                    synchronized (arrayList) {
                        try {
                            int size = arrayList.size();
                            while (i < size) {
                                Object obj = arrayList.get(i);
                                i++;
                                rl0.y((Runnable) obj);
                            }
                            rl0.z.clear();
                        } finally {
                        }
                        break;
                    }
                }
                SystemClock.uptimeMillis();
                return;
            default:
                hl0 hl0VarL2 = this.i.l(this.h);
                if (hl0VarL2 != null) {
                    hl0VarL2.startBinding();
                    return;
                }
                return;
        }
    }

    public ll0(u uVar, hl0 hl0Var, long j) {
        this.i = uVar;
        this.h = hl0Var;
    }
}
