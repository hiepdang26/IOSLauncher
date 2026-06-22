package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class jy0 {
    public static final Logger a = Logger.getLogger(jy0.class.getName());

    public static m9 a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        hd0 hd0Var = new hd0(socket, 1);
        OutputStream outputStream = socket.getOutputStream();
        if (outputStream != null) {
            return new m9(hd0Var, new m9(hd0Var, outputStream, 1), 0);
        }
        throw new IllegalArgumentException("out == null");
    }

    public static n9 b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        hd0 hd0Var = new hd0(socket, 1);
        InputStream inputStream = socket.getInputStream();
        if (inputStream != null) {
            return new n9(hd0Var, new n9(hd0Var, inputStream));
        }
        throw new IllegalArgumentException("in == null");
    }
}
