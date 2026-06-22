package defpackage;

import android.graphics.drawable.Drawable;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class cr extends c00 {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cr(TextInputLayout textInputLayout, int i, int i2) {
        super(textInputLayout, i);
        this.e = i2;
    }

    @Override // defpackage.c00
    public final void a() {
        switch (this.e) {
            case 0:
                int i = this.d;
                TextInputLayout textInputLayout = this.a;
                textInputLayout.setEndIconDrawable(i);
                textInputLayout.setEndIconOnClickListener(null);
                textInputLayout.setEndIconOnLongClickListener(null);
                break;
            default:
                TextInputLayout textInputLayout2 = this.a;
                textInputLayout2.setEndIconOnClickListener(null);
                textInputLayout2.setEndIconDrawable((Drawable) null);
                textInputLayout2.setEndIconContentDescription((CharSequence) null);
                break;
        }
    }
}
