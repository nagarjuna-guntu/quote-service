package com.polarbookshop.quote_service.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarbookshop.quote_service.domain.Genre;
import com.polarbookshop.quote_service.domain.Quote;
import com.polarbookshop.quote_service.domain.QuoteService;

@RestController
@RequestMapping("quotes")
public class QuoteController {
	private final QuoteService quoteService;
	
	public QuoteController(QuoteService quoteService) {
		this.quoteService = quoteService;
	}
	
	@GetMapping
	public Iterable<Quote> getAllQuotes() {
		return quoteService.getAllQuotes();
	}

	@GetMapping("/random")
	public Quote getRandomQuote() {
		return quoteService.getRandomQuote();
	}

	@GetMapping("/random/{genre}")
	public Quote getRandomQuote(@PathVariable Genre genre) {
		return quoteService.getRandomQuoteByGenre(genre);
	}

}
