package com.outsystems.experts;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.flowplayer.android.player.Flowplayer;
import com.flowplayer.android.player.FlowplayerSupportFragment;
import com.flowplayer.android.player.event.PauseEvent;
import com.flowplayer.android.player.event.listener.*;
import com.flowplayer.android.player.media.ExternalMedia;


class WowzaActivity: AppCompatActivity(), OnPauseListener {
    lateinit var flowplayer: Flowplayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutId=resources.getIdentifier("activity_main","layout",packageName)
        setContentView(layoutId)
        val mediaURL = intent.extras?.getString("MEDIA_URL") ?: ""
        this.createPlayer(mediaURL)
    }

    fun createPlayer(mediaURL:String){
        val fragmentId=resources.getIdentifier("player_fragment","id",packageName)
        val playerFragment = supportFragmentManager.findFragmentById(fragmentId) as FlowplayerSupportFragment
        flowplayer = playerFragment.getPlayer()
        flowplayer.addEventListener(this)

        val externalMedia = ExternalMedia(mediaURL)
        flowplayer.prepare(externalMedia, false);

    }

    override fun onPause(event: PauseEvent) {
    if(event.previousState==Flowplayer.State.BUFFERING){
        flowplayer.play();
        }
    }
}