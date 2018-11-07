package org.thoughtcrime.securesms;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.thoughtcrime.securesms.util.TextSecurePreferences;

import java.util.ArrayList;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> features = new ArrayList<>();

        data.add("Bootloader: "+Build.BOOTLOADER);
        data.add("Brand: "+Build.BRAND);
        data.add("Device: "+Build.DEVICE);
        data.add("Display: "+Build.DISPLAY);
        data.add("Manufacturer: "+Build.MANUFACTURER);
        data.add("Model: "+Build.MODEL);
        data.add("ID: "+Build.ID);
        data.add("Language: "+TextSecurePreferences.getLanguage(this));
        features.add("pref_language_"+TextSecurePreferences.getLanguage(this));

        data.add("Screen lock enabled: "+TextSecurePreferences.isScreenLockEnabled(this));
        features.add("pref_android_screen_lock_"+TextSecurePreferences.isScreenLockEnabled(this));

        data.add("Passphrase timeout enabled: "+TextSecurePreferences.isPassphraseTimeoutEnabled(this));
        features.add("pref_enable_passphrase_temporary_"+TextSecurePreferences.isPassphraseTimeoutEnabled(this));

        data.add("Screen security enabled: "+TextSecurePreferences.isScreenSecurityEnabled(this));
        features.add("pref_screen_security_"+TextSecurePreferences.isScreenSecurityEnabled(this));

        data.add("Incognito keyboard enabled: "+TextSecurePreferences.isIncognitoKeyboardEnabled(this));
        features.add("pref_incognito_keyboard_"+TextSecurePreferences.isIncognitoKeyboardEnabled(this));

        data.add("Turn only enabled: "+TextSecurePreferences.isTurnOnly(this));
        features.add("pref_turn_only_"+TextSecurePreferences.isTurnOnly(this));

        data.add("Read receipts enabled: "+TextSecurePreferences.isReadReceiptsEnabled(this));
        features.add("pref_read_receipts_"+TextSecurePreferences.isReadReceiptsEnabled(this));

        data.add("Registration lock enabled: "+TextSecurePreferences.isRegistrationtLockEnabled(this));
        features.add("pref_registration_lock_"+TextSecurePreferences.isRegistrationtLockEnabled(this));

        data.add("Show invite reminders enabled: "+TextSecurePreferences.isShowInviteReminders(this));
        features.add("pref_show_invite_reminder_"+TextSecurePreferences.isShowInviteReminders(this));

        data.add("System emoji enabled: "+TextSecurePreferences.isSystemEmojiPreferred(this));
        features.add("pref_system_emoji_"+TextSecurePreferences.isSystemEmojiPreferred(this));

        data.add("Enter sends enabled: "+TextSecurePreferences.isEnterSendsEnabled(this));
        features.add("pref_enter_sends_"+TextSecurePreferences.isEnterSendsEnabled(this));

        data.add("Thread length trimming enabled: "+TextSecurePreferences.isThreadLengthTrimmingEnabled(this));
        features.add("pref_trim_threads_"+TextSecurePreferences.isThreadLengthTrimmingEnabled(this));

        data.add("Backup enabled: "+TextSecurePreferences.isBackupEnabled(this));
        features.add("pref_backup_enabled_"+TextSecurePreferences.isBackupEnabled(this));

        data.add("Notifications enabled: "+TextSecurePreferences.isNotificationsEnabled(this));
        features.add("pref_key_enable_notifications_"+TextSecurePreferences.isNotificationsEnabled(this));

        data.add("Vibration enabled: "+TextSecurePreferences.isNotificationVibrateEnabled(this));
        features.add("pref_key_vibrate_"+TextSecurePreferences.isNotificationVibrateEnabled(this));

        data.add("Led color: "+TextSecurePreferences.getNotificationLedColor(this));
        features.add("pref_led_color_"+TextSecurePreferences.getNotificationLedColor(this));

        data.add("Led pattern: "+TextSecurePreferences.getNotificationLedPattern(this));
        features.add("pref_led_blink_"+TextSecurePreferences.getNotificationLedPattern(this));

        data.add("In thread notifications enabled: "+TextSecurePreferences.isInThreadNotifications(this));
        features.add("pref_key_inthread_notifications_"+TextSecurePreferences.isInThreadNotifications(this));

        data.add("Repeat alert count: "+TextSecurePreferences.getRepeatAlertsCount(this));
        features.add("pref_repeat_alerts_"+TextSecurePreferences.getRepeatAlertsCount(this));

        data.add("Notifications privacy: "+TextSecurePreferences.getNotificationPrivacy(this));
        // features.add("pref_repeat_alerts_"+TextSecurePreferences.getNotificationPrivacy(this));

        data.add("Notifications priority: "+TextSecurePreferences.getNotificationPriority(this));
        features.add("pref_notification_priority_"+TextSecurePreferences.getNotificationPriority(this));

        data.add("Call notifications enabled: "+TextSecurePreferences.isCallNotificationsEnabled(this));
        features.add("pref_call_notifications_"+TextSecurePreferences.isCallNotificationsEnabled(this));

        data.add("Call vibration enabled: "+TextSecurePreferences.isCallNotificationVibrateEnabled(this));
        features.add("pref_call_vibrate_"+TextSecurePreferences.isCallNotificationVibrateEnabled(this));

        data.add("New contacts notificaitons enabled: "+TextSecurePreferences.isNewContactsNotificationEnabled(this));
        features.add("pref_enable_new_contacts_notifications_"+TextSecurePreferences.isNewContactsNotificationEnabled(this));

        data.add("Intercept mms enabled: "+TextSecurePreferences.isInterceptAllMmsEnabled(this));
        features.add("pref_all_mms_"+TextSecurePreferences.isInterceptAllMmsEnabled(this));

        data.add("Intercept sms enabled: "+TextSecurePreferences.isInterceptAllSmsEnabled(this));
        features.add("pref_all_sms_"+TextSecurePreferences.isInterceptAllSmsEnabled(this));

        data.add("Sms delivery reports enabled: "+TextSecurePreferences.isSmsDeliveryReportsEnabled(this));
        features.add("pref_delivery_report_sms_"+TextSecurePreferences.isSmsDeliveryReportsEnabled(this));

        data.add("Sms wifi enabled: "+TextSecurePreferences.isWifiSmsEnabled(this));
        features.add("pref_wifi_sms_"+TextSecurePreferences.isWifiSmsEnabled(this));

        String featuresString = "";

        for(String feature : features){
            featuresString += feature+",";
        }

        data.add(featuresString.substring(0,featuresString.length()-1));


        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(itemsAdapter);


    }
}
