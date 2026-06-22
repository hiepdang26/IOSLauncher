package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class yi0 implements Comparable {
    public final fv1 g;
    public final String h;
    public final int i;
    public final Object j;
    public final nv1 k;
    public Integer l;
    public ya1 m;
    public final boolean n;
    public boolean o;
    public final ib p;
    public ef q;
    public hz1 r;
    public final Object s;
    public final nv1 t;

    public yi0(nv1 nv1Var, nv1 nv1Var2) {
        Uri uri;
        String host;
        this.g = fv1.c ? new fv1() : null;
        this.j = new Object();
        this.n = true;
        int iHashCode = 0;
        this.o = false;
        this.q = null;
        this.h = "https://drive.google.com/uc?export=download&id=1ACYmpk8yKiZmLZ7vEqWlztzJo8LMz8vB";
        this.k = nv1Var2;
        ib ibVar = new ib();
        ibVar.a = 2500;
        this.p = ibVar;
        if (!TextUtils.isEmpty("https://drive.google.com/uc?export=download&id=1ACYmpk8yKiZmLZ7vEqWlztzJo8LMz8vB") && (uri = Uri.parse("https://drive.google.com/uc?export=download&id=1ACYmpk8yKiZmLZ7vEqWlztzJo8LMz8vB")) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.i = iHashCode;
        this.s = new Object();
        this.t = nv1Var;
    }

    public final void a(String str) {
        if (fv1.c) {
            this.g.a(str, Thread.currentThread().getId());
        }
    }

    public final void b(dv1 dv1Var) {
        nv1 nv1Var;
        String str;
        synchronized (this.j) {
            nv1Var = this.k;
        }
        if (nv1Var != null) {
            int i = WallpaperActivity.W;
            WallpaperActivity wallpaperActivity = nv1Var.g;
            Objects.toString(dv1Var);
            ArrayList arrayList = wallpaperActivity.P;
            try {
                arrayList.clear();
                InputStream inputStreamOpenRawResource = wallpaperActivity.getResources().openRawResource(q61.wallpaper);
                try {
                    int iAvailable = inputStreamOpenRawResource.available();
                    byte[] bArr = new byte[iAvailable];
                    inputStreamOpenRawResource.read(bArr, 0, iAvailable);
                    str = new String(bArr);
                } catch (IOException unused) {
                    str = null;
                }
                if (str != null) {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("list_wallpaper");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        arrayList.add(new qv1(jSONObject.getString("url"), jSONObject.getString("thumb")));
                    }
                    b8 b8Var = wallpaperActivity.L;
                    b8Var.k = arrayList;
                    b8Var.f();
                    wallpaperActivity.K.g();
                }
            } catch (Throwable th) {
                th.toString();
            }
        }
    }

    public final void c(String str) {
        ya1 ya1Var = this.m;
        if (ya1Var != null) {
            synchronized (ya1Var.b) {
                ya1Var.b.remove(this);
            }
            synchronized (ya1Var.j) {
                Iterator it = ya1Var.j.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            ya1Var.a();
        }
        if (fv1.c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new gl0(this, str, id));
            } else {
                this.g.a(str, id);
                this.g.b(toString());
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        yi0 yi0Var = (yi0) obj;
        yi0Var.getClass();
        return this.l.intValue() - yi0Var.l.intValue();
    }

    public final boolean d() {
        boolean z;
        synchronized (this.j) {
            z = this.o;
        }
        return z;
    }

    public final void e() {
        synchronized (this.j) {
        }
    }

    public final void f() {
        hz1 hz1Var;
        synchronized (this.j) {
            hz1Var = this.r;
        }
        if (hz1Var != null) {
            hz1Var.d(this);
        }
    }

    public final void g(uv uvVar) {
        hz1 hz1Var;
        synchronized (this.j) {
            hz1Var = this.r;
        }
        if (hz1Var != null) {
            hz1Var.e(this, uvVar);
        }
    }

    public final uv h(uv uvVar) {
        try {
            return new uv(new JSONObject(new String((byte[]) uvVar.i, hg0.v((Map) uvVar.g))), hg0.u(uvVar));
        } catch (UnsupportedEncodingException e) {
            return new uv(new r9(e));
        } catch (JSONException e2) {
            return new uv(new r9(e2));
        }
    }

    public final void i() {
        ya1 ya1Var = this.m;
        if (ya1Var != null) {
            ya1Var.a();
        }
    }

    public final void j(hz1 hz1Var) {
        synchronized (this.j) {
            this.r = hz1Var;
        }
    }

    public final String toString() {
        String str = "0x" + Integer.toHexString(this.i);
        StringBuilder sb = new StringBuilder("[ ] ");
        e();
        sb.append(this.h);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append("NORMAL");
        sb.append(" ");
        sb.append(this.l);
        return sb.toString();
    }
}
