package defpackage;

import android.animation.Animator;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.view.ActionMode;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class tu implements e7, jl0, c40 {
    public final /* synthetic */ int g;
    public final Object h;
    public final Object i;

    public tu(Context context) {
        wb2 wb2Var;
        this.g = 1;
        this.h = new pc2(context, ea0.b);
        synchronized (wb2.class) {
            try {
                if (wb2.k == null) {
                    wb2.k = new wb2(context.getApplicationContext(), 0);
                }
                wb2Var = wb2.k;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.i = wb2Var;
    }

    @Override // defpackage.e7
    public od2 a() {
        od2 od2VarA = ((pc2) this.h).a();
        pw1 pw1Var = new pw1(this);
        od2VarA.getClass();
        dz1 dz1Var = sm1.a;
        od2 od2Var = new od2();
        od2VarA.b.f(new b82(dz1Var, pw1Var, od2Var, 1));
        od2VarA.k();
        return od2Var;
    }

    @Override // defpackage.c40
    public Object b(Object obj, go goVar) {
        lz1 lz1Var = (lz1) this.i;
        ((qy0) this.h).b(lz1Var, (sn) obj);
        return zp1.a;
    }

    public void c(Object obj, String str) {
        ((ArrayList) this.h).add(uo.i(str, "=", String.valueOf(obj)));
    }

    public void d(m91 m91Var, ib ibVar) {
        ug1 ug1Var = (ug1) this.h;
        ys1 ys1VarA = (ys1) ug1Var.get(m91Var);
        if (ys1VarA == null) {
            ys1VarA = ys1.a();
            ug1Var.put(m91Var, ys1VarA);
        }
        ys1VarA.c = ibVar;
        ys1VarA.a |= 8;
    }

    public String e(bj0 bj0Var) {
        String str;
        hd1 hd1Var = (hd1) ((wb2) this.i).h();
        try {
            bj0Var.b(hd1Var.g);
            byte[] bArrDigest = hd1Var.g.digest();
            char[] cArr = vq1.b;
            synchronized (cArr) {
                for (int i = 0; i < bArrDigest.length; i++) {
                    byte b = bArrDigest[i];
                    int i2 = i * 2;
                    char[] cArr2 = vq1.a;
                    cArr[i2] = cArr2[(b & 255) >>> 4];
                    cArr[i2 + 1] = cArr2[b & 15];
                }
                str = new String(cArr);
            }
            return str;
        } finally {
            ((wb2) this.i).z(hd1Var);
        }
    }

    @Override // defpackage.jl0
    public boolean f(w40 w40Var, qh0 qh0Var, ComponentName componentName) {
        return componentName.getPackageName().equals((String) this.h) && qh0Var.w.equals((jq1) this.i);
    }

    public ArrayList g(String str) {
        lc1 lc1VarA = lc1.a(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            lc1VarA.g(1);
        } else {
            lc1VarA.e(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.h;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            ArrayList arrayList = new ArrayList(cursorL.getCount());
            while (cursorL.moveToNext()) {
                arrayList.add(cursorL.isNull(0) ? null : cursorL.getString(0));
            }
            return arrayList;
        } finally {
            cursorL.close();
            lc1VarA.k();
        }
    }

    public float h(float f) {
        hq hqVar = (hq) this.h;
        float f2 = hqVar.d;
        hq hqVar2 = (hq) this.i;
        float f3 = hqVar2.d;
        float f4 = (f2 * f) - (f * f3);
        float f5 = hqVar.e;
        float f6 = hqVar2.e;
        return (((f3 * f5) + f4) - (f2 * f6)) / (f5 - f6);
    }

    public float i(float f) {
        hq hqVar = (hq) this.h;
        float f2 = hqVar.e;
        hq hqVar2 = (hq) this.i;
        float f3 = hqVar2.e;
        float f4 = (f2 * f) - (f * f3);
        float f5 = hqVar.d;
        float f6 = hqVar2.d;
        return (((f3 * f5) + f4) - (f2 * f6)) / (f5 - f6);
    }

    public String j(bj0 bj0Var) {
        String strE;
        synchronized (((fq0) this.h)) {
            strE = (String) ((fq0) this.h).a(bj0Var);
        }
        if (strE == null) {
            strE = e(bj0Var);
        }
        synchronized (((fq0) this.h)) {
            ((fq0) this.h).d(bj0Var, strE);
        }
        return strE;
    }

    public void k(j1 j1Var) {
        ol1 ol1Var = (ol1) this.h;
        ((ActionMode.Callback) ol1Var.g).onDestroyActionMode(ol1Var.h(j1Var));
        q6 q6Var = (q6) this.i;
        if (q6Var.v != null) {
            q6Var.k.getDecorView().removeCallbacks(q6Var.w);
        }
        if (q6Var.u != null) {
            zt1 zt1Var = q6Var.x;
            if (zt1Var != null) {
                zt1Var.b();
            }
            zt1 zt1VarA = qs1.a(q6Var.u);
            zt1VarA.a(0.0f);
            q6Var.x = zt1VarA;
            zt1VarA.d(new j6(this, 2));
        }
        q6Var.t = null;
        ViewGroup viewGroup = q6Var.z;
        WeakHashMap weakHashMap = qs1.a;
        fs1.c(viewGroup);
    }

    public boolean l(j1 j1Var, gt0 gt0Var) {
        ViewGroup viewGroup = ((q6) this.i).z;
        WeakHashMap weakHashMap = qs1.a;
        fs1.c(viewGroup);
        ol1 ol1Var = (ol1) this.h;
        pk1 pk1VarH = ol1Var.h(j1Var);
        ug1 ug1Var = (ug1) ol1Var.j;
        Menu zt0Var = (Menu) ug1Var.get(gt0Var);
        if (zt0Var == null) {
            zt0Var = new zt0((Context) ol1Var.h, gt0Var);
            ug1Var.put(gt0Var, zt0Var);
        }
        return ((ActionMode.Callback) ol1Var.g).onPrepareActionMode(pk1VarH, zt0Var);
    }

    public ib m(m91 m91Var, int i) {
        ys1 ys1Var;
        ib ibVar;
        ug1 ug1Var = (ug1) this.h;
        int iD = ug1Var.d(m91Var);
        if (iD >= 0 && (ys1Var = (ys1) ug1Var.j(iD)) != null) {
            int i2 = ys1Var.a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                ys1Var.a = i3;
                if (i == 4) {
                    ibVar = ys1Var.b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    ibVar = ys1Var.c;
                }
                if ((i3 & 12) == 0) {
                    ug1Var.h(iD);
                    ys1Var.a = 0;
                    ys1Var.b = null;
                    ys1Var.c = null;
                    ys1.d.c(ys1Var);
                }
                return ibVar;
            }
        }
        return null;
    }

    public void n(m91 m91Var) {
        ys1 ys1Var = (ys1) ((ug1) this.h).get(m91Var);
        if (ys1Var == null) {
            return;
        }
        ys1Var.a &= -2;
    }

    public void o(m91 m91Var) {
        xp0 xp0Var = (xp0) this.i;
        int iH = xp0Var.h() - 1;
        while (true) {
            if (iH < 0) {
                break;
            }
            if (m91Var == xp0Var.i(iH)) {
                Object[] objArr = xp0Var.i;
                Object obj = objArr[iH];
                Object obj2 = z71.c;
                if (obj != obj2) {
                    objArr[iH] = obj2;
                    xp0Var.g = true;
                }
            } else {
                iH--;
            }
        }
        ys1 ys1Var = (ys1) ((ug1) this.h).remove(m91Var);
        if (ys1Var != null) {
            ys1Var.a = 0;
            ys1Var.b = null;
            ys1Var.c = null;
            ys1.d.c(ys1Var);
        }
    }

    public String toString() {
        switch (this.g) {
            case 6:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.i.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.h;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ tu(Object obj, Object obj2, int i) {
        this.g = i;
        this.i = obj;
        this.h = obj2;
    }

    public /* synthetic */ tu(Object obj, Object obj2, int i, boolean z) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    public /* synthetic */ tu(Object obj) {
        this.g = 6;
        this.i = obj;
        this.h = new ArrayList();
    }

    public tu(int i) {
        this.g = i;
        switch (i) {
            case 8:
                this.h = new ug1(0);
                this.i = new xp0();
                break;
            default:
                this.h = new fq0(1000L);
                this.i = os.t(10, new b21(1));
                break;
        }
    }

    public tu(WorkDatabase_Impl workDatabase_Impl) {
        this.g = 0;
        this.h = workDatabase_Impl;
        this.i = new su(workDatabase_Impl, 0);
    }

    public tu(Animation animation) {
        this.g = 4;
        this.h = animation;
        this.i = null;
    }

    public tu(Animator animator) {
        this.g = 4;
        this.h = null;
        this.i = animator;
    }
}
