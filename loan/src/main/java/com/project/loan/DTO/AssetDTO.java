package com.project.loan.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AssetDTO {
    private Long assetId;
    private Long Id;
    private String assetName;
    private Long assetPrice;

}
