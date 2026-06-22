package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class vu implements ru {
    public final hx1 d;
    public int f;
    public int g;
    public hx1 a = null;
    public boolean b = false;
    public boolean c = false;
    public int e = 1;
    public int h = 1;
    public gv i = null;
    public boolean j = false;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();

    public vu(hx1 hx1Var) {
        this.d = hx1Var;
    }

    @Override // defpackage.ru
    public final void a(ru ruVar) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (!((vu) obj).j) {
                return;
            }
        }
        this.c = true;
        hx1 hx1Var = this.a;
        if (hx1Var != null) {
            hx1Var.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        int size2 = arrayList.size();
        vu vuVar = null;
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            vu vuVar2 = (vu) obj2;
            if (!(vuVar2 instanceof gv)) {
                i++;
                vuVar = vuVar2;
            }
        }
        if (vuVar != null && i == 1 && vuVar.j) {
            gv gvVar = this.i;
            if (gvVar != null) {
                if (!gvVar.j) {
                    return;
                } else {
                    this.f = this.h * gvVar.g;
                }
            }
            d(vuVar.g + this.f);
        }
        hx1 hx1Var2 = this.a;
        if (hx1Var2 != null) {
            hx1Var2.a(this);
        }
    }

    public final void b(hx1 hx1Var) {
        this.k.add(hx1Var);
        if (this.j) {
            hx1Var.a(hx1Var);
        }
    }

    public final void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ru ruVar = (ru) obj;
            ruVar.a(ruVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.j0);
        sb.append(":");
        switch (this.e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
