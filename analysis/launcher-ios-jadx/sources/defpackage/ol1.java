package defpackage;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.util.Base64;
import android.util.JsonWriter;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.impl.WorkDatabase_Impl;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class ol1 implements nb2 {
    public Object g;
    public final Object h;
    public Object i;
    public final Object j;

    public /* synthetic */ ol1(String str, String str2, Map map, byte[] bArr) {
        this.g = str;
        this.h = str2;
        this.i = map;
        this.j = bArr;
    }

    @Override // defpackage.nb2
    public void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value((String) this.g);
        jsonWriter.name("verb").value((String) this.h);
        jsonWriter.endObject();
        ub2.e(jsonWriter, (Map) this.i);
        byte[] bArr = (byte[]) this.j;
        if (bArr != null) {
            jsonWriter.name("body").value(Base64.encodeToString(bArr, 0));
        }
        jsonWriter.endObject();
    }

    public void b(c81 c81Var) {
        synchronized (this) {
            ((ArrayDeque) this.h).add(c81Var);
            c81 c81VarE = e(c81Var.k.i.a.d);
            if (c81VarE != null) {
                c81Var.j = c81VarE.j;
            }
        }
        m();
    }

    public synchronized void c(d81 d81Var) {
        ((ArrayDeque) this.j).add(d81Var);
    }

    public synchronized ExecutorService d() {
        try {
            if (((ThreadPoolExecutor) this.g) == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                byte[] bArr = wq1.a;
                this.g = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, timeUnit, synchronousQueue, new tq1("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (ThreadPoolExecutor) this.g;
    }

    public c81 e(String str) {
        for (c81 c81Var : (ArrayDeque) this.i) {
            if (c81Var.k.i.a.d.equals(str)) {
                return c81Var;
            }
        }
        for (c81 c81Var2 : (ArrayDeque) this.h) {
            if (c81Var2.k.i.a.d.equals(str)) {
                return c81Var2;
            }
        }
        return null;
    }

    public void f(c81 c81Var) {
        c81Var.j.decrementAndGet();
        g((ArrayDeque) this.i, c81Var);
    }

    public void g(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        m();
    }

    public pk1 h(j1 j1Var) {
        ArrayList arrayList = (ArrayList) this.i;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            pk1 pk1Var = (pk1) arrayList.get(i);
            if (pk1Var != null && pk1Var.b == j1Var) {
                return pk1Var;
            }
        }
        pk1 pk1Var2 = new pk1((Context) this.h, j1Var);
        arrayList.add(pk1Var2);
        return pk1Var2;
    }

    public nl1 i(zy1 zy1Var) {
        lc1 lc1VarA = lc1.a(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        String str = zy1Var.a;
        if (str == null) {
            lc1VarA.g(1);
        } else {
            lc1VarA.e(1, str);
        }
        lc1VarA.q(2, zy1Var.b);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.g;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            int iN = hg0.n(cursorL, "work_spec_id");
            int iN2 = hg0.n(cursorL, "generation");
            int iN3 = hg0.n(cursorL, "system_id");
            nl1 nl1Var = null;
            String string = null;
            if (cursorL.moveToFirst()) {
                if (!cursorL.isNull(iN)) {
                    string = cursorL.getString(iN);
                }
                nl1Var = new nl1(string, cursorL.getInt(iN2), cursorL.getInt(iN3));
            }
            return nl1Var;
        } finally {
            cursorL.close();
            lc1VarA.k();
        }
    }

    public void j(nl1 nl1Var) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.g;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((su) this.h).f(nl1Var);
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
        }
    }

    public boolean k(j1 j1Var, MenuItem menuItem) {
        return ((ActionMode.Callback) this.g).onActionItemClicked(h(j1Var), new qt0((Context) this.h, (uk1) menuItem));
    }

    public boolean l(j1 j1Var, gt0 gt0Var) {
        pk1 pk1VarH = h(j1Var);
        ug1 ug1Var = (ug1) this.j;
        Menu zt0Var = (Menu) ug1Var.get(gt0Var);
        if (zt0Var == null) {
            zt0Var = new zt0((Context) this.h, gt0Var);
            ug1Var.put(gt0Var, zt0Var);
        }
        return ((ActionMode.Callback) this.g).onCreateActionMode(pk1VarH, zt0Var);
    }

    public void m() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.h).iterator();
                while (it.hasNext()) {
                    c81 c81Var = (c81) it.next();
                    if (((ArrayDeque) this.i).size() >= 64) {
                        break;
                    }
                    if (c81Var.j.get() < 5) {
                        it.remove();
                        c81Var.j.incrementAndGet();
                        arrayList.add(c81Var);
                        ((ArrayDeque) this.i).add(c81Var);
                    }
                }
                n();
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c81 c81Var2 = (c81) arrayList.get(i);
            ExecutorService executorServiceD = d();
            d81 d81Var = c81Var2.k;
            try {
                try {
                    ((ThreadPoolExecutor) executorServiceD).execute(c81Var2);
                } catch (Throwable th2) {
                    d81Var.g.g.f(c81Var2);
                    throw th2;
                }
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                d81Var.h.f(interruptedIOException);
                c81Var2.i.onFailure(d81Var, interruptedIOException);
                d81Var.g.g.f(c81Var2);
            }
        }
    }

    public synchronized int n() {
        return ((ArrayDeque) this.i).size() + ((ArrayDeque) this.j).size();
    }

    public void o() {
        int iC;
        ViewPager2 viewPager2 = (ViewPager2) this.j;
        int i = R.id.accessibilityActionPageLeft;
        qs1.m(R.id.accessibilityActionPageLeft, viewPager2);
        qs1.h(0, viewPager2);
        qs1.m(R.id.accessibilityActionPageRight, viewPager2);
        qs1.h(0, viewPager2);
        qs1.m(R.id.accessibilityActionPageUp, viewPager2);
        qs1.h(0, viewPager2);
        qs1.m(R.id.accessibilityActionPageDown, viewPager2);
        qs1.h(0, viewPager2);
        if (viewPager2.getAdapter() == null || (iC = viewPager2.getAdapter().c()) == 0 || !viewPager2.w) {
            return;
        }
        int orientation = viewPager2.getOrientation();
        mc1 mc1Var = (mc1) this.h;
        fz1 fz1Var = (fz1) this.g;
        if (orientation != 0) {
            if (viewPager2.i < iC - 1) {
                qs1.n(viewPager2, new n0(R.id.accessibilityActionPageDown), fz1Var);
            }
            if (viewPager2.i > 0) {
                qs1.n(viewPager2, new n0(R.id.accessibilityActionPageUp), mc1Var);
                return;
            }
            return;
        }
        boolean z = viewPager2.l.E() == 1;
        int i2 = z ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
        if (z) {
            i = R.id.accessibilityActionPageRight;
        }
        if (viewPager2.i < iC - 1) {
            qs1.n(viewPager2, new n0(i2), fz1Var);
        }
        if (viewPager2.i > 0) {
            qs1.n(viewPager2, new n0(i), mc1Var);
        }
    }

    public ol1(WorkDatabase_Impl workDatabase_Impl) {
        this.g = workDatabase_Impl;
        this.h = new su(workDatabase_Impl, 4);
        this.i = new pm0(workDatabase_Impl, 1);
        this.j = new pm0(workDatabase_Impl, 2);
    }

    public ol1(ArrayList arrayList, tn1 tn1Var, cq0 cq0Var, ContentResolver contentResolver) {
        this.g = tn1Var;
        this.h = cq0Var;
        this.i = contentResolver;
        this.j = arrayList;
    }

    public ol1() {
        this.h = new ArrayDeque();
        this.i = new ArrayDeque();
        this.j = new ArrayDeque();
    }

    public ol1(Context context, ActionMode.Callback callback) {
        this.h = context;
        this.g = callback;
        this.i = new ArrayList();
        this.j = new ug1(0);
    }

    public ol1(ViewPager2 viewPager2) {
        this.j = viewPager2;
        this.g = new fz1(this, 29);
        this.h = new mc1(this, 28);
    }
}
