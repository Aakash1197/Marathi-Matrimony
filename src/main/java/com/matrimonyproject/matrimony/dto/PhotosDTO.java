package com.matrimonyproject.matrimony.dto;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
@AllArgsConstructor
public class PhotosDTO {
  /*  @NotNull(message = MatrimonyConstant.PROFILE_ID_REQUIRED) // Reference constant
    private Long profileId;*/

    @NotBlank(message = MatrimonyConstant.PHOTO_URL_REQUIRED) // Reference constant
    @Size(max = 255, message = MatrimonyConstant.PHOTO_PATH_SIZE) // Reference constant
    private String imageUrl;
}
