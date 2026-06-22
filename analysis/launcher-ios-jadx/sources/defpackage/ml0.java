package defpackage;

import android.os.SystemClock;
import com.luutinhit.launcher6.u;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ml0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ hl0 h;
    public final /* synthetic */ ArrayList i;
    public final /* synthetic */ u j;

    public /* synthetic */ ml0(u uVar, hl0 hl0Var, ArrayList arrayList, int i) {
        this.g = i;
        this.j = uVar;
        this.h = hl0Var;
        this.i = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                SystemClock.uptimeMillis();
                hl0 hl0VarL = this.j.l(this.h);
                ArrayList arrayList = this.i;
                if (hl0VarL != null) {
                    hl0VarL.bindAllApplications(arrayList);
                }
                arrayList.size();
                SystemClock.uptimeMillis();
                break;
            case 1:
                SystemClock.uptimeMillis();
                hl0 hl0VarL2 = this.j.l(this.h);
                if (hl0VarL2 != null) {
                    ArrayList arrayList2 = this.i;
                    hl0VarL2.bindAllApplications(arrayList2);
                    arrayList2.size();
                    SystemClock.uptimeMillis();
                }
                break;
            default:
                hl0 hl0VarL3 = this.j.l(this.h);
                if (hl0VarL3 != null) {
                    hl0VarL3.bindScreens(this.i);
                }
                break;
        }
    }
}
