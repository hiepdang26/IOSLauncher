package defpackage;

import android.content.Context;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class m4 {
    public final t a;
    public final ArrayList b = new ArrayList();
    public final HashMap c = new HashMap();
    public final ArrayList d = new ArrayList();
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final HashMap j = new HashMap();
    public c4 k;
    public final q11 l;
    public final wb2 m;
    public k4 n;
    public int o;
    public int p;
    public int q;

    public m4(Context context) {
        this.a = (t) context;
        this.l = new q11(context);
        this.m = new wb2(context, 2);
    }

    public final String a(CharSequence charSequence) {
        HashMap map = this.j;
        String str = (String) map.get(charSequence);
        if (str != null) {
            return str;
        }
        q11 q11Var = this.l;
        q11Var.getClass();
        String strB = ar1.B(charSequence);
        iy iyVar = (iy) q11Var.i;
        String strL = iyVar.l(iyVar.k(strB));
        if (ar1.B(strL).isEmpty() && strB.length() > 0) {
            int iCodePointAt = strB.codePointAt(0);
            strL = Character.isDigit(iCodePointAt) ? "#" : Character.isLetter(iCodePointAt) ? (String) q11Var.h : "∙";
        }
        map.put(charSequence, strL);
        return strL;
    }

    public final void b() {
        ArrayList arrayList = this.b;
        arrayList.clear();
        arrayList.addAll(this.c.values());
        wb2 wb2Var = this.m;
        Collections.sort(arrayList, (z6) wb2Var.i);
        int i = 0;
        if (this.a.getResources().getConfiguration().locale.equals(Locale.SIMPLIFIED_CHINESE)) {
            TreeMap treeMap = new TreeMap((a7) wb2Var.j);
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                v6 v6Var = (v6) obj;
                String strA = a(v6Var.u);
                ArrayList arrayList2 = (ArrayList) treeMap.get(strA);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    treeMap.put(strA, arrayList2);
                }
                arrayList2.add(v6Var);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            Iterator it = treeMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList3.addAll((Collection) ((Map.Entry) it.next()).getValue());
            }
            arrayList.clear();
            arrayList.addAll(arrayList3);
        } else {
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                a(((v6) obj2).u);
            }
        }
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m4.c():void");
    }
}
