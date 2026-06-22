package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class w20 implements ib1 {
    public final /* synthetic */ int a;

    public /* synthetic */ w20(int i) {
        this.a = i;
    }

    @Override // defpackage.ib1
    public final eb1 a(Object obj, int i, int i2, g01 g01Var) {
        switch (this.a) {
            case 0:
                return new a5((File) obj);
            case 1:
                return new a5((Bitmap) obj, 3);
            default:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new m80(drawable, 1);
                }
                return null;
        }
    }

    @Override // defpackage.ib1
    public final /* bridge */ /* synthetic */ boolean b(Object obj, g01 g01Var) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }
}
