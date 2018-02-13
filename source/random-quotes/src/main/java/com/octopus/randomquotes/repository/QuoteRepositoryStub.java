package com.octopus.randomquotes.repository;

import com.octopus.randomquotes.model.Quote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuoteRepositoryStub {

    private static Map<Long, Quote> quotes = new HashMap<Long, Quote>();

    static {
        quotes.put(1L, new Quote(1L, "Here's to the crazy ones. The misfits. The rebels. The troublemakers. The round pegs in the square holes. The ones who see things differently. They're not fond of rules. And they have no respect for the status quo. You can quote them, disagree with them, glorify or vilify them. About the only thing you can't do is ignore them. Because they change things. They push the human race forward. And while some may see them as the crazy ones, we see genius. Because the people who are crazy enough to think they can change the world, are the ones who do.", "Rob Siltanen"));
        quotes.put(2L, new Quote(2L, "Everything should be made as simple as possible, but not simpler.", "Albert Einstein"));
        quotes.put(3L, new Quote(3L, "Here is one of the few effective keys to the design problem: the ability of the designer to recognize as many of the constraints as possible; his willingness and enthusiasm for working within these constraints.", "Charles Eames"));
        quotes.put(4L, new Quote(4L, "If I had asked people what they wanted, they would have said faster horses.", "Henry Ford"));
        quotes.put(5L, new Quote(5L, "Perfection is achieved not when there is nothing more to add, but when there is nothing left to take away.", "Antoine de Saint-Exupery"));
        quotes.put(6L, new Quote(6L, "Have no fear of perfection, you'll never reach it.", "Salvador Dali"));
        quotes.put(7L, new Quote(7L, "Only those who attempt the absurd will achieve the impossible.", "M.C. Escher"));
        quotes.put(8L, new Quote(8L, "Design is so simple. That's why it's so complicated.", "Paul Rand"));
        quotes.put(9L, new Quote(9L, "Any product that needs a manual to work is broken.", "Elon Musk"));
        quotes.put(10L, new Quote(10L, "The work you do while you procrastinate is probably the work you should be doing for the rest of your life.", "Jessica Hische"));
    }

    public static List<Quote> list() {
        return new ArrayList(quotes.values());
    }

    public static Quote create(Quote quote) {
        throw new UnsupportedOperationException("Stub method is not supported");
    }

    public static Quote get(Long id) {
        return quotes.get(id);
    }

    public static Quote update(Long id, Quote quote) {
        throw new UnsupportedOperationException("Stub method is not supported");
    }

    public static Quote delete(Long id) {
        throw new UnsupportedOperationException("Stub method is not supported");
    }

}

