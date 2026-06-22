package defpackage;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class jc implements lb1 {
    public static final e01 h = e01.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");
    public static final e01 i = new e01("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, e01.e);
    public final cq0 g;

    public jc(cq0 cq0Var) {
        this.g = cq0Var;
    }

    @Override // defpackage.zz
    public final boolean f(Object obj, File file, g01 g01Var) throws Throwable {
        boolean z;
        Bitmap bitmap = (Bitmap) ((eb1) obj).get();
        e01 e01Var = i;
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) g01Var.c(e01Var);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        int i2 = tp0.a;
        SystemClock.elapsedRealtimeNanos();
        int iIntValue = ((Integer) g01Var.c(h)).intValue();
        OutputStream meVar = null;
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                cq0 cq0Var = this.g;
                if (cq0Var != null) {
                    try {
                        meVar = new me(fileOutputStream, cq0Var);
                    } catch (IOException unused) {
                        meVar = fileOutputStream;
                        Log.isLoggable("BitmapEncoder", 3);
                        if (meVar != null) {
                            try {
                                meVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z = false;
                    } catch (Throwable th) {
                        th = th;
                        meVar = fileOutputStream;
                        if (meVar != null) {
                            try {
                                meVar.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } else {
                    meVar = fileOutputStream;
                }
                bitmap.compress(compressFormat, iIntValue, meVar);
                meVar.close();
                try {
                    meVar.close();
                } catch (IOException unused4) {
                }
                z = true;
            } catch (IOException unused5) {
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Objects.toString(compressFormat);
                vq1.c(bitmap);
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(g01Var.c(e01Var));
                bitmap.hasAlpha();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // defpackage.lb1
    public final int k(g01 g01Var) {
        return 2;
    }
}
