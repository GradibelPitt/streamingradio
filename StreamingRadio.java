
public interface StreamingRadio {

    /**
     * Adds a new song to the system.
     *
     * @param song The song object to be added. Must not be null.
     * @throws IllegalStateException if the system cannot accept new songs
     *         (e.g., due to a capacity limit).
     * @throws NullPointerException if the song is null.
     */
    void addSong(Song song) throws IllegalStateException, NullPointerException;

    /**
     * Removes an existing song from the system.
     *
     * @param song The song object to be removed. Must not be null.
     * @throws IllegalArgumentException if the song does not exist in the system.
     * @throws NullPointerException if the song is null.
     */
    void removeSong(Song song) throws IllegalArgumentException, NullPointerException;

    /**
     * Adds an existing song to the playlist for an existing radio station.
     *
     * @param song The song object to be added to the station's playlist. Must not be null.
     * @param station The station to which the song should be added. Must not be null.
     * @throws IllegalArgumentException if the song or station is invalid, or the song is already in the playlist.
     * @throws NullPointerException if either the song or the station is null.
     */
    void addToStation(Song song, Station station) throws IllegalArgumentException, NullPointerException;

    /**
     * Removes a song from the playlist for a radio station.
     *
     * @param song The song object to be removed from the station's playlist. Must not be null.
     * @param station The station from which the song should be removed. Must not be null.
     * @throws IllegalArgumentException if the song is not in the station's playlist.
     * @throws NullPointerException if either the song or the station is null.
     */
    void removeFromStation(Song song, Station station) throws IllegalArgumentException, NullPointerException;

    /**
     * Sets a user's rating for a song, as a number of stars from 1 to 5.
     *
     * @param user The user who rates the song. Must not be null.
     * @param song The song being rated. Must not be null.
     * @param rating The number of stars assigned by the user, from 1 to 5.
     * @throws IllegalArgumentException if the rating is not between 1 and 5.
     * @throws NullPointerException if either the user or the song is null.
     */
    void rateSong(User user, Song song, int rating) throws IllegalArgumentException, NullPointerException;

    /**
     * Clears a user's rating on a song.
     *
     * @param user The user whose rating should be cleared. Must not be null.
     * @param song The song from which the rating should be cleared. Must not be null.
     * @throws IllegalArgumentException if the user does not have a rating on this song.
     * @throws NullPointerException if either the user or the song is null.
     */
    void clearRating(User user, Song song) throws IllegalArgumentException, NullPointerException;

    /**
     * Predicts the rating a user will assign to a song that they have not yet
     * rated, as a number of stars from 1 to 5.
     *
     * @param user The user for whom the rating is to be predicted. Must not be null.
     * @param song The song for which the rating is to be predicted. Must not be null.
     * @return The predicted rating, from 1 to 5.
     * @throws UnsupportedOperationException if the prediction cannot be performed.
     * @throws NullPointerException if either the user or the song is null.
     */
    int predictRating(User user, Song song) throws UnsupportedOperationException, NullPointerException;

    /**
     * Suggests a song for a user that they are predicted to like.
     *
     * @param user The user for whom a song is to be suggested. Must not be null.
     * @return The suggested song.
     * @throws UnsupportedOperationException if no suitable song can be suggested.
     * @throws NullPointerException if the user is null.
     */
    Song suggestSong(User user) throws UnsupportedOperationException, NullPointerException;
}