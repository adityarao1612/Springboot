package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;
    private BidService bidService;

    public void createAuction(Auction auction) {
        if(auction != null)
            auctionRepository.save(auction);
        else
            System.out.println("Auction is null");
    }
   
    // add bid to auction
    public void addBidToAuction(int auctionId, Bid bid) {
        Auction auction = auctionRepository

}