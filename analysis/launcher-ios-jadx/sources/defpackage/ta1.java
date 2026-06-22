package defpackage;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.view.View;
import com.bumptech.glide.a;
import com.google.android.material.tabs.TabLayout;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.util.BadgeTextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ta1 implements ua1, mu0, xr1, cz0, c02, er, l92, pf0, cy {
    public final /* synthetic */ int g;

    public /* synthetic */ ta1(int i) {
        this.g = i;
    }

    public static RectF f(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.H || !(view instanceof em1)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        em1 em1Var = (em1) view;
        int contentWidth = em1Var.getContentWidth();
        int contentHeight = em1Var.getContentHeight();
        int iQ = (int) qg0.q(em1Var.getContext(), 24);
        if (contentWidth < iQ) {
            contentWidth = iQ;
        }
        int right = (em1Var.getRight() + em1Var.getLeft()) / 2;
        int bottom = (em1Var.getBottom() + em1Var.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    @Override // defpackage.cz0
    public void a(Object obj) {
        Objects.toString((ip0) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r4
  0x001b: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.cy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.ay b(android.content.Context r3, java.lang.String r4, defpackage.zx r5) {
        /*
            r2 = this;
            ay r0 = new ay
            r0.<init>()
            int r1 = r5.b(r3, r4)
            r0.a = r1
            r1 = 1
            int r3 = r5.e(r3, r4, r1)
            r0.b = r3
            int r4 = r0.a
            if (r4 != 0) goto L1b
            r4 = 0
            if (r3 != 0) goto L1b
            r1 = 0
            goto L1e
        L1b:
            if (r4 < r3) goto L1e
            r1 = -1
        L1e:
            r0.c = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ta1.b(android.content.Context, java.lang.String, zx):ay");
    }

    @Override // defpackage.xr1
    public void c(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        switch (this.g) {
            case 6:
                AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
                mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                break;
            default:
                mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                break;
        }
    }

    @Override // defpackage.xr1
    public void d(MediaExtractor mediaExtractor, Object obj) throws IOException {
        switch (this.g) {
            case 6:
                AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
                mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                break;
            default:
                mediaExtractor.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                break;
        }
    }

    @Override // defpackage.ua1
    public sa1 e(a aVar, wm0 wm0Var, wa1 wa1Var, Context context) {
        return new sa1(aVar, wm0Var, wa1Var, context);
    }

    public void g(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF rectFF = f(tabLayout, view);
        RectF rectFF2 = f(tabLayout, view2);
        drawable.setBounds(n5.c(f, (int) rectFF.left, (int) rectFF2.left), drawable.getBounds().top, n5.c(f, (int) rectFF.right, (int) rectFF2.right), drawable.getBounds().bottom);
    }

    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        if (qh0Var != null && (qh0Var instanceof og1) && (view instanceof BubbleTextView)) {
            int i = ((og1) qh0Var).s;
            BadgeTextView badgeTextView = ((BubbleTextView) view).v;
            if (i > 0) {
                badgeTextView.setBadgeCount(i);
                badgeTextView.setVisibility(0);
            } else {
                badgeTextView.setVisibility(8);
            }
        }
        return false;
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 3:
                return new ak1(qm0Var.b(Uri.class, AssetFileDescriptor.class), 0);
            default:
                return new ak1(qm0Var.b(x90.class, InputStream.class), 1);
        }
    }

    @Override // defpackage.l92
    public boolean zza(String str) {
        new z12(str, 1).start();
        return true;
    }

    public /* synthetic */ ta1(ka2 ka2Var) {
        this.g = 12;
    }
}
