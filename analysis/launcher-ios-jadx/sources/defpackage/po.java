package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class po extends ViewGroup.MarginLayoutParams {
    public mo a;
    public boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public int h;
    public int i;
    public int j;
    public View k;
    public View l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final Rect p;

    public po() {
        super(-2, -2);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }

    public final boolean a(int i) {
        if (i == 0) {
            return this.m;
        }
        if (i != 1) {
            return false;
        }
        return this.n;
    }

    public po(Context context, AttributeSet attributeSet) {
        mo moVar;
        super(context, attributeSet);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k71.CoordinatorLayout_Layout);
        this.c = typedArrayObtainStyledAttributes.getInteger(k71.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(k71.CoordinatorLayout_Layout_layout_anchor, -1);
        this.d = typedArrayObtainStyledAttributes.getInteger(k71.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.e = typedArrayObtainStyledAttributes.getInteger(k71.CoordinatorLayout_Layout_layout_keyline, -1);
        this.g = typedArrayObtainStyledAttributes.getInt(k71.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.h = typedArrayObtainStyledAttributes.getInt(k71.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(k71.CoordinatorLayout_Layout_layout_behavior);
        this.b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(k71.CoordinatorLayout_Layout_layout_behavior);
            String str = CoordinatorLayout.z;
            if (TextUtils.isEmpty(string)) {
                moVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.z;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.B;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.A);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    moVar = (mo) constructor.newInstance(context, attributeSet);
                } catch (Exception e) {
                    throw new RuntimeException("Could not inflate Behavior subclass " + string, e);
                }
            }
            this.a = moVar;
        }
        typedArrayObtainStyledAttributes.recycle();
        mo moVar2 = this.a;
        if (moVar2 != null) {
            moVar2.c(this);
        }
    }

    public po(po poVar) {
        super((ViewGroup.MarginLayoutParams) poVar);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }

    public po(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }

    public po(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }
}
