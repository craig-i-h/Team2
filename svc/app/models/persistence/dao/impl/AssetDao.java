package models.persistence.dao.impl;

import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.ItemEntity;

import javax.inject.Inject;

public class AssetDao extends GenericDao<ItemEntity>
{
    @Inject
    public AssetDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    //Add methods for any Asset Entity specific database accesses here.
}
