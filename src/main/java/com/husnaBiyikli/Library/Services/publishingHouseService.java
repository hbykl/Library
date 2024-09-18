package com.husnaBiyikli.Library.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.husnaBiyikli.Library.Entitys.publishingHouses;
import com.husnaBiyikli.Library.Repositorys.publishingHouseRepository;
import com.husnaBiyikli.Library.ServiceImpl.publishingHouseImpl;

@Service
public class publishingHouseService implements publishingHouseImpl {

    @Autowired
    publishingHouseRepository publishingHouseRepository;

    public publishingHouseService(publishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }

    @Override
    public List<publishingHouses> getAllHouses() {
        return publishingHouseRepository.findAll();
    }

    @Override
    public void saveHouse(publishingHouses houses) {
        publishingHouseRepository.save(houses);
    }

    @Override
    public publishingHouses getPublishingHouses(String name) {
        return publishingHouseRepository.findByPublishingHouses(name).orElse(null);
    }

    @Override
    public void delete(Long id) {
        publishingHouseRepository.deleteById(id);
    }

    @Override
    public publishingHouses getHouseById(Long id) {
        return publishingHouseRepository.findById(id).orElse(null);
    }
}
