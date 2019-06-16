package dev.bryanlindsey.trivia

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import org.koin.core.KoinComponent
import org.koin.core.inject

object DynamicValues : KoinComponent {

    private const val PLAY_AGAIN_TEXT_KEY = "play_again_text"
    private const val QUIT_TEXT_KEY = "quit_text"

    private val defaultValues = mapOf(
        PLAY_AGAIN_TEXT_KEY to "Play again",
        QUIT_TEXT_KEY to "Quit"
    )

    private val remoteConfig by inject<FirebaseRemoteConfig>()

    init {
        remoteConfig.setDefaults(defaultValues)
    }

    val playAgainText: String? = remoteConfig.getString(PLAY_AGAIN_TEXT_KEY)
    val quitText: String? = remoteConfig.getString(QUIT_TEXT_KEY)
}