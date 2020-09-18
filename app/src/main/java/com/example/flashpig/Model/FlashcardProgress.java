package com.example.flashpig.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Shows cards after the difficulty that was chosen when playing the game Flashcard.
 *
 * @author Wendy
 * @version 2020-09-14
 */
public class FlashcardProgress {
    private Deck deck;
    private List<Card> easyList = new ArrayList<>();
    private List<Card> mediumList = new ArrayList<>();
    private List<Card> hardList = new ArrayList<>();
    private List<Card> nothingList = new ArrayList<>();

    /**
     * FlashcardProgress constructor
     * @param deck The deck to use
     */
    public FlashcardProgress(Deck deck) {
        this.deck = deck;
        sortList(deck);
    }

    private void sortList(Deck deck) {
        for (Card card : deck.deck) {
            switch (card.getDifficulty().toString()) {
                case "EASY": easyList.add(card);
                case "MEDIUM": mediumList.add(card);
                case "HARD": hardList.add(card);
                default: nothingList.add(card);
            }
        }
    }

    /**
     * Show the cards after which difficulty is choosen. The cards are picked out from the deck and shown in the view.
     * @param difficulties The choosen difficulty to show.
     * @return Returns the list with cards of the choosen difficulty.
     */
    public List<Card> showCards(Difficulties difficulties) {
        switch (difficulties) {
            case EASY: return easyList;
            case MEDIUM: return mediumList;
            case HARD: return hardList;
            default: return nothingList;
        }
    }

    /**
     * Moves the card to another difficulty.
     * @param card The card to be moved.
     * @param difficulty The difficulty the card is to change to.
     */
    public void moveCard(Card card, Difficulties difficulty) {
        if (!card.getDifficulty().equals(difficulty)) {
            card.setDifficulty(difficulty);
        }
    }

    /**
     * Basically resets the card so that it is neither easy, medium or hard.
     * @param card The card to be reset.
     */
    public void deleteCard(Card card) {
        card.setDifficulty(Difficulties.NOTHING);
    }

}
