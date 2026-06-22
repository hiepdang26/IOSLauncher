package defpackage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class nq {
    public int a;
    public int b;
    public int c;
    public int d;

    public nq(Cursor cursor) {
        this.a = cursor.getColumnIndexOrThrow("iconType");
        this.d = cursor.getColumnIndexOrThrow("icon");
        this.b = cursor.getColumnIndexOrThrow("iconPackage");
        this.c = cursor.getColumnIndexOrThrow("iconResource");
    }

    public Bitmap a(Cursor cursor, og1 og1Var, Context context) {
        int i = cursor.getInt(this.a);
        int i2 = this.d;
        Bitmap bitmapG = null;
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            Bitmap bitmapE = ar1.e(context, cursor, i2);
            og1Var.y = bitmapE != null;
            return bitmapE;
        }
        String string = cursor.getString(this.b);
        String string2 = cursor.getString(this.c);
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
            Intent.ShortcutIconResource shortcutIconResource = new Intent.ShortcutIconResource();
            og1Var.B = shortcutIconResource;
            shortcutIconResource.packageName = string;
            shortcutIconResource.resourceName = string2;
            bitmapG = ar1.g(context, string, string2);
        }
        return bitmapG == null ? ar1.e(context, cursor, i2) : bitmapG;
    }
}
