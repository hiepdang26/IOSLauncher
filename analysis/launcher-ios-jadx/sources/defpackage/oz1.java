package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.gms.common.api.Status;
import com.luutinhit.launcher6.Folder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class oz1 implements my0, iw {
    public final /* synthetic */ int g;
    public Object h;
    public final Object i;

    public /* synthetic */ oz1(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    public static a5 a(ImageDecoder.Source source, int i, int i2, g01 g01Var) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new wt(i, i2, g01Var));
        if (h0.w(drawableDecodeDrawable)) {
            return new a5(h0.g(drawableDecodeDrawable), 0);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    @Override // defpackage.iw
    public void b(oc ocVar, Bitmap bitmap) throws IOException {
        IOException iOException = ((b10) this.i).h;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            ocVar.j(bitmap);
            throw iOException;
        }
    }

    public File c() {
        if (((File) this.h) == null) {
            this.h = new File(((Context) this.i).getCacheDir(), "volley");
        }
        return (File) this.h;
    }

    public Object d(g21 g21Var) {
        HashMap map = (HashMap) this.i;
        ua0 ua0Var = (ua0) map.get(g21Var);
        if (ua0Var == null) {
            ua0Var = new ua0(g21Var);
            map.put(g21Var, ua0Var);
        } else {
            g21Var.a();
        }
        ua0 ua0Var2 = ua0Var.d;
        ua0Var2.c = ua0Var.c;
        ua0Var.c.d = ua0Var2;
        ua0 ua0Var3 = (ua0) this.h;
        ua0Var.d = ua0Var3;
        ua0 ua0Var4 = ua0Var3.c;
        ua0Var.c = ua0Var4;
        ua0Var4.d = ua0Var;
        ua0Var.d.c = ua0Var;
        ArrayList arrayList = ua0Var.b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return ua0Var.b.remove(size - 1);
        }
        return null;
    }

    public ArrayList e(String str) {
        lc1 lc1VarA = lc1.a(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
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

    @Override // defpackage.iw
    public void f() {
        k81 k81Var = (k81) this.h;
        synchronized (k81Var) {
            k81Var.i = k81Var.g.length;
        }
    }

    public void g(g50 g50Var) {
        int i = g50Var.b;
        k10 k10Var = (k10) this.i;
        nx0 nx0Var = (nx0) this.h;
        if (i == 0) {
            k10Var.execute(new w1(nx0Var, g50Var.a, 7));
        } else {
            k10Var.execute(new yf(nx0Var, i, 0));
        }
    }

    public void h(g21 g21Var, Object obj) {
        HashMap map = (HashMap) this.i;
        ua0 ua0Var = (ua0) map.get(g21Var);
        if (ua0Var == null) {
            ua0Var = new ua0(g21Var);
            ua0Var.d = ua0Var;
            ua0 ua0Var2 = (ua0) this.h;
            ua0Var.d = ua0Var2.d;
            ua0Var.c = ua0Var2;
            ua0Var2.d = ua0Var;
            ua0Var.d.c = ua0Var;
            map.put(g21Var, ua0Var);
        } else {
            g21Var.a();
        }
        if (ua0Var.b == null) {
            ua0Var.b = new ArrayList();
        }
        ua0Var.b.add(obj);
    }

    public void i(Class cls, Class cls2, Class cls3, List list) {
        synchronized (((e9) this.i)) {
            ((e9) this.i).put(new tu0(cls, cls2, cls3), list);
        }
    }

    public Object j() {
        ua0 ua0Var = (ua0) this.h;
        ua0 ua0Var2 = ua0Var.d;
        while (true) {
            if (ua0Var2.equals(ua0Var)) {
                return null;
            }
            ArrayList arrayList = ua0Var2.b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object objRemove = size > 0 ? ua0Var2.b.remove(size - 1) : null;
            if (objRemove != null) {
                return objRemove;
            }
            ua0 ua0Var3 = ua0Var2.d;
            ua0Var3.c = ua0Var2.c;
            ua0Var2.c.d = ua0Var3;
            HashMap map = (HashMap) this.i;
            g21 g21Var = ua0Var2.a;
            map.remove(g21Var);
            g21Var.a();
            ua0Var2 = ua0Var2.d;
        }
    }

    public void k(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.h)) {
            map = new HashMap((Map) this.h);
        }
        synchronized (((Map) this.i)) {
            map2 = new HashMap((Map) this.i);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((qm1) entry2.getKey()).b(new v5(status));
            }
        }
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        ((Folder) this.i).F((nx) this.h);
    }

    public String toString() {
        switch (this.g) {
            case 4:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                ua0 ua0Var = (ua0) this.h;
                ua0 ua0Var2 = ua0Var.c;
                boolean z = false;
                while (!ua0Var2.equals(ua0Var)) {
                    sb.append('{');
                    sb.append(ua0Var2.a);
                    sb.append(':');
                    ArrayList arrayList = ua0Var2.b;
                    sb.append(arrayList != null ? arrayList.size() : 0);
                    sb.append("}, ");
                    ua0Var2 = ua0Var2.c;
                    z = true;
                }
                if (z) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            case 5:
            default:
                return super.toString();
            case 6:
                String string = "[ ";
                if (((di1) this.h) != null) {
                    for (int i = 0; i < 9; i++) {
                        StringBuilder sbM = uo.m(string);
                        sbM.append(((di1) this.h).n[i]);
                        sbM.append(" ");
                        string = sbM.toString();
                    }
                }
                StringBuilder sbM2 = k31.m(string, "] ");
                sbM2.append((di1) this.h);
                return sbM2.toString();
        }
    }

    public oz1(int i) {
        this.g = i;
        switch (i) {
            case 5:
                this.h = new AtomicReference();
                this.i = new e9(0);
                break;
            case 9:
                this.h = Collections.synchronizedMap(new WeakHashMap());
                this.i = Collections.synchronizedMap(new WeakHashMap());
                break;
            default:
                this.h = new ua0(null);
                this.i = new HashMap();
                break;
        }
    }

    public oz1(WorkDatabase_Impl workDatabase_Impl) {
        this.g = 0;
        this.h = workDatabase_Impl;
        this.i = new su(workDatabase_Impl, 8);
        new pm0(workDatabase_Impl, 20);
    }

    public oz1(l31 l31Var) {
        this.g = 6;
        this.i = l31Var;
    }

    public oz1(Context context) {
        this.g = 8;
        this.i = context;
        this.h = null;
    }

    public oz1(Folder folder, nx nxVar) {
        this.g = 3;
        this.i = folder;
        this.h = nxVar;
    }
}
