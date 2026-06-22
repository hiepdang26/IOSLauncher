package defpackage;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public class u3 extends Dialog implements DialogInterface, f6 {
    public q6 g;
    public final r6 h;
    public final s3 i;

    public u3(ContextThemeWrapper contextThemeWrapper, int i) {
        int i2;
        int iC = c(contextThemeWrapper, i);
        if (iC == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(r41.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = iC;
        }
        super(contextThemeWrapper, i2);
        this.h = new r6(this);
        g6 g6VarA = a();
        if (iC == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(r41.dialogTheme, typedValue2, true);
            iC = typedValue2.resourceId;
        }
        ((q6) g6VarA).S = iC;
        g6VarA.b();
        this.i = new s3(getContext(), this, getWindow());
    }

    public static int c(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(r41.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final g6 a() {
        if (this.g == null) {
            g9 g9Var = g6.g;
            this.g = new q6(getContext(), getWindow(), this, this);
        }
        return this.g;
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q6 q6Var = (q6) a();
        q6Var.p();
        ((ViewGroup) q6Var.z.findViewById(R.id.content)).addView(view, layoutParams);
        q6Var.l.g.onContentChanged();
    }

    public final void b(Bundle bundle) {
        q6 q6Var = (q6) a();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(q6Var.j);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(q6Var);
        } else {
            boolean z = layoutInflaterFrom.getFactory2() instanceof q6;
        }
        super.onCreate(bundle);
        a().b();
    }

    public final void d(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().g(charSequence);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        a().c();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return n90.j(this.h, getWindow().getDecorView(), this, keyEvent);
    }

    public final boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        q6 q6Var = (q6) a();
        q6Var.p();
        return q6Var.k.findViewById(i);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        a().a();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0271  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r18) {
        /*
            Method dump skipped, instruction units count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u3.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i.r;
        if (nestedScrollView == null || !nestedScrollView.c(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i.r;
        if (nestedScrollView == null || !nestedScrollView.c(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        q6 q6Var = (q6) a();
        q6Var.t();
        ux1 ux1Var = q6Var.n;
        if (ux1Var != null) {
            ux1Var.P = false;
            bu1 bu1Var = ux1Var.O;
            if (bu1Var != null) {
                bu1Var.a();
            }
        }
    }

    @Override // android.app.Dialog
    public final void setContentView(int i) {
        a().f(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        a().g(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        q6 q6Var = (q6) a();
        q6Var.p();
        ViewGroup viewGroup = (ViewGroup) q6Var.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        q6Var.l.g.onContentChanged();
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        d(charSequence);
        s3 s3Var = this.i;
        s3Var.d = charSequence;
        TextView textView = s3Var.u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        q6 q6Var = (q6) a();
        q6Var.p();
        ViewGroup viewGroup = (ViewGroup) q6Var.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        q6Var.l.g.onContentChanged();
    }
}
