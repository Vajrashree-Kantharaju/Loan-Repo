package com.project.loan.Controller;
import com.project.loan.Entity.Asset;
import com.project.loan.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping("/{accountId}/addAsset")
    public ResponseEntity<?> addAssetToAccount(@PathVariable Long accountId, @RequestBody Asset asset) {
        return assetService.addAssetToAccount(accountId,asset);
    }
    @DeleteMapping("/deleteAsset")
    public ResponseEntity<?> deleteAsset(@RequestParam Long accountId, @RequestParam Long assetId) {
        return assetService.deleteAsset(accountId, assetId);
    }
}

