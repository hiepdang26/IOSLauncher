package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class nm1 implements cn0 {
    public final Set g = Collections.newSetFromMap(new WeakHashMap());

    @Override // defpackage.cn0
    public final void b() {
        ArrayList arrayListE = vq1.e(this.g);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((lm1) obj).b();
        }
    }

    @Override // defpackage.cn0
    public final void j() {
        ArrayList arrayListE = vq1.e(this.g);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((lm1) obj).j();
        }
    }

    @Override // defpackage.cn0
    public final void onDestroy() {
        ArrayList arrayListE = vq1.e(this.g);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((lm1) obj).onDestroy();
        }
    }
}
