package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class oi implements ViewGroup.OnHierarchyChangeListener {
    public ViewGroup.OnHierarchyChangeListener g;
    public final /* synthetic */ ChipGroup h;

    public oi(ChipGroup chipGroup) {
        this.h = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.h;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                WeakHashMap weakHashMap = qs1.a;
                view2.setId(View.generateViewId());
            }
            Chip chip = (Chip) view2;
            xh xhVar = chipGroup.n;
            ((HashMap) xhVar.c).put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                xhVar.a(chip);
            }
            chip.setInternalOnCheckedChangeListener(new nx0(xhVar, 7));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.g;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.h;
        if (view == chipGroup && (view2 instanceof Chip)) {
            Chip chip = (Chip) view2;
            xh xhVar = chipGroup.n;
            xhVar.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            ((HashMap) xhVar.c).remove(Integer.valueOf(chip.getId()));
            ((HashSet) xhVar.d).remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.g;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
