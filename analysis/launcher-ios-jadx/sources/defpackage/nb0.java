package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class nb0 {
    public final ArrayList a = new ArrayList(20);

    public final void a(String str, String str2) {
        ArrayList arrayList = this.a;
        arrayList.add(str);
        arrayList.add(str2.trim());
    }

    public final void b(String str) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.a;
            if (i >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }

    public final void c(String str, String str2) {
        ob0.a(str);
        ob0.b(str2, str);
        b(str);
        a(str, str2);
    }
}
