package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a60 implements LayoutInflater.Factory2 {
    public final h60 g;

    public a60(h60 h60Var) {
        this.g = h60Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        a aVarF;
        View view2;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        h60 h60Var = this.g;
        if (zEquals) {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(context, attributeSet);
            fragmentContainerView.j = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n71.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(n71.FragmentContainerView_android_name);
            }
            String string = typedArrayObtainStyledAttributes.getString(n71.FragmentContainerView_android_tag);
            typedArrayObtainStyledAttributes.recycle();
            int id = fragmentContainerView.getId();
            w50 w50VarZ = h60Var.z(id);
            if (classAttribute != null && w50VarZ == null) {
                if (id <= 0) {
                    throw new IllegalStateException(uo.t("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                }
                c60 c60VarC = h60Var.C();
                context.getClassLoader();
                w50 w50VarA = c60VarC.a(classAttribute);
                w50VarA.J = true;
                x50 x50Var = w50VarA.z;
                if ((x50Var == null ? null : x50Var.B) != null) {
                    w50VarA.J = true;
                }
                ca caVar = new ca(h60Var);
                caVar.p = true;
                w50VarA.K = fragmentContainerView;
                caVar.e(fragmentContainerView.getId(), w50VarA, string, 1);
                if (caVar.g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                caVar.h = false;
                h60 h60Var2 = caVar.q;
                if (h60Var2.p != null && !h60Var2.C) {
                    h60Var2.w(true);
                    caVar.a(h60Var2.E, h60Var2.F);
                    h60Var2.b = true;
                    try {
                        h60Var2.N(h60Var2.E, h60Var2.F);
                        h60Var2.d();
                        h60Var2.W();
                        h60Var2.t();
                        ((HashMap) h60Var2.c.i).values().removeAll(Collections.singleton(null));
                    } catch (Throwable th) {
                        h60Var2.d();
                        throw th;
                    }
                }
            }
            ArrayList arrayListS = h60Var.c.s();
            int size = arrayListS.size();
            while (id < size) {
                Object obj = arrayListS.get(id);
                id++;
                a aVar = (a) obj;
                w50 w50Var = aVar.c;
                if (w50Var.D == fragmentContainerView.getId() && (view2 = w50Var.L) != null && view2.getParent() == null) {
                    w50Var.K = fragmentContainerView;
                    aVar.b();
                }
            }
            return fragmentContainerView;
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, n71.Fragment);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes2.getString(n71.Fragment_android_name);
            }
            int resourceId = typedArrayObtainStyledAttributes2.getResourceId(n71.Fragment_android_id, -1);
            String string2 = typedArrayObtainStyledAttributes2.getString(n71.Fragment_android_tag);
            typedArrayObtainStyledAttributes2.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = w50.class.isAssignableFrom(c60.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string2 == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    w50 w50VarZ2 = resourceId != -1 ? h60Var.z(resourceId) : null;
                    if (w50VarZ2 == null && string2 != null) {
                        w50VarZ2 = h60Var.A(string2);
                    }
                    if (w50VarZ2 == null && id != -1) {
                        w50VarZ2 = h60Var.z(id);
                    }
                    if (w50VarZ2 == null) {
                        c60 c60VarC2 = h60Var.C();
                        context.getClassLoader();
                        w50VarZ2 = c60VarC2.a(attributeValue);
                        w50VarZ2.t = true;
                        w50VarZ2.C = resourceId != 0 ? resourceId : id;
                        w50VarZ2.D = id;
                        w50VarZ2.E = string2;
                        w50VarZ2.u = true;
                        w50VarZ2.y = h60Var;
                        x50 x50Var2 = h60Var.p;
                        w50VarZ2.z = x50Var2;
                        e6 e6Var = x50Var2.C;
                        w50VarZ2.J = true;
                        if ((x50Var2 != null ? x50Var2.B : null) != null) {
                            w50VarZ2.J = true;
                        }
                        aVarF = h60Var.a(w50VarZ2);
                        if (h60.E(2)) {
                            w50VarZ2.toString();
                            Integer.toHexString(resourceId);
                        }
                    } else {
                        if (w50VarZ2.u) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        w50VarZ2.u = true;
                        w50VarZ2.y = h60Var;
                        x50 x50Var3 = h60Var.p;
                        w50VarZ2.z = x50Var3;
                        e6 e6Var2 = x50Var3.C;
                        w50VarZ2.J = true;
                        if ((x50Var3 != null ? x50Var3.B : null) != null) {
                            w50VarZ2.J = true;
                        }
                        aVarF = h60Var.f(w50VarZ2);
                        if (h60.E(2)) {
                            w50VarZ2.toString();
                            Integer.toHexString(resourceId);
                        }
                    }
                    w50VarZ2.K = (ViewGroup) view;
                    aVarF.k();
                    aVarF.j();
                    View view3 = w50VarZ2.L;
                    if (view3 == null) {
                        throw new IllegalStateException(uo.t("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view3.setId(resourceId);
                    }
                    if (w50VarZ2.L.getTag() == null) {
                        w50VarZ2.L.setTag(string2);
                    }
                    w50VarZ2.L.addOnAttachStateChangeListener(new z50(this, aVarF));
                    return w50VarZ2.L;
                }
            }
        }
        return null;
    }
}
