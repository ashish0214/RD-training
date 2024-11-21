package CalssesAndObject.Task3;

public class Movie {
    private String movieTitle;
    private String director;
    private int releaseYear;
    private String genre;
    private float averageRating;

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    Movie(String title, String director, int year, String genre, float average){
        movieTitle=title;
        this.director=director;
        releaseYear=year;
        this.genre=genre;
        this.averageRating=average;
    }


    float updateAverageRating(float rate){
        averageRating+=rate;
        averageRating/=2;
        return averageRating;
    }
    float updateAverageRating(){
        return averageRating;
    }

    float add_Review(String comment){
      return updateAverageRating();
    }
    float add_Review(float rate){
        return this.updateAverageRating(rate);
    }



    String get_Movie_Details(){
        return "Title:"+this.movieTitle+"  Directors:"+this.director+"  Release date:"+releaseYear+"  Genre:"+genre+"   Average Rating:"+averageRating ;
    }
}
