package defpackage;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ii extends c20 {
    public final /* synthetic */ Chip w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii(Chip chip, Chip chip2) {
        super(chip2);
        this.w = chip;
    }

    @Override // defpackage.c20
    public final int m(float f, float f2) {
        int i = Chip.z;
        Chip chip = this.w;
        return (chip.d() && chip.getCloseIconTouchBounds().contains(f, f2)) ? 1 : 0;
    }

    @Override // defpackage.c20
    public final void n(ArrayList arrayList) {
        boolean z = false;
        arrayList.add(0);
        int i = Chip.z;
        Chip chip = this.w;
        if (chip.d()) {
            ki kiVar = chip.g;
            if (kiVar != null && kiVar.Q) {
                z = true;
            }
            if (!z || chip.j == null) {
                return;
            }
            arrayList.add(1);
        }
    }

    @Override // defpackage.c20
    public final boolean q(int i, int i2) {
        boolean z = false;
        if (i2 == 16) {
            Chip chip = this.w;
            if (i == 0) {
                return chip.performClick();
            }
            if (i == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.j;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z = true;
                }
                if (chip.v) {
                    chip.u.w(1, 1);
                }
            }
        }
        return z;
    }

    @Override // defpackage.c20
    public final void s(r0 r0Var) {
        Chip chip = this.w;
        ki kiVar = chip.g;
        boolean z = kiVar != null && kiVar.W;
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        accessibilityNodeInfo.setCheckable(z);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        r0Var.i(chip.getAccessibilityClassName());
        CharSequence text = chip.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            r0Var.m(text);
        } else {
            r0Var.k(text);
        }
    }

    @Override // defpackage.c20
    public final void t(int i, r0 r0Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        if (i != 1) {
            r0Var.k("");
            accessibilityNodeInfo.setBoundsInParent(Chip.A);
            return;
        }
        Chip chip = this.w;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            r0Var.k(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            r0Var.k(chip.getContext().getString(v61.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        r0Var.b(n0.g);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }

    @Override // defpackage.c20
    public final void u(int i, boolean z) {
        if (i == 1) {
            Chip chip = this.w;
            chip.p = z;
            chip.refreshDrawableState();
        }
    }
}
