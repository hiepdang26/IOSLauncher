package defpackage;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class hd0 extends p9 {
    public final /* synthetic */ int k;
    public final /* synthetic */ Object l;

    public /* synthetic */ hd0(Object obj, int i) {
        this.k = i;
        this.l = obj;
    }

    @Override // defpackage.p9
    public IOException l(IOException iOException) {
        switch (this.k) {
            case 0:
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            case 1:
                SocketTimeoutException socketTimeoutException2 = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException2.initCause(iOException);
                }
                return socketTimeoutException2;
            default:
                return super.l(iOException);
        }
    }

    @Override // defpackage.p9
    public final void m() {
        switch (this.k) {
            case 0:
                ((id0) this.l).e(6);
                bd0 bd0Var = ((id0) this.l).d;
                synchronized (bd0Var) {
                    try {
                        long j = bd0Var.s;
                        long j2 = bd0Var.r;
                        if (j < j2) {
                            return;
                        }
                        bd0Var.r = j2 + 1;
                        bd0Var.t = System.nanoTime() + 1000000000;
                        try {
                            bd0Var.n.execute(new tc0(bd0Var, new Object[]{bd0Var.j}));
                            return;
                        } catch (RejectedExecutionException unused) {
                            return;
                        }
                    } finally {
                    }
                }
            case 1:
                Socket socket = (Socket) this.l;
                try {
                    socket.close();
                    return;
                } catch (AssertionError e) {
                    if (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) {
                        throw e;
                    }
                    jy0.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                    return;
                } catch (Exception e2) {
                    jy0.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                    return;
                }
            default:
                ((hp1) this.l).a();
                return;
        }
    }

    public void n() {
        if (k()) {
            throw l(null);
        }
    }
}
