package com.milan.myapplication.base

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson

class SharedPrefsHelper {

    companion object {
        private var mSharedPreferences: SharedPreferences? = null
        private var editor: SharedPreferences.Editor? = null

        private var gson: Gson? = null

        fun init(context: Context) {

            if (mSharedPreferences == null) {
                mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
                editor = mSharedPreferences!!.edit()
                gson = Gson()
            }
        }

        fun clearPref(context: Context) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            editor = mSharedPreferences!!.edit()
            editor!!.clear().apply()
        }

        fun put(key: String, value: String) {
            editor!!.putString(key, value).apply()
        }

        fun <T> put(key: String, clazz: Class<T>, input: T) {
            editor!!.putString(key, gson!!.toJson(input)).apply()
        }

        fun put(key: String, value: Int) {
            editor!!.putInt(key, value).apply()
        }

        fun put(key: String, value: Float) {
            editor!!.putFloat(key, value).apply()
        }

        fun put(key: String, value: Boolean) {
            editor!!.putBoolean(key, value).apply()
        }

        operator fun get(key: String, defaultValue: String): String? {
            return mSharedPreferences!!.getString(key, defaultValue)
        }

        operator fun get(key: String, defaultValue: Int): Int? {
            return mSharedPreferences!!.getInt(key, defaultValue)
        }

        operator fun get(key: String, defaultValue: Float): Float? {
            return mSharedPreferences!!.getFloat(key, defaultValue)
        }

        operator fun get(key: String, defaultValue: Boolean): Boolean {
            return mSharedPreferences!!.getBoolean(key, defaultValue)
        }

        fun <T> getModel(key: String, input: Class<T>): T {
            return gson!!.fromJson(mSharedPreferences!!.getString(key, ""), input)
        }


        fun deleteSavedData(key: String) {
            editor!!.remove(key).apply()
        }

        fun clearAllDate() {
            mSharedPreferences!!.edit().clear().apply()
        }
    }
}