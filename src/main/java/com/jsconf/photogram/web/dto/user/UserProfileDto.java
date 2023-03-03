package com.jsconf.photogram.web.dto.user;

import com.jsconf.photogram.domain.user.User;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class UserProfileDto {
    private boolean pageOwnerState;
    private int imageCount;
    private User user;
}
