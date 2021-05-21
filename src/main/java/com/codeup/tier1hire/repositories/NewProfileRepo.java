package com.codeup.tier1hire.repositories;

import org.springframework.core.env.Profiles;

import java.util.List;

public interface NewProfileRepo {
  Object findAll();

  Object getOne(long id);

  List<Profiles> findAllByTitleIsLike(String term);
}
