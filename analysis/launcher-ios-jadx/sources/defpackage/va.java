package defpackage;

import android.content.Context;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;

/* JADX INFO: loaded from: classes.dex */
public abstract class va extends ViewGroup {
    public final o92 g;

    public va(Context context) {
        super(context);
        this.g = new o92(this);
    }

    public final void a(s2 s2Var) {
        hg0.g("#008 Must be called on the main UI thread.");
        zzbbw.zza(getContext());
        if (((Boolean) zzbdq.zzf.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new el0(this, s2Var, 29, false));
                return;
            }
        }
        this.g.b(s2Var.a);
    }

    public j2 getAdListener() {
        return this.g.f;
    }

    public u2 getAdSize() {
        rc2 rc2VarZzg;
        o92 o92Var = this.g;
        o92Var.getClass();
        try {
            v52 v52Var = o92Var.i;
            if (v52Var != null && (rc2VarZzg = v52Var.zzg()) != null) {
                return new u2(rc2VarZzg.k, rc2VarZzg.h, rc2VarZzg.g);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        u2[] u2VarArr = o92Var.g;
        if (u2VarArr != null) {
            return u2VarArr[0];
        }
        return null;
    }

    public String getAdUnitId() {
        v52 v52Var;
        o92 o92Var = this.g;
        if (o92Var.k == null && (v52Var = o92Var.i) != null) {
            try {
                o92Var.k = v52Var.zzr();
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
        return o92Var.k;
    }

    public zy0 getOnPaidEventListener() {
        this.g.getClass();
        return null;
    }

    public wb1 getResponseInfo() {
        v52 v52Var;
        o92 o92Var = this.g;
        o92Var.getClass();
        try {
            v52Var = o92Var.i;
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        u82 u82VarZzk = v52Var != null ? v52Var.zzk() : null;
        if (u82VarZzk != null) {
            return new wb1(u82VarZzk);
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        u2 adSize;
        int measuredHeight;
        int iN;
        int iN2;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException unused) {
                k92.f();
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int i3 = adSize.a;
                if (i3 == -3) {
                    iN = -1;
                } else if (i3 != -1) {
                    ka2 ka2Var = x32.f.a;
                    iN = ka2.n(context, i3);
                } else {
                    iN = context.getResources().getDisplayMetrics().widthPixels;
                }
                int i4 = adSize.b;
                if (i4 == -4 || i4 == -3) {
                    iN2 = -1;
                } else if (i4 != -2) {
                    ka2 ka2Var2 = x32.f.a;
                    iN2 = ka2.n(context, i4);
                } else {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    float f = displayMetrics.heightPixels;
                    float f2 = displayMetrics.density;
                    int i5 = (int) (f / f2);
                    iN2 = (int) ((i5 <= 400 ? 32 : i5 <= 720 ? 50 : 90) * f2);
                }
                measuredHeight = iN2;
                measuredWidth = iN;
            } else {
                measuredHeight = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            measuredHeight = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(measuredHeight, getSuggestedMinimumHeight()), i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(j2 j2Var) {
        o92 o92Var = this.g;
        o92Var.f = j2Var;
        f92 f92Var = o92Var.d;
        synchronized (f92Var.g) {
            f92Var.h = j2Var;
        }
        if (j2Var == 0) {
            this.g.c(null);
            return;
        }
        if (j2Var instanceof b22) {
            this.g.c((b22) j2Var);
        }
        if (j2Var instanceof u6) {
            this.g.e((u6) j2Var);
        }
    }

    public void setAdSize(u2 u2Var) {
        u2[] u2VarArr = {u2Var};
        o92 o92Var = this.g;
        if (o92Var.g != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        o92Var.d(u2VarArr);
    }

    public void setAdUnitId(String str) {
        o92 o92Var = this.g;
        if (o92Var.k != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        o92Var.k = str;
    }

    public void setOnPaidEventListener(zy0 zy0Var) {
        o92 o92Var = this.g;
        o92Var.getClass();
        try {
            v52 v52Var = o92Var.i;
            if (v52Var != null) {
                v52Var.zzP(new qa2());
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
