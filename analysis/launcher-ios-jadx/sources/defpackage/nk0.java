package defpackage;

import android.widget.FrameLayout;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.DeleteCircleView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nk0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ pk0 h;

    public /* synthetic */ nk0(pk0 pk0Var, int i) {
        this.g = i;
        this.h = pk0Var;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                pk0 pk0Var = this.h;
                t tVar = pk0Var.j;
                int i = -tVar.mDeviceProfile.A;
                int i2 = tVar.mDeviceProfile.z;
                pw pwVar = new pw(i2, i2);
                ((FrameLayout.LayoutParams) pwVar).gravity = 8388659;
                float f = tVar.isRTL ? -i : i;
                DeleteCircleView deleteCircleView = pk0Var.n;
                deleteCircleView.setTranslationX(f);
                deleteCircleView.setTranslationY(i);
                try {
                    pk0Var.removeView(deleteCircleView);
                } catch (Throwable th) {
                    th.getMessage();
                }
                pk0Var.addView(deleteCircleView, pk0Var.getChildCount(), pwVar);
                deleteCircleView.measure(0, 0);
                deleteCircleView.setOnClickListener(new g7(pk0Var, 7));
                break;
            default:
                pk0 pk0Var2 = this.h;
                DeleteCircleView deleteCircleView2 = pk0Var2.n;
                deleteCircleView2.c(0, true);
                pk0Var2.bringChildToFront(deleteCircleView2);
                break;
        }
    }
}
