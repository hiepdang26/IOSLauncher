package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class y2 {
    public int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public y2(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, wf1 wf1Var, Rect rect) {
        qg0.f(rect.left);
        qg0.f(rect.top);
        qg0.f(rect.right);
        qg0.f(rect.bottom);
        this.b = rect;
        this.c = colorStateList2;
        this.d = colorStateList;
        this.e = colorStateList3;
        this.a = i;
        this.f = wf1Var;
    }

    public static y2 d(Context context, int i) {
        qg0.e("Cannot create a CalendarItemStyle with a styleResId of 0", i != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, f71.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(f71.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(f71.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(f71.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(f71.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListL = np1.l(context, typedArrayObtainStyledAttributes, f71.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListL2 = np1.l(context, typedArrayObtainStyledAttributes, f71.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListL3 = np1.l(context, typedArrayObtainStyledAttributes, f71.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.MaterialCalendarItem_itemStrokeWidth, 0);
        wf1 wf1VarA = wf1.a(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new d(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new y2(colorStateListL, colorStateListL2, colorStateListL3, dimensionPixelSize, wf1VarA, rect);
    }

    public boolean a(int i) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            x2 x2Var = (x2) arrayList.get(i2);
            int i3 = x2Var.a;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = x2Var.b;
                    int i5 = x2Var.d + i4;
                    while (i4 < i5) {
                        if (g(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                } else {
                    continue;
                }
            } else {
                if (g(x2Var.d, i2 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b() {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((nx0) this.e).r((x2) arrayList.get(i));
        }
        l(arrayList);
        this.a = 0;
    }

    public void c() {
        b();
        ArrayList arrayList = (ArrayList) this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            x2 x2Var = (x2) arrayList.get(i);
            int i2 = x2Var.a;
            nx0 nx0Var = (nx0) this.e;
            if (i2 == 1) {
                nx0Var.r(x2Var);
                nx0Var.w(x2Var.b, x2Var.d);
            } else if (i2 == 2) {
                nx0Var.r(x2Var);
                int i3 = x2Var.b;
                int i4 = x2Var.d;
                RecyclerView recyclerView = (RecyclerView) nx0Var.h;
                recyclerView.W(i3, i4, true);
                recyclerView.q0 = true;
                recyclerView.n0.c += i4;
            } else if (i2 == 4) {
                nx0Var.r(x2Var);
                nx0Var.u(x2Var.b, x2Var.d, x2Var.c);
            } else if (i2 == 8) {
                nx0Var.r(x2Var);
                nx0Var.x(x2Var.b, x2Var.d);
            }
        }
        l(arrayList);
        this.a = 0;
    }

    public void e(x2 x2Var) {
        int i;
        int i2 = x2Var.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM = m(x2Var.b, i2);
        int i3 = x2Var.b;
        int i4 = x2Var.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + x2Var);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < x2Var.d; i6++) {
            int iM2 = m((i * i6) + x2Var.b, x2Var.a);
            int i7 = x2Var.a;
            if (i7 == 2 ? iM2 != iM : !(i7 == 4 && iM2 == iM + 1)) {
                x2 x2VarI = i(i7, iM, i5, x2Var.c);
                f(x2VarI, i3);
                x2VarI.c = null;
                ((k21) this.b).c(x2VarI);
                if (x2Var.a == 4) {
                    i3 += i5;
                }
                iM = iM2;
                i5 = 1;
            } else {
                i5++;
            }
        }
        Preference preference = x2Var.c;
        x2Var.c = null;
        ((k21) this.b).c(x2Var);
        if (i5 > 0) {
            x2 x2VarI2 = i(x2Var.a, iM, i5, preference);
            f(x2VarI2, i3);
            x2VarI2.c = null;
            ((k21) this.b).c(x2VarI2);
        }
    }

    public void f(x2 x2Var, int i) {
        nx0 nx0Var = (nx0) this.e;
        nx0Var.r(x2Var);
        int i2 = x2Var.a;
        if (i2 != 2) {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            nx0Var.u(i, x2Var.d, x2Var.c);
        } else {
            int i3 = x2Var.d;
            RecyclerView recyclerView = (RecyclerView) nx0Var.h;
            recyclerView.W(i, i3, true);
            recyclerView.q0 = true;
            recyclerView.n0.c += i3;
        }
    }

    public int g(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        while (i2 < size) {
            x2 x2Var = (x2) arrayList.get(i2);
            int i3 = x2Var.a;
            if (i3 == 8) {
                int i4 = x2Var.b;
                if (i4 == i) {
                    i = x2Var.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (x2Var.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = x2Var.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = x2Var.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += x2Var.d;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean h() {
        return ((ArrayList) this.c).size() > 0;
    }

    public x2 i(int i, int i2, int i3, Preference preference) {
        x2 x2Var = (x2) ((k21) this.b).a();
        if (x2Var != null) {
            x2Var.a = i;
            x2Var.b = i2;
            x2Var.d = i3;
            x2Var.c = preference;
            return x2Var;
        }
        x2 x2Var2 = new x2();
        x2Var2.a = i;
        x2Var2.b = i2;
        x2Var2.d = i3;
        x2Var2.c = preference;
        return x2Var2;
    }

    public void j(x2 x2Var) {
        ((ArrayList) this.d).add(x2Var);
        int i = x2Var.a;
        nx0 nx0Var = (nx0) this.e;
        if (i == 1) {
            nx0Var.w(x2Var.b, x2Var.d);
            return;
        }
        if (i == 2) {
            int i2 = x2Var.b;
            int i3 = x2Var.d;
            RecyclerView recyclerView = (RecyclerView) nx0Var.h;
            recyclerView.W(i2, i3, false);
            recyclerView.q0 = true;
            return;
        }
        if (i == 4) {
            nx0Var.u(x2Var.b, x2Var.d, x2Var.c);
        } else if (i == 8) {
            nx0Var.x(x2Var.b, x2Var.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + x2Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k() {
        /*
            Method dump skipped, instruction units count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y2.k():void");
    }

    public void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            x2 x2Var = (x2) arrayList.get(i);
            x2Var.c = null;
            ((k21) this.b).c(x2Var);
        }
        arrayList.clear();
    }

    public int m(int i, int i2) {
        int i3;
        int i4;
        ArrayList arrayList = (ArrayList) this.d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            x2 x2Var = (x2) arrayList.get(size);
            int i5 = x2Var.a;
            if (i5 == 8) {
                int i6 = x2Var.b;
                int i7 = x2Var.d;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            x2Var.b = i6 + 1;
                            x2Var.d = i7 + 1;
                        } else if (i2 == 2) {
                            x2Var.b = i6 - 1;
                            x2Var.d = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        x2Var.d = i7 + 1;
                    } else if (i2 == 2) {
                        x2Var.d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        x2Var.b = i6 + 1;
                    } else if (i2 == 2) {
                        x2Var.b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = x2Var.b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= x2Var.d;
                    } else if (i5 == 2) {
                        i += x2Var.d;
                    }
                } else if (i2 == 1) {
                    x2Var.b = i8 + 1;
                } else if (i2 == 2) {
                    x2Var.b = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            x2 x2Var2 = (x2) arrayList.get(size2);
            if (x2Var2.a == 8) {
                int i9 = x2Var2.d;
                if (i9 == x2Var2.b || i9 < 0) {
                    arrayList.remove(size2);
                    x2Var2.c = null;
                    ((k21) this.b).c(x2Var2);
                }
            } else if (x2Var2.d <= 0) {
                arrayList.remove(size2);
                x2Var2.c = null;
                ((k21) this.b).c(x2Var2);
            }
        }
        return i;
    }

    public y2(nx0 nx0Var) {
        this.b = new k21(30);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = 0;
        this.e = nx0Var;
        this.f = new ow1(this, 22);
    }
}
