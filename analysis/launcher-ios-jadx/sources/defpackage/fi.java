package defpackage;

import android.util.Property;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class fi extends Property {
    public static final fi a = new fi(Float.class, "childrenAlpha");

    @Override // android.util.Property
    public final Object get(Object obj) {
        Float f = (Float) ((ViewGroup) obj).getTag(u51.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        Float f = (Float) obj2;
        float fFloatValue = f.floatValue();
        viewGroup.setTag(u51.mtrl_internal_children_alpha_tag, f);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(fFloatValue);
        }
    }
}
