package com.example.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int num;
    String message;

    public SimpleData(int num, String message) {
        this.num = num;
        this.message = message;
    }

    public SimpleData(Parcel src) {
        num = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel parcel) {
            return new SimpleData(parcel);
        }

        @Override
        public Object[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(num);
        parcel.writeString(message);
    }

    public int getNum() {
        return num;
    }

    public String getMessage() {
        return message;
    }
}
