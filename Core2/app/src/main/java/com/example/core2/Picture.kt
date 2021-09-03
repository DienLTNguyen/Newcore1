package com.example.core2

import android.os.Parcel
import android.os.Parcelable


data class Picture(var name: String, var description: String, var date: String, var star: Int = 0, val id: Int): Parcelable{


    constructor(source: Parcel): this(
        source.readString().toString(),
        source.readString().toString(),
        source.readString().toString(),
        source.readInt(),
        source.readInt()
    )


    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(date)
        parcel.writeInt(star)
        parcel.writeInt(id)
    }


    override fun describeContents(): Int {
        return 0
    }

    //data from parcel
    companion object CREATOR: Parcelable.Creator<Picture> {


        override fun createFromParcel(parcel: Parcel): Picture {
            return Picture(parcel)
        }

        override fun newArray(size: Int): Array<Picture?> {
            return arrayOfNulls(size)
        }

        fun nameChoose(name: String): String {
            if(name.isEmpty()) {
                return ""
            }
            return "$name is chosen!"
        }
    }






}
