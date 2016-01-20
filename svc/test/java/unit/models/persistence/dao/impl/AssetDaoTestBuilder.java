package models.persistence.dao.impl;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;
import org.mockito.Mock;
import org.mockito.Mockito;
import play.api.mvc.QueryStringBindable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AssetDaoTestBuilder {
    private AssetEntity asset;

    private EntityManagerProvider mockEntityManagerProvider;

    private EntityManager mockEntityManager;

    private Query mockQuery;

    private List<AssetEntity> mockResultList;

    public void createAssetTestObjects() {
        mockEntityManager = Mockito.mock(EntityManager.class);
        mockEntityManagerProvider = Mockito.mock(EntityManagerProvider.class);
        mockQuery = Mockito.mock(Query.class);
        mockResultList = new ArrayList<>();

        Mockito.when(mockEntityManagerProvider.getEntityManager()).thenReturn(mockEntityManager);
        Mockito.when(mockEntityManager.createQuery(Mockito.anyString())).thenReturn(mockQuery);
        Mockito.when(mockQuery.getResultList()).thenReturn(mockResultList);

        //Create the assetEntity
        asset = new AssetEntity();
    }

    public AssetEntity getAsset() {
        return asset;
    }

    public EntityManagerProvider getMockEntityManagerProvider() {
        return mockEntityManagerProvider;
    }

    public EntityManager getMockEntityManager() {
        return mockEntityManager;
    }

    public List<AssetEntity> getMockResultList()
    {
        return mockResultList;
    }
}
