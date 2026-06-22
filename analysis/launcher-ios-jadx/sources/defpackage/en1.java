package defpackage;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class en1 {
    public float c;
    public final WeakReference e;
    public zm1 f;
    public final TextPaint a = new TextPaint(1);
    public final gi b = new gi(this, 1);
    public boolean d = true;

    public en1(dn1 dn1Var) {
        this.e = new WeakReference(null);
        this.e = new WeakReference(dn1Var);
    }

    public final float a(String str) {
        if (!this.d) {
            return this.c;
        }
        float fMeasureText = str == null ? 0.0f : this.a.measureText((CharSequence) str, 0, str.length());
        this.c = fMeasureText;
        this.d = false;
        return fMeasureText;
    }

    public final void b(zm1 zm1Var, Context context) {
        if (this.f != zm1Var) {
            this.f = zm1Var;
            if (zm1Var != null) {
                TextPaint textPaint = this.a;
                gi giVar = this.b;
                zm1Var.f(context, textPaint, giVar);
                dn1 dn1Var = (dn1) this.e.get();
                if (dn1Var != null) {
                    textPaint.drawableState = dn1Var.getState();
                }
                zm1Var.e(context, textPaint, giVar);
                this.d = true;
            }
            dn1 dn1Var2 = (dn1) this.e.get();
            if (dn1Var2 != null) {
                dn1Var2.a();
                dn1Var2.onStateChange(dn1Var2.getState());
            }
        }
    }
}
