package com.husnaBiyikli.Library.ServiceImpl;

import java.util.List;

import com.husnaBiyikli.Library.Entitys.publishingHouses;

public interface publishingHouseImpl {
    List<publishingHouses> getAllHouses();

    void saveHouse(publishingHouses houses);

    publishingHouses getPublishingHouses(String name);

    void delete(Long id);

    publishingHouses getHouseById(Long id);

}
