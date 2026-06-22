package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ei {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;
    public Serializable e;
    public Object f;

    public static void d(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char cCharAt = str.charAt(!z ? i : length);
            boolean z2 = cCharAt < ' ' || cCharAt == ' ';
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [double[], java.io.Serializable] */
    public void a(double d, float f) {
        int length = ((float[]) this.c).length + 1;
        int iBinarySearch = Arrays.binarySearch((double[]) this.d, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.d = Arrays.copyOf((double[]) this.d, length);
        this.c = Arrays.copyOf((float[]) this.c, length);
        this.e = new double[length];
        double[] dArr = (double[]) this.d;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        ((double[]) this.d)[iBinarySearch] = d;
        ((float[]) this.c)[iBinarySearch] = f;
    }

    public void b(View view, int i, boolean z) {
        RecyclerView recyclerView = (RecyclerView) ((mc1) this.c).h;
        int childCount = i < 0 ? recyclerView.getChildCount() : h(i);
        ((di) this.d).e(childCount, z);
        if (z) {
            m(view);
        }
        recyclerView.addView(view, childCount);
        m91 m91VarQ = RecyclerView.Q(view);
        m81 m81Var = recyclerView.s;
        if (m81Var != null && m91VarQ != null) {
            m81Var.l(m91VarQ);
        }
        ArrayList arrayList = recyclerView.I;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((w81) recyclerView.I.get(size)).a(view);
            }
        }
    }

    public void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = (RecyclerView) ((mc1) this.c).h;
        int childCount = i < 0 ? recyclerView.getChildCount() : h(i);
        ((di) this.d).e(childCount, z);
        if (z) {
            m(view);
        }
        m91 m91VarQ = RecyclerView.Q(view);
        if (m91VarQ != null) {
            if (!m91VarQ.o() && !m91VarQ.t()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(m91VarQ);
                throw new IllegalArgumentException(uo.e(recyclerView, sb));
            }
            if (RecyclerView.H0) {
                m91VarQ.toString();
            }
            m91VarQ.p &= -257;
        } else if (RecyclerView.G0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(uo.e(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public void e(int i) {
        int iH = h(i);
        ((di) this.d).f(iH);
        RecyclerView recyclerView = (RecyclerView) ((mc1) this.c).h;
        View childAt = recyclerView.getChildAt(iH);
        if (childAt != null) {
            m91 m91VarQ = RecyclerView.Q(childAt);
            if (m91VarQ != null) {
                if (m91VarQ.o() && !m91VarQ.t()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(m91VarQ);
                    throw new IllegalArgumentException(uo.e(recyclerView, sb));
                }
                if (RecyclerView.H0) {
                    m91VarQ.toString();
                }
                m91VarQ.c(MotionScene.Transition.TransitionOnClick.JUMP_TO_END);
            }
        } else if (RecyclerView.G0) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(iH);
            throw new IllegalArgumentException(uo.e(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(iH);
    }

    public View f(int i) {
        return ((RecyclerView) ((mc1) this.c).h).getChildAt(h(i));
    }

    public int g() {
        return ((RecyclerView) ((mc1) this.c).h).getChildCount() - ((ArrayList) this.e).size();
    }

    public int h(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = ((RecyclerView) ((mc1) this.c).h).getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            di diVar = (di) this.d;
            int iB = i - (i2 - diVar.b(i2));
            if (iB == 0) {
                while (diVar.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    public double i(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch((double[]) this.d, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = (float[]) this.c;
        float f = fArr[iBinarySearch];
        int i = iBinarySearch - 1;
        float f2 = fArr[i];
        double d2 = f - f2;
        double[] dArr = (double[]) this.d;
        double d3 = dArr[iBinarySearch];
        double d4 = dArr[i];
        double d5 = d2 / (d3 - d4);
        return ((((d * d) - (d4 * d4)) * d5) / 2.0d) + ((d - d4) * (((double) f2) - (d5 * d4))) + ((double[]) this.e)[i];
    }

    public View j(int i) {
        return ((RecyclerView) ((mc1) this.c).h).getChildAt(i);
    }

    public int k() {
        return ((RecyclerView) ((mc1) this.c).h).getChildCount();
    }

    public double l(double d, double d2) {
        double dAbs;
        double dI = i(d) + d2;
        switch (this.b) {
            case 1:
                return Math.signum(0.5d - (dI % 1.0d));
            case 2:
                dAbs = Math.abs((((dI * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((dI * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((dI * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d2 + dI) * 6.283185307179586d);
            case 6:
                double dAbs2 = 1.0d - Math.abs(((dI * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return ((ou0) this.f).b(dI % 1.0d);
            default:
                return Math.sin(6.283185307179586d * dI);
        }
        return 1.0d - dAbs;
    }

    public void m(View view) {
        ((ArrayList) this.e).add(view);
        mc1 mc1Var = (mc1) this.c;
        m91 m91VarQ = RecyclerView.Q(view);
        if (m91VarQ != null) {
            int i = m91VarQ.w;
            View view2 = m91VarQ.g;
            if (i != -1) {
                m91VarQ.v = i;
            } else {
                WeakHashMap weakHashMap = qs1.a;
                m91VarQ.v = view2.getImportantForAccessibility();
            }
            RecyclerView recyclerView = (RecyclerView) mc1Var.h;
            if (recyclerView.T()) {
                m91VarQ.w = 4;
                recyclerView.A0.add(m91VarQ);
            } else {
                WeakHashMap weakHashMap2 = qs1.a;
                view2.setImportantForAccessibility(4);
            }
        }
    }

    public void o(s60 s60Var) throws IOException {
        Cursor cursorC = s60Var.C("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (cursorC.moveToFirst()) {
                if (cursorC.getInt(0) == 0) {
                    z = true;
                }
            }
            cursorC.close();
            th0 th0Var = (th0) this.d;
            th0Var.d(s60Var);
            if (!z) {
                jd jdVarV = th0Var.v(s60Var);
                if (!jdVarV.a) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + ((String) jdVarV.b));
                }
            }
            s(s60Var);
            th0Var.p(s60Var);
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(defpackage.s60 r6) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r6.C(r0)
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L15
            r2 = 0
            if (r1 == 0) goto L18
            int r1 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L18
            r1 = 1
            goto L19
        L15:
            r6 = move-exception
            goto L9f
        L18:
            r1 = 0
        L19:
            r0.close()
            java.lang.Object r0 = r5.d
            th0 r0 = (defpackage.th0) r0
            r3 = 0
            if (r1 == 0) goto L76
            wg1 r1 = new wg1
            java.lang.String r4 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r1.<init>(r4)
            android.database.Cursor r1 = r6.B(r1)
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L3b
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L39
            goto L3c
        L39:
            r6 = move-exception
            goto L70
        L3b:
            r2 = r3
        L3c:
            r1.close()
            java.io.Serializable r1 = r5.e
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L81
            java.lang.Object r4 = r5.f
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L54
            goto L81
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = ", found: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L70:
            throw r6     // Catch: java.lang.Throwable -> L71
        L71:
            r0 = move-exception
            defpackage.os.a(r1, r6)
            throw r0
        L76:
            jd r1 = r0.v(r6)
            boolean r2 = r1.a
            if (r2 == 0) goto L87
            r5.s(r6)
        L81:
            r0.r(r6)
            r5.c = r3
            return
        L87:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.Object r1 = r1.b
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L9f:
            throw r6     // Catch: java.lang.Throwable -> La0
        La0:
            r1 = move-exception
            defpackage.os.a(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ei.p(s60):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0085 A[EDGE_INSN: B:73:0x0085->B:37:0x0085 BREAK  A[LOOP:1: B:12:0x0022->B:76:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(defpackage.s60 r13, int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ei.q(s60, int, int):void");
    }

    public void r(View view) {
        if (((ArrayList) this.e).remove(view)) {
            mc1 mc1Var = (mc1) this.c;
            m91 m91VarQ = RecyclerView.Q(view);
            if (m91VarQ != null) {
                int i = m91VarQ.v;
                RecyclerView recyclerView = (RecyclerView) mc1Var.h;
                if (recyclerView.T()) {
                    m91VarQ.w = i;
                    recyclerView.A0.add(m91VarQ);
                } else {
                    WeakHashMap weakHashMap = qs1.a;
                    m91VarQ.g.setImportantForAccessibility(i);
                }
                m91VarQ.v = 0;
            }
        }
    }

    public void s(s60 s60Var) {
        s60Var.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        s60Var.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) this.e) + "')");
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return ((di) this.d).toString() + ", hidden list:" + ((ArrayList) this.e).size();
            case 1:
                return "pos =" + Arrays.toString((double[]) this.d) + " period=" + Arrays.toString((float[]) this.c);
            default:
                return super.toString();
        }
    }

    public ei(ks ksVar, th0 th0Var, String str, String str2) {
        this.a = 2;
        int i = th0Var.a;
        this.a = 2;
        this.b = i;
        this.c = ksVar;
        this.d = th0Var;
        this.e = str;
        this.f = str2;
    }

    public ei(mc1 mc1Var) {
        this.a = 0;
        this.b = 0;
        this.c = mc1Var;
        this.d = new di(0);
        this.e = new ArrayList();
    }

    public void n(s60 s60Var) {
    }
}
