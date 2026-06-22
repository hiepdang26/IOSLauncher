package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import defpackage.qs1;
import defpackage.w51;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void forceUniformWidth(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3b
            android.view.View r3 = r9.getChildAt(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r1 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r1
            int r2 = r1.width
            r5 = -1
            if (r2 != r5) goto L36
            int r8 = r1.height
            int r2 = r3.getMeasuredHeight()
            r1.height = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r6 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.height = r8
            goto L37
        L36:
            r6 = r11
        L37:
            int r0 = r0 + 1
            r11 = r6
            goto Lb
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.forceUniformWidth(int, int):void");
    }

    private static int resolveMinimumHeight(View view) {
        WeakHashMap weakHashMap = qs1.a;
        int minimumHeight = view.getMinimumHeight();
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private boolean tryOnMeasure(int i, int i2) {
        int iCombineMeasuredStates;
        int iResolveMinimumHeight;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == w51.topPanel) {
                    view = childAt;
                } else if (id == w51.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != w51.contentPanel && id != w51.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i, 0);
            paddingBottom += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            iResolveMinimumHeight = resolveMinimumHeight(view2);
            measuredHeight = view2.getMeasuredHeight() - iResolveMinimumHeight;
            paddingBottom += iResolveMinimumHeight;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iResolveMinimumHeight = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingBottom += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i4 = size - paddingBottom;
        if (view2 != null) {
            int i5 = paddingBottom - iResolveMinimumHeight;
            int iMin = Math.min(i4, measuredHeight);
            if (iMin > 0) {
                i4 -= iMin;
                iResolveMinimumHeight += iMin;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(iResolveMinimumHeight, 1073741824));
            paddingBottom = i5 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i4 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i4, mode));
            paddingBottom = (paddingBottom - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + iMax, i, iCombineMeasuredStates), View.resolveSizeAndState(paddingBottom, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r6 = 1
            int r7 = r0.getPaddingLeft()
            int r1 = r21 - r19
            int r2 = r0.getPaddingRight()
            int r8 = r1 - r2
            int r1 = r1 - r7
            int r2 = r0.getPaddingRight()
            int r9 = r1 - r2
            int r1 = r0.getMeasuredHeight()
            int r10 = r0.getChildCount()
            int r2 = r0.getGravity()
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r2 & r4
            r2 = 16
            if (r3 == r2) goto L41
            r2 = 80
            if (r3 == r2) goto L36
            int r1 = r0.getPaddingTop()
            goto L4c
        L36:
            int r2 = r0.getPaddingTop()
            int r2 = r2 + r22
            int r2 = r2 - r20
            int r1 = r2 - r1
            goto L4c
        L41:
            int r2 = r0.getPaddingTop()
            int r3 = r22 - r20
            int r3 = r3 - r1
            int r3 = r3 / 2
            int r1 = r3 + r2
        L4c:
            android.graphics.drawable.Drawable r2 = r0.getDividerDrawable()
            r3 = 0
            if (r2 != 0) goto L55
            r12 = 0
            goto L5a
        L55:
            int r2 = r2.getIntrinsicHeight()
            r12 = r2
        L5a:
            r13 = 0
        L5b:
            if (r13 >= r10) goto Lc3
            r2 = r1
            android.view.View r1 = r0.getChildAt(r13)
            if (r1 == 0) goto Lbe
            int r3 = r1.getVisibility()
            r4 = 8
            if (r3 == r4) goto Lbe
            int r4 = r1.getMeasuredWidth()
            int r5 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            r14 = r3
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            int r3 = r14.gravity
            if (r3 >= 0) goto L80
            r3 = r11
        L80:
            java.util.WeakHashMap r15 = defpackage.qs1.a
            int r15 = r0.getLayoutDirection()
            int r3 = android.view.Gravity.getAbsoluteGravity(r3, r15)
            r3 = r3 & 7
            if (r3 == r6) goto L9b
            r15 = 5
            if (r3 == r15) goto L95
            int r3 = r14.leftMargin
            int r3 = r3 + r7
            goto La6
        L95:
            int r3 = r8 - r4
            int r15 = r14.rightMargin
        L99:
            int r3 = r3 - r15
            goto La6
        L9b:
            int r3 = r9 - r4
            int r3 = r3 / 2
            int r3 = r3 + r7
            int r15 = r14.leftMargin
            int r3 = r3 + r15
            int r15 = r14.rightMargin
            goto L99
        La6:
            boolean r15 = r0.hasDividerBeforeChildAt(r13)
            if (r15 == 0) goto Lad
            int r2 = r2 + r12
        Lad:
            int r15 = r14.topMargin
            int r2 = r2 + r15
            r16 = r3
            r3 = r2
            r2 = r16
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r5 = r5 + r0
            int r5 = r5 + r3
            r1 = r5
            goto Lbf
        Lbe:
            r1 = r2
        Lbf:
            int r13 = r13 + r6
            r0 = r17
            goto L5b
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (tryOnMeasure(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
