package plum.umd.org.twobuttons;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class BackgroundIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "plum.umd.org.twobuttons.action.FOO";
    private static final String ACTION_BAZ = "plum.umd.org.twobuttons.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "plum.umd.org.twobuttons.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "plum.umd.org.twobuttons.extra.PARAM2";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context) {
        Intent intent = new Intent(context, BackgroundIntentService.class);
        intent.setAction(ACTION_FOO);
        //intent.putExtra(EXTRA_PARAM1, param1);
        //intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context) {
        Intent intent = new Intent(context, BackgroundIntentService.class);
        intent.setAction(ACTION_BAZ);
        context.startService(intent);
    }

    public BackgroundIntentService() {
        super("BackgroundIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                TelephonyManager tMgr = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
                String mPhoneNumber = tMgr.getLine1Number();
            } else if (ACTION_BAZ.equals(action)) {
                TelephonyManager tMgr = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
                String mPhoneNumber = tMgr.getSimSerialNumber();
            }
        }
    }
}
