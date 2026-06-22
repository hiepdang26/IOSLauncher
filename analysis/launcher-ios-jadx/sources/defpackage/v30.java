package defpackage;

import android.content.ComponentName;
import android.util.Pair;
import android.view.View;
import com.luutinhit.launcher6.DeleteDropTarget;
import com.luutinhit.launcher6.t;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class v30 implements View.OnClickListener {
    public final /* synthetic */ z30 g;

    public v30(z30 z30Var) {
        this.g = z30Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z30 z30Var = this.g;
        z30Var.getClass();
        try {
            z30Var.d();
            View view2 = z30Var.z;
            if (view2 != null) {
                Object tag = view2.getTag();
                Objects.toString(tag);
                if (!(tag instanceof og1) && !(tag instanceof v6) && !(tag instanceof qk0)) {
                    return;
                }
                Pair<ComponentName, Integer> appInfoFlags = t.getAppInfoFlags(tag);
                t tVar = z30Var.x;
                if (appInfoFlags == null && ((tag instanceof og1) || (tag instanceof qk0))) {
                    qh0 qh0Var = (qh0) tag;
                    int i = qh0Var.h;
                    if (i == 1 || i == 4 || i == 5) {
                        DeleteDropTarget.u(tVar, qh0Var, z30Var.z);
                        return;
                    }
                    return;
                }
                if (appInfoFlags != null) {
                    if (tag instanceof og1) {
                        tVar.startApplicationUninstallActivity((ComponentName) appInfoFlags.first, ((Integer) appInfoFlags.second).intValue(), ((og1) tag).w);
                    } else if (tag instanceof v6) {
                        tVar.startApplicationUninstallActivity((ComponentName) appInfoFlags.first, ((Integer) appInfoFlags.second).intValue(), ((v6) tag).w);
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
