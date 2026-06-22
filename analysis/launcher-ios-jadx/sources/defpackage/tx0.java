package defpackage;

import com.luutinhit.launcher6.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class tx0 {
    public t a;
    public List b;

    public final void a(List list) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (list == null || !this.b.equals(list)) {
            this.b = list;
            this.a.updateIconBadges(list);
        }
    }
}
