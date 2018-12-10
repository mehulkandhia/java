package com.dao;

import java.util.List;

import com.model.supplier;

public interface supplierdao {

public boolean add(supplier sup);
public boolean update(supplier sup);
public boolean delete(supplier sup);
List<supplier> supply();

public supplier getmodel(int supplierId);
}
