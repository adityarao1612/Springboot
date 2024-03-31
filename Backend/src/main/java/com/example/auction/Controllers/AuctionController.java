package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auction.DTOModels.BidDTO;
import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.Auction;
import com.example.auction.Models.Item;
import com.example.auction.Service.AuctionService;
import com.example.auction.Service.BidService;
import com.example.auction.Service.ItemService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private BidService bidService;

    @PostMapping("/createAuction")
    public ResponseEntity<String> createAuction(@RequestBody Auction auction,@RequestParam("itemId") Long itemId) {

        // Fetch item from database using provided itemId
        Item item = itemService.getItemById(itemId);

        // Associate the item with the auction
        auction.setItem(item);

        auctionService.createAuction(auction);

        return ResponseEntity.ok("Auction created successfully");
    }


    @GetMapping("/{auctionId}/getAllBids")
    public ResponseEntity<List<BidDTO>> getMethodName(@PathVariable Long auctionId) {
        return ResponseEntity.ok(bidService.getBidsForAuction(auctionId));
    }

    @GetMapping("/{auctionId}/getWinner")
    public ResponseEntity<UserDTO> getWinner(@PathVariable Long auctionId) {

        return ResponseEntity.ok(auctionService.getWinner(auctionId));
    }

}
