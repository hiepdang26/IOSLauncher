package defpackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.ImageView;
import com.luutinhit.launcher6.FolderIcon;

/* JADX INFO: loaded from: classes.dex */
public final class cx implements wo1, c02, zx {
    public final int g;

    public /* synthetic */ cx(int i) {
        this.g = i;
    }

    @Override // defpackage.wo1
    public boolean a(Object obj, lc lcVar) {
        Drawable drawable = (Drawable) obj;
        ImageView imageView = lcVar.g;
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2 == null) {
            drawable2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        transitionDrawable.setCrossFadeEnabled(false);
        transitionDrawable.startTransition(this.g);
        imageView.setImageDrawable(transitionDrawable);
        return true;
    }

    @Override // defpackage.zx
    public int b(Context context, String str) {
        return this.g;
    }

    @Override // defpackage.zx
    public int e(Context context, String str, boolean z) {
        return 0;
    }

    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        return (qh0Var instanceof qk0) && ((qk0) qh0Var).x == this.g;
    }
}
