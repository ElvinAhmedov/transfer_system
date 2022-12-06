package com.company.transfersystem.controller;

import com.company.transfersystem.dto.request.CardRequest;
import com.company.transfersystem.dto.response.CardResponse;
import com.company.transfersystem.service.business.CardBusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardBusinessService cardService;

    public CardController(CardBusinessService cardService) {
        this.cardService = cardService;
    }
    @PostMapping("/add")
    public ResponseEntity addCard (@RequestBody CardRequest cardRequest){
        cardService.saveCard(cardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }
    @GetMapping
    public ResponseEntity<List<CardResponse>> getCards(){
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCards());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CardResponse> getCard(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCard(id));
    }
    @PutMapping
    public ResponseEntity<CardResponse> updateCard(@RequestParam Long id, @RequestBody CardRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(cardService.updateCard(id,request));
    }
}
