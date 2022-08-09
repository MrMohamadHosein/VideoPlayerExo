package ir.MrMohamadHosein.videoplayer

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import ir.MrMohamadHosein.videoplayer.databinding.ActivityMainBinding


val url = "https://YOUR OWN URL.mp4"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var exoPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exoPlayer = ExoPlayer.Builder(this).build()

        val mediaItem = MediaItem.fromUri( Uri.parse(url) )
        exoPlayer.setMediaItem(mediaItem)

        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        exoPlayer.play()

        binding.playerView.player = exoPlayer

    }


    override fun onDestroy() {
        super.onDestroy()

        exoPlayer.release()

    }

}