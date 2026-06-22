package defpackage;

import android.content.Context;
import android.graphics.Path;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.view.View;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.util.BadgeTextView;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b21 implements h20, mu0, xr1, cz0, c02, cc1, gr, cy, z91 {
    public final /* synthetic */ int g;

    public /* synthetic */ b21(int i) {
        this.g = i;
    }

    public static final float f(float f, int i) {
        float f2 = i;
        double dRandom = (float) Math.random();
        return (f2 * (dRandom > 0.18d ? dRandom > 0.26d ? Math.abs(((float) Math.random()) - 0.6f) : Math.abs(((float) Math.random()) - 0.3f) : (float) Math.random())) - (f * 2);
    }

    public static Path g(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        return path;
    }

    @Override // defpackage.cz0
    public void a(Object obj) {
        Objects.toString((ip0) obj);
    }

    @Override // defpackage.cy
    public ay b(Context context, String str, zx zxVar) {
        ay ayVar = new ay();
        int iE = zxVar.e(context, str, true);
        ayVar.b = iE;
        if (iE != 0) {
            ayVar.c = 1;
            return ayVar;
        }
        int iB = zxVar.b(context, str);
        ayVar.a = iB;
        if (iB != 0) {
            ayVar.c = -1;
        }
        return ayVar;
    }

    @Override // defpackage.xr1
    public void c(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(new wr1((ByteBuffer) obj));
    }

    @Override // defpackage.h20
    public Object create() {
        try {
            return new hd1(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // defpackage.xr1
    public void d(MediaExtractor mediaExtractor, Object obj) throws IOException {
        mediaExtractor.setDataSource(new wr1((ByteBuffer) obj));
    }

    @Override // defpackage.z91
    public void e(Object obj, Object obj2) {
        ua2 ua2Var = (ua2) ((z72) obj).getService();
        w32 w32Var = new w32((qm1) obj2);
        ua2Var.getClass();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.appset.internal.IAppSetService");
        int i = h62.a;
        parcelObtain.writeInt(1);
        os.F(os.E(20293, parcelObtain), parcelObtain);
        parcelObtain.writeStrongBinder(w32Var);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            ua2Var.g.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // defpackage.cc1
    public int getAmount() {
        return 1;
    }

    @Override // defpackage.cc1
    public String getType() {
        return "";
    }

    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        if ((qh0Var instanceof w40) && (view instanceof FolderIcon)) {
            BubbleTextView bubbleTextView = ((FolderIcon) view).o;
            int i = ((w40) qh0Var).s;
            BadgeTextView badgeTextView = bubbleTextView.v;
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
            case 4:
                return new ak1(qm0Var.b(Uri.class, ParcelFileDescriptor.class), 0);
            default:
                return new iq1(qm0Var.b(x90.class, InputStream.class));
        }
    }
}
