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
        data.add("Screen lock enabled: "+TextSecurePreferences.isScreenLockEnabled(this));
        data.add("Passphrase timeout enabled: "+TextSecurePreferences.isPassphraseTimeoutEnabled(this));
        data.add("Screen security enabled: "+TextSecurePreferences.isScreenSecurityEnabled(this));
        data.add("Incognito keyboard enabled: "+TextSecurePreferences.isIncognitoKeyboardEnabled(this));
        data.add("Turn only enabled: "+TextSecurePreferences.isTurnOnly(this));
        data.add("Read receipts enabled: "+TextSecurePreferences.isReadReceiptsEnabled(this));
        data.add("Registration lock enabled: "+TextSecurePreferences.isRegistrationtLockEnabled(this));
        data.add("Show invite reminders enabled: "+TextSecurePreferences.isShowInviteReminders(this));
        data.add("System emoji enabled: "+TextSecurePreferences.isSystemEmojiPreferred(this));
        data.add("Thread length trimming enabled: "+TextSecurePreferences.isThreadLengthTrimmingEnabled(this));
        data.add("Backup enabled: "+TextSecurePreferences.isBackupEnabled(this));
        data.add("Notifications enabled: "+TextSecurePreferences.isNotificationsEnabled(this));
        data.add("Vibration enabled: "+TextSecurePreferences.isNotificationVibrateEnabled(this));
        data.add("Led color: "+TextSecurePreferences.getNotificationLedColor(this));
        data.add("Led pattern: "+TextSecurePreferences.getNotificationLedPattern(this));
        data.add("In thread notifications enabled: "+TextSecurePreferences.isInThreadNotifications(this));
        data.add("Repeat alert count: "+TextSecurePreferences.getRepeatAlertsCount(this));
        data.add("Notifications privacy: "+TextSecurePreferences.getNotificationPrivacy(this));
        data.add("Notifications priority: "+TextSecurePreferences.getNotificationPriority(this));
        data.add("Call notifications enabled: "+TextSecurePreferences.isCallNotificationsEnabled(this));
        data.add("Call vibration enabled: "+TextSecurePreferences.isCallNotificationVibrateEnabled(this));
        data.add("New contacts notificaitons enabled: "+TextSecurePreferences.isNewContactsNotificationEnabled(this));
        data.add("Intercept mms enabled: "+TextSecurePreferences.isInterceptAllMmsEnabled(this));
        data.add("Intercept sms enabled: "+TextSecurePreferences.isInterceptAllSmsEnabled(this));
        data.add("Sms delivery reports enabled: "+TextSecurePreferences.isSmsDeliveryReportsEnabled(this));
        data.add("Sms wifi enabled: "+TextSecurePreferences.isWifiSmsEnabled(this));

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(itemsAdapter);


    }
}
