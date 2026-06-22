package defpackage;

import android.app.WallpaperManager;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcher6.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class fd {
    public final t a;
    public final WallpaperManager b;
    public Bitmap e;
    public Bitmap f;
    public Bitmap g;
    public int h;
    public boolean i;
    public boolean j;
    public final Paint l;
    public final Path m;
    public final int n;
    public final Canvas o;
    public final ad p;
    public final cd q;
    public final ArrayList c = new ArrayList();
    public final DisplayMetrics d = new DisplayMetrics();
    public final cd k = new cd(this, 0);

    public fd(t tVar) {
        this.h = 6;
        new Paint(3);
        this.l = new Paint(1);
        this.m = new Path();
        this.n = 5;
        this.o = new Canvas();
        this.p = new ad(this, 0);
        this.q = new cd(this, 1);
        this.a = tVar;
        try {
            tVar.getResources().getInteger(g61.down_sample_factor);
        } catch (Throwable th) {
            th.getMessage();
        }
        this.n = 8;
        this.b = WallpaperManager.getInstance(tVar);
        this.h = Math.max(3, Math.min(this.h, 20));
    }

    public static int a(fd fdVar, Bitmap bitmap) {
        fdVar.getClass();
        System.currentTimeMillis();
        if (bitmap == null) {
            return -16777216;
        }
        int iRound = Math.round((bitmap.getHeight() * 50.0f) / bitmap.getWidth());
        int i = iRound * 50;
        int[] iArr = new int[i];
        bitmap.copy(Bitmap.Config.ARGB_8888, false).getPixels(iArr, 0, 50, 0, 0, 50, iRound);
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            sparseIntArray.put(i3, sparseIntArray.get(i3) + 1);
        }
        int iKeyAt = 0;
        int iValueAt = 0;
        for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
            if (sparseIntArray.valueAt(i4) > iValueAt) {
                iValueAt = sparseIntArray.valueAt(i4);
                iKeyAt = sparseIntArray.keyAt(i4);
            }
        }
        System.currentTimeMillis();
        return iKeyAt;
    }

    public static Bitmap c(Bitmap bitmap, float f, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iRound = Math.round(width / f);
        int iRound2 = Math.round(height / f);
        try {
            return Bitmap.createScaledBitmap(Toolkit.a.a(i, Bitmap.createScaledBitmap(bitmap, iRound, iRound2, false)), width, height, true);
        } catch (Throwable unused) {
            return bf1.y(i, Bitmap.createScaledBitmap(bitmap, iRound, iRound2, true));
        }
    }

    public final void b(ed edVar) {
        this.c.add(edVar);
        edVar.g();
    }

    public final Bitmap d(String str) {
        try {
            File file = new File(new ContextWrapper(this.a).getDir("image", 0), str);
            if (file.exists()) {
                return BitmapFactory.decodeStream(new FileInputStream(file));
            }
            return null;
        } catch (FileNotFoundException e) {
            e.getMessage();
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public final void e(String str, Bitmap bitmap) {
        Bitmap bitmapCopy;
        if (bitmap == null || bitmap.isRecycled() || (bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false)) == null) {
            return;
        }
        new Thread(new bd(this, str, bitmapCopy, 0)).start();
    }

    public final Bitmap f(Bitmap bitmap) {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        boolean z = ar1.o;
        DisplayMetrics displayMetrics = this.d;
        if (z) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        float width = i > bitmap.getWidth() ? i / bitmap.getWidth() : 0.0f;
        float height = i2 > bitmap.getHeight() ? i2 / bitmap.getHeight() : 0.0f;
        float fMax = Math.max(width, height);
        if (fMax <= 0.0f) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fMax), (int) (bitmap.getHeight() * fMax), false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        if (width > height) {
            canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, (i2 - r5) / 2.0f, paint);
            return bitmapCreateBitmap;
        }
        canvas.drawBitmap(bitmapCreateScaledBitmap, (i - r6) / 2.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }
}
