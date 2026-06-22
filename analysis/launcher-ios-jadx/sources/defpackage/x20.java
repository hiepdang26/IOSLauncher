package defpackage;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class x20 extends j9 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x20(AssetManager assetManager, String str, int i) {
        super(0, str, assetManager);
        this.k = i;
    }

    @Override // defpackage.cs
    public final Class a() {
        switch (this.k) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // defpackage.j9
    public final void g(Object obj) throws IOException {
        switch (this.k) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((InputStream) obj).close();
                break;
        }
    }

    @Override // defpackage.j9
    public final Object h(AssetManager assetManager, String str) {
        switch (this.k) {
            case 0:
                return assetManager.openFd(str);
            default:
                return assetManager.open(str);
        }
    }
}
