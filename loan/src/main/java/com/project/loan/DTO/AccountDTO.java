package com.project.loan.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AccountDTO {
    private Long accountId;
    private String userName;
    private String email;
}
