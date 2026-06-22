package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class xq0 extends AppCompatAutoCompleteTextView {
    public final ListPopupWindow g;
    public final AccessibilityManager h;
    public final Rect i;
    public final int j;

    /* JADX WARN: Illegal instructions before constructor call */
    public xq0(Context context, AttributeSet attributeSet) {
        int i = q41.autoCompleteTextViewStyle;
        super(tr0.a(context, attributeSet, i, 0), attributeSet, i);
        this.i = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = mn1.d(context2, attributeSet, f71.MaterialAutoCompleteTextView, i, b71.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayD.hasValue(f71.MaterialAutoCompleteTextView_android_inputType) && typedArrayD.getInt(f71.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.j = typedArrayD.getResourceId(f71.MaterialAutoCompleteTextView_simpleItemLayout, l61.mtrl_auto_complete_simple_item);
        this.h = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.g = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new wq0(this));
        if (typedArrayD.hasValue(f71.MaterialAutoCompleteTextView_simpleItems)) {
            setSimpleItems(typedArrayD.getResourceId(f71.MaterialAutoCompleteTextView_simpleItems, 0));
        }
        typedArrayD.recycle();
    }

    public static void a(xq0 xq0Var, Object obj) {
        xq0Var.setText(xq0Var.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.K) ? super.getHint() : textInputLayoutB.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.K && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutB = b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutB != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                ListPopupWindow listPopupWindow = this.g;
                int iMin = Math.min(adapter.getCount(), Math.max(0, listPopupWindow.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutB);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = listPopupWindow.getBackground();
                if (background != null) {
                    Rect rect = this.i;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutB.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.g.setAdapter(getAdapter());
    }

    public void setSimpleItems(int i) {
        setSimpleItems(getResources().getStringArray(i));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.h;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.g.show();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.j, strArr));
    }
}
