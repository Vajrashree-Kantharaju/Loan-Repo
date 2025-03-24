package com.project.loan.Service;

import com.project.loan.Entity.Account;
import com.project.loan.Entity.Asset;
import com.project.loan.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private AccountService accountService;

    public ResponseEntity<?> deleteAsset(Long accountId, Long Id) {
        Optional<Account> accountOptional = accountService.getAccountDetails(accountId);
        if (accountOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Account not found with ID: " + accountId);
        }

        Account account = accountOptional.get();
        Optional<Asset> assetOptional = assetRepository.findById(Id);

        if (assetOptional.isEmpty() || !assetOptional.get().getAccount().getAccountId().equals(accountId)) {
            return ResponseEntity.badRequest().body("Asset not found or does not belong to the specified account.");
        }

        assetRepository.deleteById(Id);
        return ResponseEntity.ok("Asset deleted successfully.");
    }


    public ResponseEntity<?> addAssetToAccount(Long accountId, Asset asset) {
        Optional<Account> accountOptional = accountService.getAccountDetails(accountId);
        if (accountOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Account not found with ID: " + accountId);
        }
        Account account = accountOptional.get();

        Optional<Asset> existingAssetOptional = account.getAssets().stream()
                .filter(a -> a.getAssetName().equalsIgnoreCase(asset.getAssetName()))
                .findFirst();

        if (existingAssetOptional.isPresent()) {
            Asset existingAsset = existingAssetOptional.get();
            existingAsset.setQuantity(existingAsset.getQuantity() + asset.getQuantity());
            assetRepository.save(existingAsset);
        } else {
            asset.setAccount(account);
            assetRepository.save(asset);
        }

        return ResponseEntity.ok("Asset processed successfully!");
    }


}