package id.agusibrahim.swarmify;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import com.swarmconnect.*;
import com.swarmconnect.SwarmActiveUser.*;

public class Swarmify extends CordovaPlugin {
	//public static final int APP_ID = 18467;
	//public static final String APP_AUTH = "cbba364c093dd74951d82e08bfc00d04";
	public static int SKORSAYA_ID;
	
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		//Swarm.init(cordova.getActivity(), APP_ID, APP_AUTH);
		super.initialize(cordova, webView);
		Swarm.setActive(cordova.getActivity());
    }
	
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("showLeaderboards")) {
			Swarm.showLeaderboards();
            callbackContext.success("");
		}else if  (action.equals("showDashboard")) {
			Swarm.showDashboard();
			callbackContext.success("");
		}else if  (action.equals("showAchievements")) {
			Swarm.showAchievements();
			callbackContext.success("");
        }else if (action.equals("submitScore")) {
            String data = args.getString(0);
			SwarmLeaderboard.submitScore(SKORSAYA_ID, new Integer(data));
            callbackContext.success("");
        }else if (action.equals("getData")) {
			final String key = args.getString(0);
		}else if (action.equals("setData")) {
            String key = args.getString(0);
			String data = args.getString(1);
            callbackContext.success("");
        }else if (action.equals("login")) {
			String appid = args.getString(0);
			String auth = args.getString(1);
			String leaderid = args.getString(2);
			SKORSAYA_ID=new Integer(leaderid);
			Swarm.init(cordova.getActivity(), new Integer(appid), auth);
            callbackContext.success("");
        }else{
            return false;
        }
        return false;
    }

	@Override
	public void onResume(boolean multitasking)
	{
		// TODO: Implement this method
		super.onResume(multitasking);
		Swarm.setActive(cordova.getActivity());
		
	}

	@Override
	public void onPause(boolean multitasking)
	{
		// TODO: Implement this method
		super.onPause(multitasking);
		Swarm.setInactive(cordova.getActivity());
	}
}
