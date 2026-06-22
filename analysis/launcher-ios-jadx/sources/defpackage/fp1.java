package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class fp1 {
    public final View b;
    public final HashMap a = new HashMap();
    public final ArrayList c = new ArrayList();

    public fp1(View view) {
        this.b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof fp1)) {
            return false;
        }
        fp1 fp1Var = (fp1) obj;
        return this.b == fp1Var.b && this.a.equals(fp1Var.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbM = k31.m("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbM.append(this.b);
        sbM.append("\n");
        String strH = uo.h(sbM.toString(), "    values:");
        HashMap map = this.a;
        for (String str : map.keySet()) {
            strH = strH + "    " + str + ": " + map.get(str) + "\n";
        }
        return strH;
    }
}
