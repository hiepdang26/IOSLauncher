package defpackage;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class jh extends Property {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ jh(Class cls, String str, int i) {
        super(cls, str);
        this.a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return Float.valueOf(pu1.a.E((View) obj));
            default:
                WeakHashMap weakHashMap = qs1.a;
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                mh mhVar = (mh) obj;
                PointF pointF = (PointF) obj2;
                mhVar.getClass();
                mhVar.a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                mhVar.b = iRound;
                int i = mhVar.f + 1;
                mhVar.f = i;
                if (i == mhVar.g) {
                    pu1.a(mhVar.e, mhVar.a, iRound, mhVar.c, mhVar.d);
                    mhVar.f = 0;
                    mhVar.g = 0;
                }
                break;
            case 1:
                mh mhVar2 = (mh) obj;
                PointF pointF2 = (PointF) obj2;
                mhVar2.getClass();
                mhVar2.c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                mhVar2.d = iRound2;
                int i2 = mhVar2.g + 1;
                mhVar2.g = i2;
                if (mhVar2.f == i2) {
                    pu1.a(mhVar2.e, mhVar2.a, mhVar2.b, mhVar2.c, iRound2);
                    mhVar2.f = 0;
                    mhVar2.g = 0;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                pu1.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                pu1.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 4:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                pu1.a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case 5:
                float fFloatValue = ((Float) obj2).floatValue();
                pu1.a.F((View) obj, fFloatValue);
                break;
            default:
                WeakHashMap weakHashMap = qs1.a;
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
