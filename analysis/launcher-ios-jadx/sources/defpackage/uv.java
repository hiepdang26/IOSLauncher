package defpackage;

import android.net.ConnectivityManager;
import android.os.Trace;
import android.util.Log;
import com.bumptech.glide.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class uv implements w90, dh1 {
    public final Object g;
    public boolean h;
    public final Object i;
    public final Object j;

    public uv(JSONObject jSONObject, ef efVar) {
        this.h = false;
        this.i = jSONObject;
        this.g = efVar;
        this.j = null;
    }

    @Override // defpackage.dh1
    public void a() {
        ((ConnectivityManager) ((zn) this.g).get()).unregisterNetworkCallback((gx0) this.j);
    }

    @Override // defpackage.dh1
    public boolean b() {
        zn znVar = (zn) this.g;
        this.h = ((ConnectivityManager) znVar.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) znVar.get()).registerDefaultNetworkCallback((gx0) this.j);
            return true;
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return false;
        }
    }

    public void c() {
        wv.a((wv) this.j, this, false);
    }

    public File d() {
        File file;
        synchronized (((wv) this.j)) {
            try {
                vv vvVar = (vv) this.i;
                if (vvVar.f != this) {
                    throw new IllegalStateException();
                }
                if (!vvVar.e) {
                    ((boolean[]) this.g)[0] = true;
                }
                file = vvVar.d[0];
                ((wv) this.j).g.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public int[] e() {
        synchronized (this) {
            try {
                if (!this.h) {
                    return null;
                }
                long[] jArr = (long[]) this.i;
                int length = jArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    int i4 = 1;
                    boolean z = jArr[i] > 0;
                    boolean[] zArr = (boolean[]) this.g;
                    if (z != zArr[i2]) {
                        int[] iArr = (int[]) this.j;
                        if (!z) {
                            i4 = 2;
                        }
                        iArr[i2] = i4;
                    } else {
                        ((int[]) this.j)[i2] = 0;
                    }
                    zArr[i2] = z;
                    i++;
                    i2 = i3;
                }
                this.h = false;
                return (int[]) ((int[]) this.j).clone();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.w90
    public Object get() {
        if (this.h) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        z71.c("Glide registry");
        this.h = true;
        try {
            return z71.g((a) this.i, (List) this.g, (qg0) this.j);
        } finally {
            this.h = false;
            Trace.endSection();
        }
    }

    public uv(dv1 dv1Var) {
        this.h = false;
        this.i = null;
        this.g = null;
        this.j = dv1Var;
    }

    public uv(a aVar, List list, qg0 qg0Var) {
        this.i = aVar;
        this.g = list;
        this.j = qg0Var;
    }

    public uv(byte[] bArr, Map map, List list, boolean z) {
        this.i = bArr;
        this.g = map;
        if (list == null) {
            this.j = null;
        } else {
            this.j = Collections.unmodifiableList(list);
        }
        this.h = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public uv(byte[] bArr, boolean z, List list) {
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.EMPTY_MAP;
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jb0 jb0Var = (jb0) it.next();
                treeMap.put(jb0Var.a, jb0Var.b);
            }
        }
        this(bArr, treeMap, list, z);
    }

    public uv(zn znVar, ch1 ch1Var) {
        this.j = new gx0(this, 1);
        this.g = znVar;
        this.i = ch1Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public uv(byte[] bArr, Map map) {
        ?? arrayList;
        if (map == null) {
            arrayList = 0;
        } else if (map.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new jb0((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(bArr, map, arrayList, false);
    }

    public uv(int i) {
        this.i = new long[i];
        this.g = new boolean[i];
        this.j = new int[i];
    }

    public uv(wv wvVar, vv vvVar) {
        this.j = wvVar;
        this.i = vvVar;
        this.g = vvVar.e ? null : new boolean[wvVar.m];
    }
}
