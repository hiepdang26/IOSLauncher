package defpackage;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class og1 extends qh0 {
    public boolean A;
    public Intent.ShortcutIconResource B;
    public Bitmap C;
    public int E;
    public int F;
    public Intent H;
    public Intent x;
    public boolean y;
    public boolean z;
    public int D = 0;
    public int G = 0;

    public og1() {
        this.h = 1;
    }

    public static og1 f(ek0 ek0Var, Context context) {
        og1 og1Var = new og1();
        og1Var.w = ek0Var.f();
        og1Var.u = ar1.B(ek0Var.e());
        og1Var.v = iy.n(context).j(ek0Var.e(), ek0Var.f());
        og1Var.y = false;
        og1Var.x = v6.h(context, ek0Var, ek0Var.f());
        og1Var.h = 0;
        og1Var.G = v6.g(ek0Var);
        return og1Var;
    }

    @Override // defpackage.qh0
    public final Intent b() {
        return this.x;
    }

    @Override // defpackage.qh0
    public final boolean c() {
        return this.D != 0;
    }

    @Override // defpackage.qh0
    public final void d(Context context, ContentValues contentValues) {
        Bitmap bitmap;
        super.d(context, contentValues);
        CharSequence charSequence = this.u;
        String uri = null;
        contentValues.put("title", charSequence != null ? charSequence.toString() : null);
        Intent intent = this.H;
        if (intent != null) {
            uri = intent.toUri(0);
        } else {
            Intent intent2 = this.x;
            if (intent2 != null) {
                uri = intent2.toUri(0);
            }
        }
        contentValues.put("intent", uri);
        contentValues.put("restored", Integer.valueOf(this.E));
        if (this.y) {
            contentValues.put("iconType", (Integer) 1);
            Bitmap bitmap2 = this.C;
            if (bitmap2 != null) {
                contentValues.put("icon", ar1.n(bitmap2));
                return;
            }
            return;
        }
        if (!this.z && (bitmap = this.C) != null) {
            contentValues.put("icon", ar1.n(bitmap));
        }
        if (this.B != null) {
            contentValues.put("iconType", (Integer) 0);
            contentValues.put("iconPackage", this.B.packageName);
            contentValues.put("iconResource", this.B.resourceName);
        }
    }

    public final ComponentName g() {
        Intent intent = this.H;
        return intent != null ? intent.getComponent() : this.x.getComponent();
    }

    public final boolean h(int i) {
        return (i & this.E) != 0;
    }

    public final void i(oe0 oe0Var) {
        boolean z = this.A && this.i >= 0 && this.q >= 9;
        if (this.h == 0) {
            Intent intent = this.H;
            if (intent == null) {
                intent = this.x;
            }
            oe0Var.v(this, intent, this.w, z);
        }
    }

    @Override // defpackage.qh0
    public final String toString() {
        return "ShortcutInfo(title=" + ((Object) this.u) + "intent=" + this.x + "id=" + this.g + " type=" + this.h + " container=" + this.i + " screen=" + this.j + " cellX=" + this.k + " cellY=" + this.l + " spanX=" + this.m + " spanY=" + this.n + " dropPos=" + Arrays.toString((int[]) null) + " user=" + this.w + ")";
    }
}
