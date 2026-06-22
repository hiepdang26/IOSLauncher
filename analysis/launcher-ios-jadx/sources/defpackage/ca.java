package defpackage;

import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ca implements f60 {
    public final ArrayList a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public boolean p;
    public final h60 q;
    public boolean r;
    public int s;

    public ca(h60 h60Var) {
        h60Var.C();
        x50 x50Var = h60Var.p;
        if (x50Var != null) {
            x50Var.C.getClassLoader();
        }
        this.a = new ArrayList();
        this.h = true;
        this.p = false;
        this.s = -1;
        this.q = h60Var;
    }

    @Override // defpackage.f60
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (h60.E(2)) {
            toString();
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        h60 h60Var = this.q;
        if (h60Var.d == null) {
            h60Var.d = new ArrayList();
        }
        h60Var.d.add(this);
        return true;
    }

    public final void b(n60 n60Var) {
        this.a.add(n60Var);
        n60Var.c = this.b;
        n60Var.d = this.c;
        n60Var.e = this.d;
        n60Var.f = this.e;
    }

    public final void c(int i) {
        if (this.g) {
            if (h60.E(2)) {
                toString();
            }
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                n60 n60Var = (n60) arrayList.get(i2);
                w50 w50Var = n60Var.b;
                if (w50Var != null) {
                    w50Var.x += i;
                    if (h60.E(2)) {
                        Objects.toString(n60Var.b);
                        int i3 = n60Var.b.x;
                    }
                }
            }
        }
    }

    public final int d(boolean z) {
        if (this.r) {
            throw new IllegalStateException("commit already called");
        }
        if (h60.E(2)) {
            toString();
            PrintWriter printWriter = new PrintWriter(new up0());
            f("  ", printWriter, true);
            printWriter.close();
        }
        this.r = true;
        boolean z2 = this.g;
        h60 h60Var = this.q;
        if (z2) {
            this.s = h60Var.i.getAndIncrement();
        } else {
            this.s = -1;
        }
        h60Var.v(this, z);
        return this.s;
    }

    public final void e(int i, w50 w50Var, String str, int i2) {
        Class<?> cls = w50Var.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = w50Var.E;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + w50Var + ": was " + w50Var.E + " now " + str);
            }
            w50Var.E = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + w50Var + " with tag " + str + " to container view with no id");
            }
            int i3 = w50Var.C;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + w50Var + ": was " + w50Var.C + " now " + i);
            }
            w50Var.C = i;
            w50Var.D = i;
        }
        b(new n60(i2, w50Var));
        w50Var.y = this.q;
    }

    public final void f(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            n60 n60Var = (n60) arrayList.get(i);
            switch (n60Var.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + n60Var.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(n60Var.b);
            if (z) {
                if (n60Var.c != 0 || n60Var.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(n60Var.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(n60Var.d));
                }
                if (n60Var.e != 0 || n60Var.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(n60Var.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(n60Var.f));
                }
            }
        }
    }

    public final void g(int i, w50 w50Var) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        e(i, w50Var, null, 2);
    }

    public final void h(w50 w50Var, vm0 vm0Var) {
        h60 h60Var = w50Var.y;
        h60 h60Var2 = this.q;
        if (h60Var != h60Var2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + h60Var2);
        }
        if (vm0Var == vm0.h && w50Var.g > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + vm0Var + " after the Fragment has been created");
        }
        if (vm0Var == vm0.g) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + vm0Var + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        n60 n60Var = new n60();
        n60Var.a = 10;
        n60Var.b = w50Var;
        n60Var.g = w50Var.S;
        n60Var.h = vm0Var;
        b(n60Var);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}
