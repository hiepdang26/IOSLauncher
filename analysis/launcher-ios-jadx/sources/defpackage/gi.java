package defpackage;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes.dex */
public final class gi extends n90 {
    public final /* synthetic */ int m;
    public final /* synthetic */ Object n;

    public /* synthetic */ gi(Object obj, int i) {
        this.m = i;
        this.n = obj;
    }

    @Override // defpackage.n90
    public final void A(int i) {
        switch (this.m) {
            case 0:
                break;
            default:
                en1 en1Var = (en1) this.n;
                en1Var.d = true;
                dn1 dn1Var = (dn1) en1Var.e.get();
                if (dn1Var != null) {
                    dn1Var.a();
                }
                break;
        }
    }

    @Override // defpackage.n90
    public final void B(Typeface typeface, boolean z) {
        switch (this.m) {
            case 0:
                Chip chip = (Chip) this.n;
                ki kiVar = chip.g;
                chip.setText(kiVar.I0 ? kiVar.K : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z) {
                    en1 en1Var = (en1) this.n;
                    en1Var.d = true;
                    dn1 dn1Var = (dn1) en1Var.e.get();
                    if (dn1Var != null) {
                        dn1Var.a();
                    }
                    break;
                }
                break;
        }
    }

    private final void I(int i) {
    }
}
