package cz.optimization.odpadky.room_data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PlaceWatchedDao {

    @Insert(onConflict = REPLACE)
    void insertSinglePlace(PlaceWatched placeWatched);

    @Query("select * from PlaceWatched WHERE mPlaceId = :placeId")
    PlaceWatched fetchOnePlacebyPlaceId(String placeId);

    @Query("select * from PlaceWatched")
    LiveData<List<PlaceWatched>> fetchAllPlaces();

    @Delete
    void deletePlace(PlaceWatched placeWatched);

}


