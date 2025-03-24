package com.project.loan.Service;

import com.project.loan.Entity.Account;
import com.project.loan.Entity.Asset;
import com.project.loan.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private final RestTemplate restTemplate;
    private final String assetPricingServiceUrl;
    private static final double LOAN_PERCENTAGE = 0.70;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    public LoanService(RestTemplate restTemplate, @Value("${asset.pricing.service.url}") String assetPricingServiceUrl) {
        this.restTemplate = restTemplate;
        this.assetPricingServiceUrl = assetPricingServiceUrl;
    }

    public Double calculateLoanAmount(Long accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isEmpty()) {
            throw new RuntimeException("Account not found");
        }

        double totalAssetPrice = 0;
        List<Asset> assets = accountOptional.get().getAssets();
        for (Asset asset : assets) {
            try {
                String url = String.format("%s/%d", assetPricingServiceUrl, asset.getId());
                ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);
                Double price = response.getBody() != null ? response.getBody() : 0.0;
                totalAssetPrice += (price * asset.getQuantity());
            } catch (Exception e) {
                System.err.println("Failed to fetch price for asset ID: " + asset.getId() + " - " + e.getMessage());
            }

        }

        return totalAssetPrice * LOAN_PERCENTAGE;

    }
}
