package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgw extends zzfl {
    private final byte[] zza;
    private final DatagramPacket zzb;
    private Uri zzc;
    private DatagramSocket zzd;
    private MulticastSocket zze;
    private InetAddress zzf;
    private boolean zzg;
    private int zzh;

    public zzgw() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) throws zzgv {
        if (i2 == 0) {
            return 0;
        }
        if (this.zzh == 0) {
            try {
                DatagramSocket datagramSocket = this.zzd;
                if (datagramSocket == null) {
                    throw null;
                }
                datagramSocket.receive(this.zzb);
                int length = this.zzb.getLength();
                this.zzh = length;
                zzg(length);
            } catch (SocketTimeoutException e) {
                throw new zzgv(e, 2002);
            } catch (IOException e2) {
                throw new zzgv(e2, 2001);
            }
        }
        int length2 = this.zzb.getLength();
        int i3 = this.zzh;
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.zza, length2 - i3, bArr, i, iMin);
        this.zzh -= iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzgv {
        Uri uri = zzfyVar.zza;
        this.zzc = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.zzc.getPort();
        zzi(zzfyVar);
        try {
            this.zzf = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.zzf, port);
            if (this.zzf.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.zze = multicastSocket;
                multicastSocket.joinGroup(this.zzf);
                this.zzd = this.zze;
            } else {
                this.zzd = new DatagramSocket(inetSocketAddress);
            }
            this.zzd.setSoTimeout(8000);
            this.zzg = true;
            zzj(zzfyVar);
            return -1L;
        } catch (IOException e) {
            throw new zzgv(e, 2001);
        } catch (SecurityException e2) {
            throw new zzgv(e2, 2006);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        InetAddress inetAddress;
        this.zzc = null;
        MulticastSocket multicastSocket = this.zze;
        if (multicastSocket != null) {
            try {
                inetAddress = this.zzf;
            } catch (IOException unused) {
            }
            if (inetAddress == null) {
                throw null;
            }
            multicastSocket.leaveGroup(inetAddress);
            this.zze = null;
        }
        DatagramSocket datagramSocket = this.zzd;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.zzd = null;
        }
        this.zzf = null;
        this.zzh = 0;
        if (this.zzg) {
            this.zzg = false;
            zzh();
        }
    }

    public zzgw(int i) {
        super(true);
        byte[] bArr = new byte[2000];
        this.zza = bArr;
        this.zzb = new DatagramPacket(bArr, 0, 2000);
    }
}
