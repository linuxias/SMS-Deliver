package com.linuxias.smsdeliver.broadcastreceiver

import android.annotation.TargetApi
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony.Sms.Intents.getMessagesFromIntent
import android.util.Log

class SMSBroadcastReceiver: BroadcastReceiver() {
    @TargetApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            when (it.action) {
                SMS_RECEIVED_ACTION -> {
                    for(message in getMessagesFromIntent(it)) {
                        // Todo: process message
                    }
                }
                else -> {}
            }
        }
    }

    companion object {
        private const val SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED"
    }
}