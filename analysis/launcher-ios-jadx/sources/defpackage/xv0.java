package defpackage;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbfh;

/* JADX INFO: loaded from: classes.dex */
public final class xv0 extends FrameLayout {
    public final FrameLayout g;
    public final zzbfh h;

    public xv0(Context context) {
        zzbfh zzbfhVar;
        super(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        this.g = frameLayout;
        if (isInEditMode()) {
            zzbfhVar = null;
        } else {
            s32 s32Var = x32.f.b;
            Context context2 = frameLayout.getContext();
            s32Var.getClass();
            zzbfhVar = (zzbfh) new l32(s32Var, this, frameLayout, context2).d(context2, false);
        }
        this.h = zzbfhVar;
    }

    public final View a(String str) {
        zzbfh zzbfhVar = this.h;
        if (zzbfhVar == null) {
            return null;
        }
        try {
            he0 he0VarZzb = zzbfhVar.zzb(str);
            if (he0VarZzb != null) {
                return (View) gy0.r(he0VarZzb);
            }
            return null;
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.g);
    }

    public final void b(gs0 gs0Var) {
        zzbfh zzbfhVar = this.h;
        if (zzbfhVar == null) {
            return;
        }
        try {
            if (gs0Var instanceof x92) {
                zzbfhVar.zzdx(((x92) gs0Var).a);
            } else if (gs0Var == null) {
                zzbfhVar.zzdx(null);
            } else {
                k92.d("Use MediaContent provided by NativeAd.getMediaContent");
            }
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.g;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void c(String str, View view) {
        zzbfh zzbfhVar = this.h;
        if (zzbfhVar == null) {
            return;
        }
        try {
            zzbfhVar.zzdv(str, new gy0(view));
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzbfh zzbfhVar = this.h;
        if (zzbfhVar != null) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkE)).booleanValue()) {
                try {
                    zzbfhVar.zzd(new gy0(motionEvent));
                } catch (RemoteException unused) {
                    k92.f();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public g2 getAdChoicesView() {
        a("3011");
        return null;
    }

    public final View getAdvertiserView() {
        return a("3005");
    }

    public final View getBodyView() {
        return a("3004");
    }

    public final View getCallToActionView() {
        return a("3002");
    }

    public final View getHeadlineView() {
        return a("3001");
    }

    public final View getIconView() {
        return a("3003");
    }

    public final View getImageView() {
        return a("3008");
    }

    public final ls0 getMediaView() {
        View viewA = a("3010");
        if (viewA instanceof ls0) {
            return (ls0) viewA;
        }
        if (viewA == null) {
            return null;
        }
        k92.d("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return a("3007");
    }

    public final View getStarRatingView() {
        return a("3009");
    }

    public final View getStoreView() {
        return a("3006");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzbfh zzbfhVar = this.h;
        if (zzbfhVar == null) {
            return;
        }
        try {
            zzbfhVar.zze(new gy0(view), i);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        addView(this.g);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.g == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(g2 g2Var) {
        c("3011", g2Var);
    }

    public final void setAdvertiserView(View view) {
        c("3005", view);
    }

    public final void setBodyView(View view) {
        c("3004", view);
    }

    public final void setCallToActionView(View view) {
        c("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        zzbfh zzbfhVar = this.h;
        if (zzbfhVar == null) {
            return;
        }
        try {
            zzbfhVar.zzdw(new gy0(view));
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void setHeadlineView(View view) {
        c("3001", view);
    }

    public final void setIconView(View view) {
        c("3003", view);
    }

    public final void setImageView(View view) {
        c("3008", view);
    }

    public final void setMediaView(ls0 ls0Var) {
        c("3010", ls0Var);
        if (ls0Var == null) {
            return;
        }
        pw1 pw1Var = new pw1(this);
        synchronized (ls0Var) {
            ls0Var.k = pw1Var;
            if (ls0Var.h) {
                b(ls0Var.g);
            }
        }
        ls0Var.a(new xz1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [he0, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setNativeAd(rv0 rv0Var) {
        zzbfh zzbfhVar = this.h;
        if (zzbfhVar == 0) {
            return;
        }
        try {
            zzbfhVar.zzdz(rv0Var.zza());
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void setPriceView(View view) {
        c("3007", view);
    }

    public final void setStarRatingView(View view) {
        c("3009", view);
    }

    public final void setStoreView(View view) {
        c("3006", view);
    }
}
