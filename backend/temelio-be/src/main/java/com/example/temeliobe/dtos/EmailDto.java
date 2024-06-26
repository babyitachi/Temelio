package com.example.temeliobe.dtos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class EmailDto {
    private String senderEmailId;
    private String senderEmailCCId;
    private String senderEmailBCCId;
    private List<String> nonProfitEmailIds;
}
