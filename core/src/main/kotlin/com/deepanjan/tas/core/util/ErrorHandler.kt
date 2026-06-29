package com.deepanjan.tas.core.util

import android.content.Context

sealed class DatabaseError {
    data class StorageFull(val message: String) : DatabaseError()
    data class WriteFailure(val message: String) : DatabaseError()
    data class CorruptedData(val message: String) : DatabaseError()
    data class UnknownError(val message: String) : DatabaseError()
}

object ErrorHandler {
    fun handleDatabaseError(context: Context, error: DatabaseError): String {
        return when (error) {
            is DatabaseError.StorageFull -> {
                "ডিভাইসের স্টোরেজ পূর্ণ হয়েছে। অনুগ্রহ করে কিছু ডেটা মুছে ফেলুন।"
            }
            is DatabaseError.WriteFailure -> {
                "ডেটা সংরক্ষণ করতে ব্যর্থ হয়েছে। অনুগ্রহ করে পুনরায় চেষ্টা করুন।"
            }
            is DatabaseError.CorruptedData -> {
                "ডেটা ক্ষতিগ্রস্ত হয়েছে। অনুগ্রহ করে একটি ব্যাকআপ থেকে পুনরুদ্ধার করুন।"
            }
            is DatabaseError.UnknownError -> {
                "একটি অজানা ত্রুটি ঘটেছে: ${error.message}"
            }
        }
    }
}
