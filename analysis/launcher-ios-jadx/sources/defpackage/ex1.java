package defpackage;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ex1 extends AsyncTask {
    public final fx1 a;
    public final Parcelable b;
    public final int c;
    public final int d;
    public final zw1 e;
    public long[] f;
    public final /* synthetic */ gx1 g;

    public ex1(gx1 gx1Var, fx1 fx1Var, Parcelable parcelable, int i, int i2, zw1 zw1Var) {
        this.g = gx1Var;
        this.a = fx1Var;
        this.b = parcelable;
        this.c = i2;
        this.d = i;
        this.e = zw1Var;
        String.format("%s, %s, %d, %d", fx1Var, parcelable, Integer.valueOf(i2), Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b1 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ex1.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public final void onCancelled(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.toString(bitmap);
        if (bitmap != null) {
            this.g.j.post(new dx1(this, bitmap, 1));
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.toString(bitmap);
        zw1 zw1Var = this.e;
        zw1Var.getClass();
        Objects.toString(bitmap);
        if (bitmap != null) {
            zw1Var.j.setBitmap(bitmap);
            zw1Var.j.setAlpha(0.0f);
            zw1Var.j.animate().alpha(1.0f).setDuration(90L);
        }
        if (this.f != null) {
            this.g.j.post(new dx1(this, bitmap, 0));
        }
    }
}
