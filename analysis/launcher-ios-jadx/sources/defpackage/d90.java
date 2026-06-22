package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* JADX INFO: loaded from: classes.dex */
public final class d90 extends TextureView implements TextureView.SurfaceTextureListener {
    public final c90 g;

    public d90(Context context) {
        super(context, null, 0);
        c90 c90VarC = c90.c(context);
        this.g = c90VarC;
        setSurfaceTextureListener(this);
        setOpaque(false);
        c90VarC.getClass();
        b90 b90Var = new b90(this);
        if (((b90) c90VarC.v.put(this, b90Var)) == null) {
            c90VarC.e(new wc(c90VarC, b90Var, 7));
        }
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c90 c90Var = this.g;
        if (c90Var.v.containsKey(this)) {
            return;
        }
        b90 b90Var = new b90(this);
        if (((b90) c90Var.v.put(this, b90Var)) == null) {
            c90Var.e(new wc(c90Var, b90Var, 7));
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        c90 c90Var = this.g;
        b90 b90Var = (b90) c90Var.v.remove(this);
        if (b90Var != null) {
            c90Var.e(new r1(b90Var, 16));
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        b90 b90Var = (b90) this.g.v.get(this);
        if (b90Var == null) {
            return;
        }
        b90Var.d = Math.max(1, i);
        b90Var.e = Math.max(1, i2);
        b90Var.h = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        b90 b90Var = (b90) this.g.v.get(this);
        if (b90Var == null) {
            return;
        }
        b90Var.d = Math.max(1, i);
        b90Var.e = Math.max(1, i2);
        b90Var.h = true;
    }

    public void setFullBitmap(Bitmap bitmap) {
        c90 c90Var = this.g;
        c90Var.getClass();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        c90Var.e(new a90(c90Var, bitmap, 1));
    }

    public void setSdfTexture(int i) {
        this.g.f(i);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
