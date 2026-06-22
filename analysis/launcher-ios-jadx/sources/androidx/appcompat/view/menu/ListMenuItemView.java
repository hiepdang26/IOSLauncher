package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.TintTypedArray;
import defpackage.mt0;
import defpackage.n61;
import defpackage.q71;
import defpackage.qs1;
import defpackage.r41;
import defpackage.w51;
import defpackage.xt0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements xt0, AbsListView.SelectionBoundsAdjuster {
    public mt0 g;
    public ImageView h;
    public RadioButton i;
    public TextView j;
    public CheckBox k;
    public TextView l;
    public ImageView m;
    public ImageView n;
    public LinearLayout o;
    public final Drawable p;
    public final int q;
    public final Context r;
    public boolean s;
    public final Drawable t;
    public final boolean u;
    public LayoutInflater v;
    public boolean w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = r41.listMenuViewStyle;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, q71.MenuView, i, 0);
        this.p = tintTypedArrayObtainStyledAttributes.getDrawable(q71.MenuView_android_itemBackground);
        this.q = tintTypedArrayObtainStyledAttributes.getResourceId(q71.MenuView_android_itemTextAppearance, -1);
        this.s = tintTypedArrayObtainStyledAttributes.getBoolean(q71.MenuView_preserveIconSpacing, false);
        this.r = context;
        this.t = tintTypedArrayObtainStyledAttributes.getDrawable(q71.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, r41.dropDownListViewStyle, 0);
        this.u = typedArrayObtainStyledAttributes.hasValue(0);
        tintTypedArrayObtainStyledAttributes.recycle();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.v == null) {
            this.v = LayoutInflater.from(getContext());
        }
        return this.v;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    @Override // defpackage.xt0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.mt0 r11) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.a(mt0):void");
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.n;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        rect.top = this.n.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // defpackage.xt0
    public mt0 getItemData() {
        return this.g;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = qs1.a;
        setBackground(this.p);
        TextView textView = (TextView) findViewById(w51.title);
        this.j = textView;
        int i = this.q;
        if (i != -1) {
            textView.setTextAppearance(this.r, i);
        }
        this.l = (TextView) findViewById(w51.shortcut);
        ImageView imageView = (ImageView) findViewById(w51.submenuarrow);
        this.m = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.t);
        }
        this.n = (ImageView) findViewById(w51.group_divider);
        this.o = (LinearLayout) findViewById(w51.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.h != null && this.s) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.i == null && this.k == null) {
            return;
        }
        if ((this.g.D & 4) != 0) {
            if (this.i == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(n61.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.i = radioButton;
                LinearLayout linearLayout = this.o;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.i;
            view = this.k;
        } else {
            if (this.k == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(n61.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.k = checkBox;
                LinearLayout linearLayout2 = this.o;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.k;
            view = this.i;
        }
        if (z) {
            compoundButton.setChecked(this.g.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.k;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.i;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.g.D & 4) != 0) {
            if (this.i == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(n61.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.i = radioButton;
                LinearLayout linearLayout = this.o;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.i;
        } else {
            if (this.k == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(n61.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.k = checkBox;
                LinearLayout linearLayout2 = this.o;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.k;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.w = z;
        this.s = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility((this.u || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.g.t.getClass();
        boolean z = this.w;
        if (z || this.s) {
            ImageView imageView = this.h;
            if (imageView == null && drawable == null && !this.s) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(n61.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.h = imageView2;
                LinearLayout linearLayout = this.o;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.s) {
                this.h.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.h;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.h.getVisibility() != 0) {
                this.h.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.j.getVisibility() != 8) {
                this.j.setVisibility(8);
            }
        } else {
            this.j.setText(charSequence);
            if (this.j.getVisibility() != 0) {
                this.j.setVisibility(0);
            }
        }
    }
}
