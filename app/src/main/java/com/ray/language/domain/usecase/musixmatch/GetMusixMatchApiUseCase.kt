package com.ray.language.domain.usecase.musixmatch

import com.ray.language.BuildConfig
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetMusixMatchApiUseCase @Inject constructor() {
    operator fun invoke(): String {
        return BuildConfig.MUSIX_MATCH_API_KEY
    }
}