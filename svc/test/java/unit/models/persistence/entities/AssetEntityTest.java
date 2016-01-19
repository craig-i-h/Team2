package models.persistence.entities;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class AssetEntityTest
{
    private AssetEntity assetEntity;

    @BeforeClass
    public void executedBeforeEach()
    {
        assetEntity = new AssetEntity();
    }


    @Test
    public void testGetId()
    {
        assetEntity.setId(1L);
        assertEquals(assetEntity.getId(), 1L);
    }

    @Test
    public void testGetAssetOwner()
    {
        assetEntity.setAssetOwner("Jordan");
        assertEquals(assetEntity.getAssetOwner(), "Jordan");
    }

    @Test
    public void testGetAssetType()
    {
        assetEntity.setAssetType("Computer");
        assertEquals(assetEntity.getAssetOwner(), "Computer");
    }

    @Test
    public void testGetAdditionalInformation()
    {
        assetEntity.setAdditionalInformation("Broken hard-drive");
        assertEquals(assetEntity.getAdditionalInformation(), "Broken hard-drive");
    }
}
