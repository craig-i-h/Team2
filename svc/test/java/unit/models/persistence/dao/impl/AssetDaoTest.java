package models.persistence.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.*;
import java.sql.Connection;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;
import org.junit.Before;
import org.junit.Test;


public class AssetDaoTest
{
    private AssetDao assetDao;
    private AssetEntity assetEntity;
    private Database database;

    @Before
    public void executedBefore()
    {
        assetDao = new AssetDao(new EntityManagerProvider());
        assetEntity = new AssetEntity();

        assetEntity.setId(1L);
        assetEntity.setAssetOwner("Jordan");
        assetEntity.setAssetType("Mobile");
        assetEntity.setAdditionalInformation("Add. Info");
    }

    @Test
    public void testAssetDaoOwner()
    {
        long id = assetDao.create(assetEntity).getId();
        assertEquals(assetDao.find(id).getAssetOwner(), "Jordan");
    }

    @Test
    public void testAssetDaoType()
    {
        long id = assetDao.create(assetEntity).getId();
        assertEquals(assetDao.find(id).getAssetType(), "Mobile");
    }

    @Test
    public void testAssetDaoAdditionalInfo()
    {
        long id = assetDao.create(assetEntity).getId();
        assertEquals(assetDao.find(id).getAdditionalInformation(), "Add. Info");
    }
}
