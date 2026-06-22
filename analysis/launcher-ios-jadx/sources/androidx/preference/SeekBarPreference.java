package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import android.widget.TextView;
import defpackage.e61;
import defpackage.g31;
import defpackage.g40;
import defpackage.o41;
import defpackage.o71;
import defpackage.vo0;
import defpackage.ye1;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public SeekBar X;
    public TextView Y;
    public final boolean Z;
    public final boolean a0;
    public final boolean b0;
    public final vo0 c0;
    public final g40 d0;

    /* JADX WARN: Illegal instructions before constructor call */
    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        int i = o41.seekBarPreferenceStyle;
        super(context, attributeSet, i, 0);
        this.c0 = new vo0(this, 2);
        this.d0 = new g40(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o71.SeekBarPreference, i, 0);
        this.T = typedArrayObtainStyledAttributes.getInt(o71.SeekBarPreference_min, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(o71.SeekBarPreference_android_max, 100);
        int i3 = this.T;
        i2 = i2 < i3 ? i3 : i2;
        if (i2 != this.U) {
            this.U = i2;
            g();
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(o71.SeekBarPreference_seekBarIncrement, 0);
        if (i4 != this.V) {
            this.V = Math.min(this.U - this.T, Math.abs(i4));
            g();
        }
        this.Z = typedArrayObtainStyledAttributes.getBoolean(o71.SeekBarPreference_adjustable, true);
        this.a0 = typedArrayObtainStyledAttributes.getBoolean(o71.SeekBarPreference_showSeekBarValue, false);
        this.b0 = typedArrayObtainStyledAttributes.getBoolean(o71.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void k(g31 g31Var) {
        super.k(g31Var);
        g31Var.g.setOnKeyListener(this.d0);
        this.X = (SeekBar) g31Var.v(e61.seekbar);
        TextView textView = (TextView) g31Var.v(e61.seekbar_value);
        this.Y = textView;
        if (this.a0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.Y = null;
        }
        SeekBar seekBar = this.X;
        if (seekBar == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.c0);
        this.X.setMax(this.U - this.T);
        int i = this.V;
        if (i != 0) {
            this.X.setKeyProgressIncrement(i);
        } else {
            this.V = this.X.getKeyProgressIncrement();
        }
        this.X.setProgress(this.S - this.T);
        int i2 = this.S;
        TextView textView2 = this.Y;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i2));
        }
        this.X.setEnabled(f());
    }

    @Override // androidx.preference.Preference
    public final Object n(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public final void o(Parcelable parcelable) {
        if (!parcelable.getClass().equals(ye1.class)) {
            super.o(parcelable);
            return;
        }
        ye1 ye1Var = (ye1) parcelable;
        super.o(ye1Var.getSuperState());
        this.S = ye1Var.g;
        this.T = ye1Var.h;
        this.U = ye1Var.i;
        g();
    }

    @Override // androidx.preference.Preference
    public final Parcelable p() {
        super.p();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.w) {
            return absSavedState;
        }
        ye1 ye1Var = new ye1();
        ye1Var.g = this.S;
        ye1Var.h = this.T;
        ye1Var.i = this.U;
        return ye1Var;
    }

    @Override // androidx.preference.Preference
    public final void q(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (v()) {
            iIntValue = this.h.e().getInt(this.q, iIntValue);
        }
        w(iIntValue, true);
    }

    public final void w(int i, boolean z) {
        int i2 = this.T;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.U;
        if (i > i3) {
            i = i3;
        }
        if (i != this.S) {
            this.S = i;
            TextView textView = this.Y;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
            if (v()) {
                int i4 = ~i;
                if (v()) {
                    i4 = this.h.e().getInt(this.q, i4);
                }
                if (i != i4) {
                    SharedPreferences.Editor editorC = this.h.c();
                    editorC.putInt(this.q, i);
                    if (!this.h.e) {
                        editorC.apply();
                    }
                }
            }
            if (z) {
                g();
            }
        }
    }
}
