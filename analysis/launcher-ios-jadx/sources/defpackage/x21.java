package defpackage;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.preference.DialogPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

/* JADX INFO: loaded from: classes.dex */
public abstract class x21 extends ev implements DialogInterface.OnClickListener {
    public DialogPreference n0;
    public CharSequence o0;
    public CharSequence p0;
    public CharSequence q0;
    public CharSequence r0;
    public int s0;
    public BitmapDrawable t0;
    public int u0;

    @Override // defpackage.ev, defpackage.w50
    public void G(Bundle bundle) {
        super.G(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.o0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.p0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.q0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.r0);
        bundle.putInt("PreferenceDialogFragment.layout", this.s0);
        BitmapDrawable bitmapDrawable = this.t0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // defpackage.ev
    public final Dialog U() {
        this.u0 = -2;
        t3 t3Var = new t3(N());
        CharSequence charSequence = this.o0;
        p3 p3Var = (p3) t3Var.h;
        p3Var.d = charSequence;
        p3Var.c = this.t0;
        p3Var.g = this.p0;
        p3Var.h = this;
        p3Var.i = this.q0;
        p3Var.j = this;
        N();
        int i = this.s0;
        View viewInflate = null;
        if (i != 0) {
            LayoutInflater layoutInflaterD = this.Q;
            if (layoutInflaterD == null) {
                layoutInflaterD = D(null);
                this.Q = layoutInflaterD;
            }
            viewInflate = layoutInflaterD.inflate(i, (ViewGroup) null);
        }
        if (viewInflate != null) {
            W(viewInflate);
            p3Var.t = viewInflate;
        } else {
            p3Var.f = this.r0;
        }
        Y(t3Var);
        u3 u3VarD = t3Var.d();
        if (this instanceof oy) {
            Window window = u3VarD.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                w21.a(window);
                return u3VarD;
            }
            oy oyVar = (oy) this;
            oyVar.y0 = SystemClock.currentThreadTimeMillis();
            oyVar.Z();
        }
        return u3VarD;
    }

    public final DialogPreference V() {
        PreferenceScreen preferenceScreen;
        if (this.n0 == null) {
            Bundle bundle = this.m;
            if (bundle == null) {
                throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
            }
            String string = bundle.getString("key");
            e31 e31Var = ((z21) u()).a0;
            Preference preferenceW = null;
            if (e31Var != null && (preferenceScreen = e31Var.g) != null) {
                preferenceW = preferenceScreen.w(string);
            }
            this.n0 = (DialogPreference) preferenceW;
        }
        return this.n0;
    }

    public void W(View view) {
        int i;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.r0;
            if (TextUtils.isEmpty(charSequence)) {
                i = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i = 0;
            }
            if (viewFindViewById.getVisibility() != i) {
                viewFindViewById.setVisibility(i);
            }
        }
    }

    public abstract void X(boolean z);

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.u0 = i;
    }

    @Override // defpackage.ev, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        X(this.u0 == -1);
    }

    @Override // defpackage.ev, defpackage.w50
    public void y(Bundle bundle) {
        PreferenceScreen preferenceScreen;
        super.y(bundle);
        w50 w50VarU = u();
        if (!(w50VarU instanceof z21)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        z21 z21Var = (z21) w50VarU;
        Bundle bundle2 = this.m;
        if (bundle2 == null) {
            throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
        }
        String string = bundle2.getString("key");
        if (bundle != null) {
            this.o0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.p0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.q0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.r0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.s0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.t0 = new BitmapDrawable(s(), bitmap);
                return;
            }
            return;
        }
        e31 e31Var = z21Var.a0;
        Preference preferenceW = null;
        if (e31Var != null && (preferenceScreen = e31Var.g) != null) {
            preferenceW = preferenceScreen.w(string);
        }
        DialogPreference dialogPreference = (DialogPreference) preferenceW;
        this.n0 = dialogPreference;
        this.o0 = dialogPreference.S;
        this.p0 = dialogPreference.V;
        this.q0 = dialogPreference.W;
        this.r0 = dialogPreference.T;
        this.s0 = dialogPreference.X;
        Drawable drawable = dialogPreference.U;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            this.t0 = (BitmapDrawable) drawable;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.t0 = new BitmapDrawable(s(), bitmapCreateBitmap);
    }

    public void Y(t3 t3Var) {
    }
}
