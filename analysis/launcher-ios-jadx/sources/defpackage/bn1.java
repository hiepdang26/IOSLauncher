package defpackage;

import android.os.HandlerThread;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzfru;

/* JADX INFO: loaded from: classes.dex */
public final class bn1 {
    public int a;
    public Object b;
    public Object c;
    public Object d;

    public bn1(zzcej zzcejVar) throws ya2 {
        this.b = zzcejVar.getLayoutParams();
        ViewParent parent = zzcejVar.getParent();
        this.d = zzcejVar.zzE();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new ya2("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.c = viewGroup;
        this.a = viewGroup.indexOfChild(zzcejVar.zzF());
        viewGroup.removeView(zzcejVar.zzF());
        zzcejVar.zzaq(true);
    }

    public Looper a() {
        Looper looper;
        synchronized (this.d) {
            try {
                if (this.a != 0) {
                    hg0.j((HandlerThread) this.b, "Invalid state: handlerThread should already been initialized.");
                } else if (((HandlerThread) this.b) == null) {
                    k92.a("Starting the looper thread.");
                    HandlerThread handlerThread = new HandlerThread("LooperProvider");
                    this.b = handlerThread;
                    handlerThread.start();
                    this.c = new zzfru(((HandlerThread) this.b).getLooper());
                    k92.a("Looper thread started.");
                } else {
                    k92.a("Resuming the looper thread");
                    this.d.notifyAll();
                }
                this.a++;
                looper = ((HandlerThread) this.b).getLooper();
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }
}
