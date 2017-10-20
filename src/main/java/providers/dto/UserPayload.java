package providers.dto;
/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPayload {
    private String id;
    private String firstname;
    private String lastname;
    private String password;
    private UserStatus userstatus;
    private String extdata;
    private long modificationdate;
    private long creationdate;
}
