package defpackage;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.internal.NavigationMenuItemView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class gw0 extends m81 {
    public final ArrayList j = new ArrayList();
    public mt0 k;
    public boolean l;
    public final /* synthetic */ ow0 m;

    public gw0(ow0 ow0Var) {
        this.m = ow0Var;
        p();
    }

    @Override // defpackage.m81
    public final int c() {
        return this.j.size();
    }

    @Override // defpackage.m81
    public final long d(int i) {
        return i;
    }

    @Override // defpackage.m81
    public final int e(int i) {
        iw0 iw0Var = (iw0) this.j.get(i);
        if (iw0Var instanceof jw0) {
            return 2;
        }
        if (iw0Var instanceof hw0) {
            return 3;
        }
        if (iw0Var instanceof kw0) {
            return ((kw0) iw0Var).a.hasSubMenu() ? 1 : 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        int iE = e(i);
        ArrayList arrayList = this.j;
        ow0 ow0Var = this.m;
        View view = ((nw0) m91Var).g;
        if (iE != 0) {
            if (iE != 1) {
                if (iE != 2) {
                    return;
                }
                jw0 jw0Var = (jw0) arrayList.get(i);
                view.setPadding(ow0Var.x, jw0Var.a, ow0Var.y, jw0Var.b);
                return;
            }
            TextView textView = (TextView) view;
            textView.setText(((kw0) arrayList.get(i)).a.k);
            int i2 = ow0Var.m;
            if (i2 != 0) {
                qg0.K(textView, i2);
            }
            textView.setPadding(ow0Var.z, textView.getPaddingTop(), 0, textView.getPaddingBottom());
            ColorStateList colorStateList = ow0Var.n;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
                return;
            }
            return;
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        navigationMenuItemView.setIconTintList(ow0Var.q);
        int i3 = ow0Var.o;
        if (i3 != 0) {
            navigationMenuItemView.setTextAppearance(i3);
        }
        ColorStateList colorStateList2 = ow0Var.p;
        if (colorStateList2 != null) {
            navigationMenuItemView.setTextColor(colorStateList2);
        }
        Drawable drawable = ow0Var.r;
        Drawable drawableNewDrawable = drawable != null ? drawable.getConstantState().newDrawable() : null;
        WeakHashMap weakHashMap = qs1.a;
        navigationMenuItemView.setBackground(drawableNewDrawable);
        RippleDrawable rippleDrawable = ow0Var.s;
        if (rippleDrawable != null) {
            navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
        }
        kw0 kw0Var = (kw0) arrayList.get(i);
        navigationMenuItemView.setNeedsEmptyIcon(kw0Var.b);
        int i4 = ow0Var.t;
        int i5 = ow0Var.u;
        navigationMenuItemView.setPadding(i4, i5, i4, i5);
        navigationMenuItemView.setIconPadding(ow0Var.v);
        if (ow0Var.A) {
            navigationMenuItemView.setIconSize(ow0Var.w);
        }
        navigationMenuItemView.setMaxLines(ow0Var.C);
        navigationMenuItemView.a(kw0Var.a);
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        ow0 ow0Var = this.m;
        if (i == 0) {
            LayoutInflater layoutInflater = ow0Var.l;
            ew0 ew0Var = ow0Var.G;
            View viewInflate = layoutInflater.inflate(l61.design_navigation_item, viewGroup, false);
            mw0 mw0Var = new mw0(viewInflate);
            viewInflate.setOnClickListener(ew0Var);
            return mw0Var;
        }
        if (i == 1) {
            return new fw0(ow0Var.l.inflate(l61.design_navigation_item_subheader, viewGroup, false));
        }
        if (i == 2) {
            return new fw0(ow0Var.l.inflate(l61.design_navigation_item_separator, viewGroup, false));
        }
        if (i != 3) {
            return null;
        }
        return new fw0(ow0Var.h);
    }

    @Override // defpackage.m81
    public final void n(m91 m91Var) {
        nw0 nw0Var = (nw0) m91Var;
        if (nw0Var instanceof mw0) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) nw0Var.g;
            FrameLayout frameLayout = navigationMenuItemView.q;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.p.setCompoundDrawables(null, null, null, null);
        }
    }

    public final void p() {
        if (this.l) {
            return;
        }
        this.l = true;
        ArrayList arrayList = this.j;
        arrayList.clear();
        arrayList.add(new hw0());
        ow0 ow0Var = this.m;
        int size = ow0Var.i.l().size();
        boolean z = false;
        int i = -1;
        int i2 = 0;
        boolean z2 = false;
        int size2 = 0;
        while (i2 < size) {
            mt0 mt0Var = (mt0) ow0Var.i.l().get(i2);
            if (mt0Var.isChecked()) {
                q(mt0Var);
            }
            if (mt0Var.isCheckable()) {
                mt0Var.f(z);
            }
            if (mt0Var.hasSubMenu()) {
                ik1 ik1Var = mt0Var.u;
                if (ik1Var.hasVisibleItems()) {
                    if (i2 != 0) {
                        arrayList.add(new jw0(ow0Var.E, z ? 1 : 0));
                    }
                    arrayList.add(new kw0(mt0Var));
                    int size3 = ik1Var.l.size();
                    int i3 = 0;
                    boolean z3 = false;
                    while (i3 < size3) {
                        mt0 mt0Var2 = (mt0) ik1Var.getItem(i3);
                        if (mt0Var2.isVisible()) {
                            if (!z3 && mt0Var2.getIcon() != null) {
                                z3 = true;
                            }
                            if (mt0Var2.isCheckable()) {
                                mt0Var2.f(z);
                            }
                            if (mt0Var.isChecked()) {
                                q(mt0Var);
                            }
                            arrayList.add(new kw0(mt0Var2));
                        }
                        i3++;
                        z = false;
                    }
                    if (z3) {
                        int size4 = arrayList.size();
                        for (int size5 = arrayList.size(); size5 < size4; size5++) {
                            ((kw0) arrayList.get(size5)).b = true;
                        }
                    }
                }
            } else {
                int i4 = mt0Var.h;
                if (i4 != i) {
                    size2 = arrayList.size();
                    z2 = mt0Var.getIcon() != null;
                    if (i2 != 0) {
                        size2++;
                        int i5 = ow0Var.E;
                        arrayList.add(new jw0(i5, i5));
                    }
                } else {
                    if (!z2 && mt0Var.getIcon() != null) {
                        int size6 = arrayList.size();
                        for (int i6 = size2; i6 < size6; i6++) {
                            ((kw0) arrayList.get(i6)).b = true;
                        }
                        z2 = true;
                    }
                    kw0 kw0Var = new kw0(mt0Var);
                    kw0Var.b = z2;
                    arrayList.add(kw0Var);
                    i = i4;
                }
                kw0 kw0Var2 = new kw0(mt0Var);
                kw0Var2.b = z2;
                arrayList.add(kw0Var2);
                i = i4;
            }
            i2++;
            z = false;
        }
        this.l = false;
    }

    public final void q(mt0 mt0Var) {
        if (this.k == mt0Var || !mt0Var.isCheckable()) {
            return;
        }
        mt0 mt0Var2 = this.k;
        if (mt0Var2 != null) {
            mt0Var2.setChecked(false);
        }
        this.k = mt0Var;
        mt0Var.setChecked(true);
    }
}
