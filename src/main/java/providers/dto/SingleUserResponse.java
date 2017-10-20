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
public class SingleUserResponse {
    private UserPayload Item;

    public UserPayload getItem() {
        return Item;
    }

    public void setItem(UserPayload item) {
        Item = item;
    }
}

