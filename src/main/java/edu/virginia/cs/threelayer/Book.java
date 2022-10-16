package edu.virginia.cs.threelayer;

public class Book {
    private final String isbn;
    private String title;
    private String authorName;
    private int weeksOnList;

    public Book(String isbn, String title, String authorName, int weeksOnList) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.weeksOnList = weeksOnList;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getWeeksOnList() {
        return weeksOnList;
    }

    public void setWeeksOnList(int weeksOnList) {
        this.weeksOnList = weeksOnList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return getIsbn().equals(book.getIsbn());
    }

    @Override
    public int hashCode() {
        return getIsbn().hashCode();
    }

    @Override
    public String toString() {
        return getTitle() + "- by " + getAuthorName() + " - on list for " + weeksOnList + " week(s) (ISBN: " + getIsbn() + ")";
    }
}
