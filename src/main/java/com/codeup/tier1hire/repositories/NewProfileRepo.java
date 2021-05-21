package com.codeup.tier1hire.repositories;

import com.codeup.tier1hire.models.NewProfile;
import org.springframework.core.env.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewProfileRepo extends JpaRepository <NewProfile,Long> {

  List<Profiles> findAllByTitleIsLike(String term);
}
