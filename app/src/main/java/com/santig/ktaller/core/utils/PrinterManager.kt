package com.santig.ktaller.core.utils

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import java.util.UUID
import androidx.core.content.edit

object PrinterManager {
    private const val PREF_NAME = "printer_prefs"
    private const val KEY_MAC_ADDRESS = "saved_printer_mac"
    private val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

    fun savePrinter(context: Context, macAddress: String) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit { putString(KEY_MAC_ADDRESS, macAddress) }
    }
    fun getSavedPrinterMac(context: Context): String? {
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getString(KEY_MAC_ADDRESS, null)
    }
    fun clearPrinter(context: Context) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().remove(KEY_MAC_ADDRESS).apply()
    }
    fun hasBluetoothConnectPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.BLUETOOTH_CONNECT
        ) == PackageManager.PERMISSION_GRANTED
    }
    @SuppressLint("MissingPermission")
    fun getPairedPrinters(context: Context): List<BluetoothDevice> {
        val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager?
        val adapter = bluetoothManager?.adapter ?: return emptyList()
        val hasPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.BLUETOOTH_CONNECT
        ) == PackageManager.PERMISSION_GRANTED
        if (!adapter.isEnabled || !hasPermission) {
            return emptyList()
        }
        val pairedDevices = adapter.bondedDevices ?: return emptyList()
        return pairedDevices.map { device ->
            BluetoothDevice(
                name = device.name,
                address = device.address
            )
        }
    }
}

data class BluetoothDevice(
    val name: String,
    val address: String
)
