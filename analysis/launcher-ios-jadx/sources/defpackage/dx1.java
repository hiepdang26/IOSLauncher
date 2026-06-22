package defpackage;

import android.content.ContentValues;
import android.graphics.Bitmap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class dx1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Bitmap h;
    public final /* synthetic */ ex1 i;

    public /* synthetic */ dx1(ex1 ex1Var, Bitmap bitmap, int i) {
        this.g = i;
        this.i = ex1Var;
        this.h = bitmap;
    }

    private final void a() {
        if (this.i.isCancelled()) {
            synchronized (this.i.g.b) {
                this.i.g.b.add(this.h);
            }
            return;
        }
        ex1 ex1Var = this.i;
        gx1 gx1Var = ex1Var.g;
        fx1 fx1Var = ex1Var.a;
        long[] jArr = ex1Var.f;
        Bitmap bitmap = this.h;
        gx1Var.getClass();
        Objects.toString(fx1Var);
        Objects.toString(bitmap);
        ContentValues contentValues = new ContentValues();
        contentValues.put("componentName", fx1Var.a.flattenToShortString());
        contentValues.put("profileId", Long.valueOf(gx1Var.e.o(fx1Var.b)));
        contentValues.put("size", fx1Var.d);
        contentValues.put("packageName", fx1Var.a.getPackageName());
        contentValues.put("version", Long.valueOf(jArr[0]));
        contentValues.put("lastUpdated", Long.valueOf(jArr[1]));
        contentValues.put("preview_bitmap", ar1.n(bitmap));
        gx1Var.g.e(contentValues);
        this.i.getClass();
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                a();
                return;
            default:
                synchronized (this.i.g.b) {
                    this.i.g.b.add(this.h);
                    break;
                }
                return;
        }
    }
}
