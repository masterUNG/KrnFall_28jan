package com.example.krnfallex.krnfall;

import android.support.v7.app.AppCompatActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

    public class youtube extends YouTubeBaseActivity
implements YouTubePlayer.OnInitializedListener{

public static final String DEVELOPER_KEY = "AIzaSyBmIqvgPK1QhuXXUOnwD-i3ChFWMs4nQB8";
private static final String VIDEO_ID = "m0jyqB_t2B4";
private static final int RECOVERY_DIALOG_REQUEST = 1;

        YouTubePlayerFragment myYouTubePlayerFragment;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_youtube);
    myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubeplayerfragment);
myYouTubePlayerFragment.initialize(DEVELOPER_KEY, this);
}
@Override
public void onInitializationFailure(YouTubePlayer.Provider provider,
YouTubeInitializationResult errorReason) {
if (errorReason.isUserRecoverableError()) {
errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
} else {
String errorMessage = String.format(
"There was an error initializing the YouTubePlayer (%1$s)",
errorReason.toString());
Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
}
}
@Override
public void onInitializationSuccess(Provider provider, YouTubePlayer player,
boolean wasRestored) {
if (!wasRestored) {
player.cueVideo(VIDEO_ID);
}
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode == RECOVERY_DIALOG_REQUEST) {
// Retry initialization if user performed a recovery action
getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
}
}
protected YouTubePlayer.Provider getYouTubePlayerProvider() {
return (YouTubePlayerView)findViewById(R.id.youtubeplayerfragment);
}
}