package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.hd2;
import defpackage.hs0;
import defpackage.id1;
import defpackage.k92;
import defpackage.os;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzbuz extends b0 {
    public static final Parcelable.Creator<zzbuz> CREATOR = new zzbva();
    ParcelFileDescriptor zza;
    private Parcelable zzb = null;
    private boolean zzc = true;

    public zzbuz(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe;
        if (this.zza == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.zzb.writeToParcel(parcelObtain, 0);
                final byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                ParcelFileDescriptor parcelFileDescriptor = null;
                try {
                    parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
                } catch (IOException e) {
                    e = e;
                    autoCloseOutputStream = null;
                }
                try {
                    zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbuy
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            DataOutputStream dataOutputStream;
                            Parcelable.Creator<zzbuz> creator = zzbuz.CREATOR;
                            OutputStream outputStream = autoCloseOutputStream;
                            byte[] bArr = bArrMarshall;
                            DataOutputStream dataOutputStream2 = null;
                            try {
                                try {
                                    dataOutputStream = new DataOutputStream(outputStream);
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                hs0.h(dataOutputStream);
                            } catch (IOException e3) {
                                e = e3;
                                dataOutputStream2 = dataOutputStream;
                                k92.f();
                                hd2.B.g.zzw(e, "LargeParcelTeleporter.pipeData.1");
                                if (dataOutputStream2 == null) {
                                    hs0.h(outputStream);
                                } else {
                                    hs0.h(dataOutputStream2);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream2 = dataOutputStream;
                                if (dataOutputStream2 == null) {
                                    hs0.h(outputStream);
                                } else {
                                    hs0.h(dataOutputStream2);
                                }
                                throw th;
                            }
                        }
                    });
                    parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
                } catch (IOException e2) {
                    e = e2;
                    k92.f();
                    hd2.B.g.zzw(e, "LargeParcelTeleporter.pipeData.2");
                    hs0.h(autoCloseOutputStream);
                }
                this.zza = parcelFileDescriptor;
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        int iE = os.E(20293, parcel);
        os.y(parcel, 2, this.zza, i);
        os.F(iE, parcel);
    }

    public final id1 zza(Parcelable.Creator creator) {
        if (this.zzc) {
            if (this.zza == null) {
                k92.e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zza));
            try {
                try {
                    int i = dataInputStream.readInt();
                    byte[] bArr = new byte[i];
                    dataInputStream.readFully(bArr, 0, i);
                    hs0.h(dataInputStream);
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, i);
                        parcelObtain.setDataPosition(0);
                        this.zzb = (Parcelable) creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        this.zzc = false;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (IOException unused) {
                    k92.f();
                    hs0.h(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                hs0.h(dataInputStream);
                throw th2;
            }
        }
        return (id1) this.zzb;
    }
}
