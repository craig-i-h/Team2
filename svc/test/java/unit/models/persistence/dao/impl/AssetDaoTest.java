package models.persistence.dao.impl;

import static org.junit.Assert.*;
import java.util.List;
import models.persistence.entities.AssetEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import javax.persistence.EntityManager;

public class AssetDaoTest
{
    private AssetDaoTestBuilder testBuilder = new AssetDaoTestBuilder();
    private AssetDao assetDao;
    private AssetEntity assetEntity;
    private EntityManager mockEntityManager;

    @Before
    public void initMock()
    {
        testBuilder.createAssetTestObjects();
        assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        assetEntity = testBuilder.getAsset();
        mockEntityManager = testBuilder.getMockEntityManager();
    }

    @Test
    public void testCreateAsset()
    {
        assetDao.create(assetEntity);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testDeleteAsset()
    {
        assetDao.create(assetEntity);
        assetDao.delete(assetEntity.getId());
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testUpdateAsset()
    {
        assetDao.create(assetEntity);
        assetDao.update(assetEntity);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testFindAsset()
    {
        assetDao.create(assetEntity);
        assetDao.find(assetEntity.getId());
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testListAssets()
    {
        List<AssetEntity> assetEntities = assetDao.list();
        assertEquals(testBuilder.getMockResultList(), assetEntities);
    }
}
