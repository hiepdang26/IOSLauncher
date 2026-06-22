package defpackage;

import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class cd implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ fd h;

    public /* synthetic */ cd(fd fdVar, int i) {
        this.g = i;
        this.h = fdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                fd fdVar = this.h;
                ArrayList arrayList = fdVar.c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ed edVar = (ed) obj;
                    if (fdVar.i) {
                        edVar.getClass();
                    } else {
                        edVar.a();
                    }
                }
                break;
            default:
                try {
                    fd fdVar2 = this.h;
                    int iA = fd.a(fdVar2, fdVar2.e);
                    t tVar = jk0.a().g;
                    tVar.runOnUiThread(new dd(iA, tVar));
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
        }
    }
}
