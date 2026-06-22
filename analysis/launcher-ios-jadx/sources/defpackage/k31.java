package defpackage;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzea;
import com.google.android.gms.internal.ads.zzgxd;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class k31 {
    public static final void a(int i, View view) {
        int iV = uo.v(i);
        if (iV == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (h60.E(2)) {
                    view.toString();
                    viewGroup.toString();
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iV == 1) {
            if (h60.E(2)) {
                Objects.toString(view);
            }
            view.setVisibility(0);
        } else if (iV == 2) {
            if (h60.E(2)) {
                Objects.toString(view);
            }
            view.setVisibility(8);
        } else {
            if (iV != 3) {
                return;
            }
            if (h60.E(2)) {
                Objects.toString(view);
            }
            view.setVisibility(4);
        }
    }

    public static int b(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 4) {
            return 4;
        }
        if (i == 8) {
            return 3;
        }
        throw new IllegalArgumentException(k(i, "Unknown visibility "));
    }

    public static int c(View view) {
        if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
            return 4;
        }
        return b(view.getVisibility());
    }

    public static final boolean d(int i) {
        return i == 3 || i == 4 || i == 6;
    }

    public static /* synthetic */ boolean e(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw null;
    }

    public static /* synthetic */ float f(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return 0.0f;
        }
        if (i == 4) {
            return 1.0f;
        }
        throw null;
    }

    public static /* synthetic */ float g(int i) {
        if (i == 1 || i == 2) {
            return 0.0f;
        }
        if (i == 3) {
            return 1.0f;
        }
        if (i == 4) {
            return 0.0f;
        }
        throw null;
    }

    public static int h(int i, int i2, int i3) {
        return zzgxd.zzD(i) + i2 + i3;
    }

    public static he0 i(Parcel parcel) {
        he0 he0VarQ = gy0.q(parcel.readStrongBinder());
        parcel.recycle();
        return he0VarQ;
    }

    public static String j(int i, int i2, String str, String str2) {
        return str + i + str2 + i2;
    }

    public static String k(int i, String str) {
        return str + i;
    }

    public static String l(Uri uri, String str) {
        return str + uri;
    }

    public static StringBuilder m(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static void n(int i, String str, String str2) {
        zzea.zzf(str2, str + i);
    }

    public static void o(int i, HashMap map, String str, int i2, String str2) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
    }

    public static /* synthetic */ void p(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (autoCloseable instanceof ExecutorService) {
            e.y((ExecutorService) autoCloseable);
            return;
        }
        if (autoCloseable instanceof TypedArray) {
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        if (autoCloseable instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof MediaDrm) {
            ((MediaDrm) autoCloseable).release();
        } else if (autoCloseable instanceof DrmManagerClient) {
            ((DrmManagerClient) autoCloseable).release();
        } else {
            if (!(autoCloseable instanceof ContentProviderClient)) {
                throw new IllegalArgumentException();
            }
            ((ContentProviderClient) autoCloseable).release();
        }
    }

    public static /* synthetic */ void q(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void r(String str, String str2, String str3) {
        zzea.zzf(str3, str2.concat(String.valueOf(str)));
    }
}
