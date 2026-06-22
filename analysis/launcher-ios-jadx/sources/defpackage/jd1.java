package defpackage;

import android.os.Bundle;
import androidx.activity.a;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class jd1 implements md1 {
    public final nd1 a;
    public boolean b;
    public Bundle c;
    public final fl1 d;

    public jd1(nd1 nd1Var, a aVar) {
        qg0.l(nd1Var, "savedStateRegistry");
        this.a = nd1Var;
        this.d = new fl1(new w60(aVar, 1));
    }

    @Override // defpackage.md1
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it = ((kd1) this.d.a()).c.entrySet().iterator();
        if (!it.hasNext()) {
            this.b = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getValue().getClass();
        throw new ClassCastException();
    }
}
