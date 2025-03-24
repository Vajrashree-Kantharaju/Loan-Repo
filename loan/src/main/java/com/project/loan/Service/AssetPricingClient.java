package com.project.loan.Service;

import com.project.loan.Entity.Asset;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asset-pricing-client", url = "http://10.104.237.59:8080/api/assets")
public interface AssetPricingClient {
    @GetMapping("/{assetId}")
    Asset getAssetPrice(@PathVariable("assetId") Long assetId);
}

