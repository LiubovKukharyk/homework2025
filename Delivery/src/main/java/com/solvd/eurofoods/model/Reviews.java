package main.java.com.solvd.eurofoods.model;

import java.util.List;
import java.util.Scanner;

import main.java.com.solvd.eurofoods.util.IComment;

public class Reviews implements IComment {
	String r = this.hashcode().toString();
	private Feedback f = new Feedback();
    private List<Review> reviewList;
	int star = 0;
	int[] rating = f.stars;
	
	public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

	public String hashcode() {
		System.out.println("Message ID: "+r);
		return r;
	}

	public String equals(String hash) {
		if (dbcheck(hash))
		return hash;
		else
		return hashcode();
	}
	public String toString(String s) {
	    String divider = "---";
	    Review review = new Review(hashcode(), userName(), chooseRating(), f);
	    String reviewString = review.messageId() + divider +
                review.userName() + divider +
                review.rating() + divider +
                f.getBody();

	    if (dbcheck(reviewString)) {
	        return reviewString;
	    } else {
	        System.out.println("Such review already exists");
	        return null;
	    }
	}
	
	private boolean dbcheck (String review) {
		boolean dbn = true;
		// database check for the uniqueness of the new comment.
		// If the review is unique, dbn will be true
		return dbn;
	}

	public String userName() {
		String n = this.userName()+"'s review:";
		return n;
	}
	
	@Override
	public int chooseRating() {
		//imitation of rate system. In real case there should be UI stars click handler
			try (Scanner sc = new Scanner(System.in)) {
				if (sc.hasNextInt())
					return sc.nextInt();
				else
					return 0;
		}
	}
	@Override
	public void commentPost() {		
		for (int i=0; i<10; i++)
		{
			System.out.println ("Comment number "+i);
		}
	}

	@Override
	public String moderation() {
		// TODO Auto-generated method stub
		return null;
	}
	
    public Review findReview(String searchTerm) {

        String commentText = f.getBody();

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
