package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Turn {
    public final ArrayList<BuyDeck> buyDecks = new ArrayList<>();
    private final TurnStatus turnStatus = new TurnStatus();
    private final Hand hand;
    private final Deck deck;
    private final DiscardPile discardPile;
    private final Play play;
    public boolean isActionPhase = true;

    public Turn() {
        this.turnStatus.actions = 1;
        this.turnStatus.buys = 1;
        this.turnStatus.coins = 0;
        ArrayList<CardInterface> baseCards = new ArrayList<>();
        buyDecks.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_MARKET));
        buyDecks.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_ESTATE));
        buyDecks.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_COPPER));
        buyDecks.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_SMITHY));
        buyDecks.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_VILLAGE));
        buyDecks.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_FESTIVAL));
        buyDecks.add(new BuyDeck(10, GameCardType.GAME_CARD_TYPE_LABORATORY));
        for (int i = 0; i < 7; i++) {
            GameCard gameCard = new GameCard(GameCardType.GAME_CARD_TYPE_COPPER);
            baseCards.add(gameCard);
        }
        for (int i = 0; i < 3; i++) {
            GameCard gameCard = new GameCard(GameCardType.GAME_CARD_TYPE_ESTATE);
            baseCards.add(gameCard);
        }
        discardPile = new DiscardPile(new ArrayList<>());
        Collections.shuffle(baseCards); //len nech ich nemas presne v tom poradi, zda sa mi ze si to potom v decku nemiesala
        deck = new Deck(baseCards, discardPile);
        hand = new Hand(deck);
        play = new Play();
    }

    public boolean playCard(int idx) {
        /* toto ti podla mna neprejde a vyhodi ti vynimku ked budes mat malo kariet, lebo v play odstranujes kartu z 
        idx miesta ale potom ju zase chces hned riadok pod tym v getCardFromHand. Ak som to dobre pozrela (pochopila) tak na 
        idx uz bude ina karta, pripadne koniec pola.*/
        
        CardInterface card = hand.getCardFromHand(idx); //takto si ju ulozis skor nez ju v hand.play vymazes
        if (hand.play(idx)) {
         // CardInterface card = hand.getCardFromHand(idx);
            play.putTo(card);
            card.evaluate(turnStatus);
            hand.handCards.addAll(deck.draw(card.cardType().getPlusCards()));
            if (hand.isActionCard(idx)) {
                turnStatus.actions--;
            }
            return true;
        }
        return false;
    }

    public boolean buyCard(int buyDeckIdx) {
        if (turnStatus.buys > 0 && buyDeckIdx < buyDecks.size() && 
            buyDeckIdx >= 0 && buyDecks.get(buyDeckIdx).cardCount > 0 && 
            buyDecks.get(buyDeckIdx).deckTypeCard.getCost() <= turnStatus.coins) {
            
            turnStatus.buys--;
            buyDecks.get(buyDeckIdx).buy();
            CardInterface card = buyDecks.get(buyDeckIdx).getCardFromBuyDeck();
            discardPile.addCard(card);
            return true;
        }
        return false;
    }

    /*toto je zajimave ako robis, si si to mohla rovno v turn statuse menit ked ich kupis. 
    Lebo sa mi zda ze tie s ktorymi zacinas body aj tak nemaju, takze k tym "bodovym" sa inak aj tak nemas ako dostat */
    
    public int pointsCount() {
        int points = 0;
        points += hand.getPoints() + deck.getPoints() + discardPile.getPoints() + play.getPoints();
        return points;
    }

    public void throwToDiscardPile() {
        discardPile.addCards(hand.throwToDiscardPile());
        discardPile.addCards(play.throwToDiscardPile());
    }
}
