package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.repository.IUserRepository

class UpdatePictureUseCase(private val userRepository: IUserRepository) {

    suspend operator fun invoke(picture: String, firstName: String) =
        userRepository.updatePicture(picture = picture, firstName = firstName)

}