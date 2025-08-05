package com.solvd.eurofoods.model;

import java.util.List;
import java.util.Scanner;

import com.solvd.eurofoods.util.IComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reviews implements IComment {
    private static final Logger logger = LoggerFactory.getLogger(Reviews.class);

    private Feedback feedback = new Feedback();
    private List<Review> reviewList;
    int star = 0;
    int[] rating = feedback.stars;

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public String toString(String s) {
        String divider = "---";
        Review review = new Review(String.valueOf(this.hashCode()), userName(), chooseRating(), feedback);
        String reviewString = review.messageId() + divider +
                review.userName() + divider +
                review.rating() + divider +
                feedback.getBody();
        return reviewString;
    }

    public String userName() {
        String n = this.userName() + "'s review:";
        return n;
    }

    @Override
    public int chooseRating() {
        // imitation of rate system. In real case there should be UI stars click handler
        try (Scanner sc = new Scanner(System.in)) {
            if (sc.hasNextInt())
                return sc.nextInt();
            else
                return 0;
        }
    }

    @Override
    public void commentPost() {
        for (int i = 0; i < 10; i++) {
            logger.info("Comment number {}", i);
        }
    }

    @Override
    public String moderation() {
        // TODO Auto-generated method stub
        return null;
    }

    public Review findReview(String searchTerm) {
        String commentText = feedback.getBody();

        return reviewList.stream()
                .filter(review ->
                        review.userName().equalsIgnoreCase(searchTerm) ||
                        (commentText != null && commentText.toLowerCase().
                                contains(searchTerm.toLowerCase()))
                )
                .findAny()
                .orElse(null);
    }

    public Review findById(String id) {
        return reviewList.stream()
                .filter(review -> review.messageId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
