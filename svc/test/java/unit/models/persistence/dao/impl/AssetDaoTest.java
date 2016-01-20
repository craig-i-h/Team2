package models.persistence.dao.impl;

import static org.junit.Assert.*;

import org.junit.After;
import play.Logger;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.*;
import java.sql.Connection;
import java.util.List;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;
import org.junit.Before;
import org.junit.Test;
import play.db.jpa.JPA;
import org.mockito.*;

import javax.persistence.EntityManager;

public class AssetDaoTest
{
    AssetDaoTestBuilder testBuilder = new AssetDaoTestBuilder();

    @Test
    public void testCreateAsset() {
        testBuilder.createAssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();

        assetDao.create(assetEntity);

        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testDeleteAsset() {
        testBuilder.createAssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();
        assetDao.create(assetEntity);
        assetDao.delete(assetEntity.getId());
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testUpdateAsset() {
        testBuilder.createAssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();
        assetDao.create(assetEntity);
        assetDao.update(assetEntity);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testFindAsset() {
        testBuilder.createAssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();
        assetDao.create(assetEntity);
        assetDao.find(assetEntity.getId());
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testListAssets() {
        testBuilder.createAssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        List<AssetEntity> assetEntities = assetDao.list();

        assertEquals(testBuilder.getMockResultList(), assetEntities);
    }
}
