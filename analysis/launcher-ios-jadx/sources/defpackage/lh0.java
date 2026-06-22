package defpackage;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public final class lh0 extends bf1 {
    public static final boolean G = true;
    public static final ReferenceQueue H = new ReferenceQueue();
    public static final ss1 I = new ss1(0);
    public final l5 A;
    public final Handler B;
    public final TextViewCustomFont C;
    public final TextViewCustomFont D;
    public ac E;
    public long F;
    public final fl0 v = new fl0(this, 16);
    public boolean w = false;
    public final View x;
    public boolean y;
    public final Choreographer z;

    public lh0(View view, TextViewCustomFont textViewCustomFont, TextViewCustomFont textViewCustomFont2) {
        this.x = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        this.z = Choreographer.getInstance();
        this.A = new l5(this, 2);
        this.C = textViewCustomFont;
        this.D = textViewCustomFont2;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void G(android.view.View r5, java.lang.Object[] r6, boolean r7) {
        /*
            r0 = 0
            if (r5 == 0) goto Lc
            int r1 = defpackage.a61.dataBinding
            java.lang.Object r1 = r5.getTag(r1)
            lh0 r1 = (defpackage.lh0) r1
            goto Ld
        Lc:
            r1 = r0
        Ld:
            if (r1 == 0) goto L11
            goto La5
        L11:
            java.lang.Object r1 = r5.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L1c
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L1c:
            r1 = 0
            if (r7 == 0) goto L65
            if (r0 == 0) goto L65
            java.lang.String r7 = "layout"
            boolean r7 = r0.startsWith(r7)
            if (r7 == 0) goto L65
            r7 = 95
            int r7 = r0.lastIndexOf(r7)
            if (r7 <= 0) goto L8b
            int r7 = r7 + 1
            int r2 = r0.length()
            if (r2 != r7) goto L3a
            goto L8b
        L3a:
            r3 = r7
        L3b:
            if (r3 >= r2) goto L4b
            char r4 = r0.charAt(r3)
            boolean r4 = java.lang.Character.isDigit(r4)
            if (r4 != 0) goto L48
            goto L8b
        L48:
            int r3 = r3 + 1
            goto L3b
        L4b:
            int r2 = r0.length()
            r3 = 0
        L50:
            if (r7 >= r2) goto L5e
            int r3 = r3 * 10
            char r4 = r0.charAt(r7)
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            int r7 = r7 + 1
            goto L50
        L5e:
            r7 = r6[r3]
            if (r7 != 0) goto L8e
            r6[r3] = r5
            goto L8e
        L65:
            if (r0 == 0) goto L8b
            java.lang.String r7 = "binding_"
            boolean r7 = r0.startsWith(r7)
            if (r7 == 0) goto L8b
            int r7 = r0.length()
            r2 = 8
            r3 = 0
        L76:
            if (r2 >= r7) goto L84
            int r3 = r3 * 10
            char r4 = r0.charAt(r2)
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            int r2 = r2 + 1
            goto L76
        L84:
            r7 = r6[r3]
            if (r7 != 0) goto L8e
            r6[r3] = r5
            goto L8e
        L8b:
            r5.getId()
        L8e:
            boolean r7 = r5 instanceof android.view.ViewGroup
            if (r7 == 0) goto La5
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            int r7 = r5.getChildCount()
            r0 = 0
        L99:
            if (r0 >= r7) goto La5
            android.view.View r2 = r5.getChildAt(r0)
            G(r2, r6, r1)
            int r0 = r0 + 1
            goto L99
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lh0.G(android.view.View, java.lang.Object[], boolean):void");
    }

    public final void E() {
        long j;
        Drawable drawable;
        String str;
        String str2;
        Drawable drawable2;
        synchronized (this) {
            j = this.F;
            this.F = 0L;
        }
        ac acVar = this.E;
        long j2 = j & 3;
        if (j2 == 0 || acVar == null) {
            drawable = null;
            str = null;
            str2 = null;
            drawable2 = null;
        } else {
            drawable = acVar.d;
            str = acVar.c;
            str2 = acVar.b;
            drawable2 = acVar.a;
        }
        if (j2 != 0) {
            TextViewCustomFont textViewCustomFont = this.C;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            }
            Drawable[] compoundDrawablesRelative = textViewCustomFont.getCompoundDrawablesRelative();
            textViewCustomFont.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            hg0.B(this.C, str2);
            TextViewCustomFont textViewCustomFont2 = this.D;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            Drawable[] compoundDrawablesRelative2 = textViewCustomFont2.getCompoundDrawablesRelative();
            textViewCustomFont2.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], drawable, compoundDrawablesRelative2[3]);
            hg0.B(this.D, str);
        }
    }

    public final void F() {
        if (this.y) {
            H();
            return;
        }
        synchronized (this) {
            if (this.F != 0) {
                this.y = true;
                E();
                this.y = false;
            }
        }
    }

    public final void H() {
        synchronized (this) {
            try {
                if (this.w) {
                    return;
                }
                this.w = true;
                if (G) {
                    this.z.postFrameCallback(this.A);
                } else {
                    this.B.post(this.v);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
