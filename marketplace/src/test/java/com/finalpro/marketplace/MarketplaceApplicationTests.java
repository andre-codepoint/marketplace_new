package com.finalpro.marketplace;

import com.finalpro.marketplace.controller.AuthenticationController;
import com.finalpro.marketplace.controller.MarketplaceController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MarketplaceApplicationTests {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private MarketplaceController marketplaceController;

    @Test
    void contextLoads() {
        assertThat(authenticationController).isNotNull();
        assertThat(marketplaceController).isNotNull();
    }

}
