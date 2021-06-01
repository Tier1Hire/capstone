package com.codeup.tier1hire.services;

import com.codeup.tier1hire.models.Image;
import com.codeup.tier1hire.models.User;
import com.codeup.tier1hire.repositories.ImageRepository;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {

    public UserService(ImageRepository imageDao) {
        this.imageDao = imageDao;
    }

    private final ImageRepository imageDao;

    public String profileImage(User currentUser){
        Image userImage = imageDao.findByOwner(currentUser);
        if (userImage.getImageURL() == null){
            userImage.setImageURL("https://cdn.filestackcontent.com/7eJrnYVTSQIwFPNGXgnx");
            imageDao.save(userImage);
            return userImage.getImageURL();
        }
        return userImage.getImageURL();
    }
}

