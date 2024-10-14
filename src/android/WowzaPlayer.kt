/**
 */
package com.outsystems.experts;

import android.content.Intent
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import com.flowplayer.android.player.event.listener.*;

import android.util.Log;

class WowzaPlayer : CordovaPlugin() {
    companion object {
        private const val TAG = "Wowza Player"
    }

    override fun initialize(cordova: CordovaInterface, webView: CordovaWebView) {
        super.initialize(cordova, webView)
        Log.d(TAG, "Initializing Wowza Player")
    }

    @Throws(JSONException::class)
        override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
          if (action == "createPlayer") {
               createPlayer(args[0].toString())
            }
        return true
    }

    fun createPlayer(mediaURL:String){
      val intent= Intent(cordova.context, WowzaActivity::class.java)
      intent.putExtra("MEDIA_URL",mediaURL)
      cordova.context.startActivity(intent);
    }
}