package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import java.util.List;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;
    

    @Transactional
    public void createAuction(Auction auction) {
        // Additional business logic if needed
        auctionRepository.save(auction);
    }

    // Other methods related to auction business logic can be added here
}
