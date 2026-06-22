package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.luutinhit.launcher6.CellLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class kw extends c20 implements View.OnClickListener {
    public static final int[] A = new int[2];
    public final CellLayout w;
    public final Context x;
    public final dk0 y;
    public final Rect z;

    public kw(CellLayout cellLayout) {
        super(cellLayout);
        this.z = new Rect();
        this.w = cellLayout;
        this.x = cellLayout.getContext();
        this.y = jk0.a().f;
    }

    public abstract int A(int i);

    @Override // defpackage.c20
    public final int m(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            return RtlSpacingHelper.UNDEFINED;
        }
        CellLayout cellLayout = this.w;
        if (f > cellLayout.getMeasuredWidth() || f2 > cellLayout.getMeasuredHeight()) {
            return RtlSpacingHelper.UNDEFINED;
        }
        int[] iArr = A;
        int paddingLeft = cellLayout.getPaddingLeft();
        int paddingTop = cellLayout.getPaddingTop();
        int i = (((int) f) - paddingLeft) / cellLayout.h;
        iArr[0] = i;
        int i2 = (((int) f2) - paddingTop) / cellLayout.i;
        iArr[1] = i2;
        int i3 = cellLayout.l;
        int i4 = cellLayout.m;
        if (i < 0) {
            iArr[0] = 0;
        }
        if (iArr[0] >= i3) {
            iArr[0] = i3 - 1;
        }
        if (i2 < 0) {
            iArr[1] = 0;
        }
        if (iArr[1] >= i4) {
            iArr[1] = i4 - 1;
        }
        return A((cellLayout.getCountX() * iArr[1]) + iArr[0]);
    }

    @Override // defpackage.c20
    public final void n(ArrayList arrayList) {
        CellLayout cellLayout = this.w;
        int countY = cellLayout.getCountY() * cellLayout.getCountX();
        for (int i = 0; i < countY; i++) {
            if (A(i) == i) {
                arrayList.add(Integer.valueOf(i));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q(this.q, 16);
    }

    @Override // defpackage.c20
    public final boolean q(int i, int i2) {
        if (i2 != 16 || i == Integer.MIN_VALUE) {
            return false;
        }
        String strX = x(i);
        this.y.c(this.w, y(i), strX);
        return true;
    }

    @Override // defpackage.c20
    public final void r(int i, AccessibilityEvent accessibilityEvent) {
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        accessibilityEvent.setContentDescription(this.x.getString(w61.action_move_here));
    }

    @Override // defpackage.c20
    public final void t(int i, r0 r0Var) {
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        r0Var.k(z(i));
        Rect rectY = y(i);
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        accessibilityNodeInfo.setBoundsInParent(rectY);
        r0Var.a(16);
        accessibilityNodeInfo.setClickable(true);
        accessibilityNodeInfo.setFocusable(true);
    }

    public abstract String x(int i);

    public final Rect y(int i) {
        CellLayout cellLayout = this.w;
        int countX = i % cellLayout.getCountX();
        int countX2 = i / cellLayout.getCountX();
        qh0 qh0Var = (qh0) this.y.i.c;
        this.w.g(countX, countX2, qh0Var.m, qh0Var.n, this.z);
        return this.z;
    }

    public abstract String z(int i);
}
