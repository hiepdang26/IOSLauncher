package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class j9 implements cs {
    public final /* synthetic */ int g;
    public Object h;
    public final Comparable i;
    public final Object j;

    public /* synthetic */ j9(int i, Comparable comparable, Object obj) {
        this.g = i;
        this.j = obj;
        this.i = comparable;
    }

    @Override // defpackage.cs
    public final void b() {
        switch (this.g) {
            case 0:
                Object obj = this.h;
                if (obj != null) {
                    try {
                        g(obj);
                    } catch (IOException unused) {
                        return;
                    }
                    break;
                }
                break;
            default:
                Object obj2 = this.h;
                if (obj2 != null) {
                    try {
                        g(obj2);
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) {
        switch (this.g) {
            case 0:
                try {
                    Object objH = h((AssetManager) this.j, (String) this.i);
                    this.h = objH;
                    bsVar.g(objH);
                } catch (IOException e) {
                    Log.isLoggable("AssetPathFetcher", 3);
                    bsVar.e(e);
                }
                break;
            default:
                try {
                    Object objI = i((Uri) this.i, (ContentResolver) this.j);
                    this.h = objI;
                    bsVar.g(objI);
                } catch (FileNotFoundException e2) {
                    Log.isLoggable("LocalUriFetcher", 3);
                    bsVar.e(e2);
                    return;
                }
                break;
        }
    }

    @Override // defpackage.cs
    public final void cancel() {
        int i = this.g;
    }

    @Override // defpackage.cs
    public final int d() {
        switch (this.g) {
        }
        return 1;
    }

    public abstract void g(Object obj);

    public abstract Object h(AssetManager assetManager, String str);

    public abstract Object i(Uri uri, ContentResolver contentResolver);

    private final void e() {
    }

    private final void f() {
    }
}
