package models.services.asset;


import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.persistence.dao.impl.AssetDaoTestBuilder;
import models.services.UnavailableServiceOperation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import play.Logger;

import static org.junit.Assert.*;

public class AssetServiceTest
{
    private AssetService assetService;
    private AssetServiceTestBuilder assetServiceTestBuilder;

    @Before
    public void init()
    {
        assetServiceTestBuilder = new AssetServiceTestBuilder();
        assetServiceTestBuilder.createAssetServiceMockTest();

        assetService = new AssetService(
                new UnavailableServiceOperation(new JSONHelper()),
                assetServiceTestBuilder.getMockCreateAssetServiceOperation(),
                assetServiceTestBuilder.getListAssetServiceOperation(),
                assetServiceTestBuilder.getMockUpdateAssetServiceOperation(),
                assetServiceTestBuilder.getMockDeleteAssetServiceOperation(),
                assetServiceTestBuilder.getMockGetAssetServiceOperation(),
                new JSONHelper()
        );
    }

    @Test
    public void testCreateAsset()
    {
        JsonNode jsonNode = assetService.create(assetServiceTestBuilder.getMockJsonNode());
        assertEquals(assetServiceTestBuilder.getMockJsonNode(), jsonNode);
    }

    @Test
    public void testDeleteAsset()
    {
        JsonNode jsonNode = assetService.delete(assetServiceTestBuilder.getMockJsonNode());
        assertEquals(assetServiceTestBuilder.getMockJsonNode(), jsonNode);
    }

    @Test
    public void testGetAsset()
    {
        JsonNode jsonNode = assetService.find(assetServiceTestBuilder.getMockJsonNode());
        assertEquals(assetServiceTestBuilder.getMockJsonNode(), jsonNode);
    }

    @Test
    public void testUpdateAsset()
    {
        JsonNode jsonNode = assetService.update(assetServiceTestBuilder.getMockJsonNode());
        assertEquals(assetServiceTestBuilder.getMockJsonNode(), jsonNode);
    }

    @Test
    public void testListAssets()
    {
        JsonNode jsonNode = assetService.list();
        assertEquals(new JSONHelper().toJson(""), jsonNode);
    }
}
